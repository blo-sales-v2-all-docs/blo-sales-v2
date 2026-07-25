package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ICashboxController;
import com.blo.sales.v2.controller.ICashboxesOrdersVendorsController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import jakarta.inject.Singleton;
import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.IUserController;
import com.blo.sales.v2.controller.pojos.PojoIntCashbox;
import com.blo.sales.v2.controller.pojos.PojoIntCashboxOrderVendor;
import com.blo.sales.v2.controller.pojos.PojoIntNote;
import com.blo.sales.v2.controller.pojos.enums.CashboxStatusIntEnum;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypeNoteIntEnum;
import com.blo.sales.v2.model.IOrdersVendorsModel;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;

@Singleton
public class OrdersVendorsControllerImpl implements IOrdersVendorsController {
    
    private static final GUILogger logger = GUILogger.getLogger(OrdersVendorsControllerImpl.class.getName());
    
    @Inject
    private IUserController userController;
    
    @Inject
    private IOrdersVendorsModel model;
    
    @Inject
    private IDBTransactionManagerController dbTransactionManager;
    
    @Inject
    private ICashboxController cashboxController;
    
    @Inject
    private ICashboxesOrdersVendorsController cashboxesOrdersVendors;

    @Override
    public PojoIntOrderVendor highOrder(PojoIntOrderVendor order) throws BloSalesV2Exception {
        try {
            // desactivar la funcion para guardar en la db
            dbTransactionManager.disableAutocommit();
            logger.info("guardando orden %s", String.valueOf(order));
            // validar que sea fecha valida
            final var deadLine = LocalDate.parse(order.getDeadline());
            final var now = LocalDate.now();
            BloSalesV2Utils.validateRule(deadLine.isBefore(now), BloSalesV2Utils.CODE_ORDER_IS_BEFORE_NOW, BloSalesV2Utils.ERROR_ORDER_IS_BEFORE_NOW);
            // setter invoice como PENDING
            order.setStatusOrder(StatusMovementProviderIntEnum.PENDIG);
            order.setTimestamp(BloSalesV2Utils.getTimestamp());
            order.setInvoice(StatusMovementProviderIntEnum.PENDIG.toString());
            order.setPaymentType(BloSalesV2Utils.N_A);
            // se guarda orden
            final var orderSaved = model.addOrder(order);
            logger.info("Orden guardada %s", String.valueOf(orderSaved));
            dbTransactionManager.doCommit();
            return orderSaved;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbTransactionManager.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbTransactionManager.enableAutocommit();
        }
    }

    @Override
    public PojoIntOrderVendor closeOrder(StatusMovementProviderIntEnum reason, BigDecimal amount, String brand, String invoice, long idUser, long idOrder, String productsInfo) throws BloSalesV2Exception {
        try {
            // desactivar la funcion para guardar en la db
            dbTransactionManager.disableAutocommit();
            // recuperar orden
            final var orderFound = getOrderById(idOrder);
            BloSalesV2Utils.validateRule(orderFound == null, BloSalesV2Utils.CODE_ORDER_NOT_FOUND, BloSalesV2Utils.ERROR_ORDER_NOT_FOUND);
            orderFound.setStatusOrder(reason);
            orderFound.setProductsInfo(productsInfo);
            if (reason.equals(StatusMovementProviderIntEnum.CANCELLED)) {
                orderFound.setInvoice(BloSalesV2Utils.N_A);
            }
            if (reason.equals(StatusMovementProviderIntEnum.DELIVERED)) {
                orderFound.setInvoice(invoice);
            }
            final var timestamp = BloSalesV2Utils.getTimestamp();
            orderFound.setTimestamp(timestamp);
            logger.info("guardando informacion de orden %s", String.valueOf(orderFound));
            final var orderUpdated = model.updateOrder(orderFound);
            logger.info("informacion actualizada %s", String.valueOf(orderUpdated));
            // guardar la orden en las notas como un pasivo solamente si fue entregado
            if (reason.compareTo(StatusMovementProviderIntEnum.DELIVERED) == 0) {
                logger.info("guardando una nota");
                final var note = new PojoIntNote();
                // PAGO de orden de %s. %s (ID ORDEN = %s), no. de factura: %s; por: $%s
                note.setFkUser(idUser);
                note.setNote(String.format(
                    BloSalesV2Utils.NOTE_ORDER_PAYED,
                    brand,
                    reason,
                    orderFound.getIdOrderVendor(),
                    invoice,
                    amount
                ));
                note.setTimesamp(timestamp);
                note.setTypeNote(TypeNoteIntEnum.ORDEN_PASIVO);
                final var noteSaved = userController.addNoteNotCommit(note);
                logger.info("nota guardada %s", String.valueOf(noteSaved));
                // recuperar cashbox abierta
                // recupera caja abierta
                var openCashbox = cashboxController.getOpenCashbox();
                // si no existe se crea
                if (openCashbox == null) {
                    logger.info("cashbox inexistente");
                    final var newCashbox = new PojoIntCashbox();
                    newCashbox.setFkUser(idUser);
                    newCashbox.setAmount(BigDecimal.ZERO);
                    newCashbox.setStatus(CashboxStatusIntEnum.OPEN);
                    newCashbox.setTimestamp(timestamp);
                    openCashbox = cashboxController.addCashbox(newCashbox);
                }
                logger.info("cashbox %s", String.valueOf(openCashbox));
                final var cashboxOrderVendor = new PojoIntCashboxOrderVendor();
                cashboxOrderVendor.setFkCashbox(openCashbox.getIdCashbox());
                cashboxOrderVendor.setFkOrderVendor(orderFound.getIdOrderVendor());
                cashboxOrderVendor.setTimestamp(BloSalesV2Utils.getTimestamp());
                logger.info("orden proveedor - caja guardado [%s]", String.valueOf(cashboxesOrdersVendors.addCashboxOrderVendor(cashboxOrderVendor)));
            }
            dbTransactionManager.doCommit();
            return orderUpdated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbTransactionManager.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbTransactionManager.enableAutocommit();
        }
    }

    @Override
    public WrapperPojoIntOrdersVendors getOrders() throws BloSalesV2Exception {
        logger.info("recuperando todas las ordenes");
        return model.getOrders();
    }

    @Override
    public PojoIntOrderVendor getOrderById(long idOrder) throws BloSalesV2Exception {
        logger.info("recuperando orden por id=%s", idOrder);
        return model.getOrderById(idOrder);
    }

}