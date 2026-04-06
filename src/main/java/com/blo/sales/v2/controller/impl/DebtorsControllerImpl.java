package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IDebtorsController;
import com.blo.sales.v2.controller.IDebtorsSalesController;
import com.blo.sales.v2.controller.IProductsController;
import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.controller.pojos.PojoIntDebtor;
import com.blo.sales.v2.controller.pojos.PojoIntSaleProductData;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtors;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtorsDetails;
import com.blo.sales.v2.model.IDebtorsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.util.ArrayList;

@Singleton
public class DebtorsControllerImpl implements IDebtorsController {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsControllerImpl.class.getName());
    
    @Inject
    private IDebtorsModel model;
    
    @Inject
    private IProductsController productsController;
    
    @Inject
    private ISalesController salesController;
    
    @Inject
    private IDebtorsSalesController debtorsSales;

    @Inject
    private IDBTransactionManagerController transactionManager;
    
    @Override
    public WrapperPojoIntDebtors getAllDebtors() throws BloSalesV2Exception {
        return model.getAllDebtors();
    }
    
    @Override
    public PojoIntDebtor saveDebtor(PojoIntDebtor debtor) throws BloSalesV2Exception {
        transactionManager.disableAutocommit();
        return model.saveDebtor(debtor);
    }

    @Override
    public PojoIntDebtor getDebtorById(long idDebtor) throws BloSalesV2Exception {
        logger.info("recuperando deudor %s", idDebtor);
        return model.getDebtorById(idDebtor);
    }

    @Override
    public PojoIntDebtor updateDebtor(PojoIntDebtor debtor, long idDebtor) throws BloSalesV2Exception {
        logger.info("actualizando deudor %s", String.valueOf(debtor));
        transactionManager.disableAutocommit();
        return model.updateDebtor(debtor, idDebtor);
    }

    @Override
    public PojoIntDebtor addPayment(BigDecimal pay, long idUser, long idDebtor) throws BloSalesV2Exception {
        try {
            transactionManager.disableAutocommit();
            final var debtorPaymentAdded = addPaymentNotCommitEnabled(pay, idUser, idDebtor);
            logger.info("Deudor actualizado %s", String.valueOf(debtorPaymentAdded));
            transactionManager.doCommit();
            return debtorPaymentAdded;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            transactionManager.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            transactionManager.enableAutocommit();
        }
    }

    @Override
    public WrapperPojoIntDebtorsDetails getDebtorsDetails() throws BloSalesV2Exception {
        logger.info("recuperando detalles de deudores");
        return model.getDebtorsDetails();
    }

    @Override
    public void deleteDebtor(long idDebtor) throws BloSalesV2Exception {
        logger.info("eliminando deudor por id = %s", idDebtor);
        transactionManager.disableAutocommit();
        model.deleteDebtor(idDebtor);
    }

    @Override
    public PojoIntDebtor addPaymentNotCommitEnabled(BigDecimal pay, long idUser, long idDebtor) throws BloSalesV2Exception {
        transactionManager.disableAutocommit();
        final var debtorFound = getDebtorById(idDebtor);

        BloSalesV2Utils.validateRule(debtorFound == null, BloSalesV2Utils.CODE_DEBTOR_NOT_FOUND, BloSalesV2Utils.DEBTOR_NOT_FOUND);

        logger.info("deudor encontrado %s", String.valueOf(debtorFound));
        // se registra como venta
        final var productPay = productsController.getProductById(BloSalesV2Utils.getIdPaymentProduct());
        final var productsLst = new ArrayList<PojoIntSaleProductData>();
        final var item = new PojoIntSaleProductData();
        item.setIdProduct(productPay.getIdProduct());
        item.setPrice(productPay.getPrice());
        item.setQuantityOnSale(BigDecimal.ZERO);
        item.setProductBuyTotal(pay);
        productsLst.add(item);
        final var saleSaved = salesController.registerSaleCommitNotEnabled(pay, productsLst, idUser);
        logger.info("venta guardada por pago de deudor %s", String.valueOf(saleSaved));
        // validar que el pago no cubre toda la deuda
        if (pay.compareTo(debtorFound.getDebt()) < 0) {
            logger.info("pago es menor que la deuda");
            final var amount = debtorFound.getDebt().subtract(pay);
            logger.info("nuevo monto ", amount);
            final var payments = BloSalesV2Utils.getPartialPayment(pay);
            debtorFound.setPayments(debtorFound.getPayments() + payments);
            debtorFound.setDebt(amount);
            updateDebtor(debtorFound, idDebtor);
            // se agrega para utilizar el id de la venta para registrar tipo de pago
            debtorFound.setIdSale(saleSaved.getIdSale());
            return debtorFound;
        }
        // pago completo
        logger.info("pago completo");
        debtorFound.setDebt(BigDecimal.ZERO);
        debtorFound.setPayments(BloSalesV2Utils.EMPTY_STRING);
        debtorsSales.deleteRelationhip(idDebtor);
        deleteDebtor(idDebtor);
        final var debtorTmp = new PojoIntDebtor();
        // se agrega para utilizar el id de la venta para registrar tipo de pago
        debtorTmp.setIdSale(saleSaved.getIdSale());
        logger.info("regresando solamente el id de la venta registrada %s", saleSaved.getIdSale());
        return debtorTmp;
    }
}
