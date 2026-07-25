package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ICashboxController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import com.blo.sales.v2.model.ICreditsDebtsModel;
import com.blo.sales.v2.controller.ICreditsDebtsController;
import com.blo.sales.v2.controller.pojos.PojoIntCashbox;
import com.blo.sales.v2.controller.pojos.enums.CashboxStatusIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypeCreditDebtIntEnum;

@Singleton
public class CreditsDebtsControllerImpl implements ICreditsDebtsController {
    
    private static final GUILogger logger = GUILogger.getLogger(CreditsDebtsControllerImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerController transactionController;
    
    @Inject
    private ICreditsDebtsModel model;

    @Inject
    private ICashboxController cashboxController;
    
    @Override
    public WrapperPojoIntCredits getAllCreditsByType(TypeCreditDebtIntEnum type) throws BloSalesV2Exception {
        logger.info("recupera todos los creditos");
        return model.getAllCreditsByType(type);
    }

    @Override
    public PojoIntCredit changeNameOfLanderName(String name, long idCredit) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            logger.info("cambiando nombre de prestamista");
            final var creditoEncontrado = model.getCreditDebtById(idCredit);
            BloSalesV2Utils.validateRule(creditoEncontrado == null, BloSalesV2Utils.CODE_CREDIT_DEBIT_NOT_FOUND, BloSalesV2Utils.ERROR_CREDIT_DEBIT_NOT_FOUND);
            creditoEncontrado.setLenderDebtorName(name);
            creditoEncontrado.setUpdateDate(BloSalesV2Utils.getTimestamp());
            final var guardado = model.updateCreditDebit(creditoEncontrado);
            logger.info("cambio de nombre %s", String.valueOf(guardado));
            transactionController.doCommit();
            return guardado;
        } catch (BloSalesV2Exception ex) {
            transactionController.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            transactionController.enableAutocommit();
        }
    }

    @Override
    public PojoIntCredit saveCreditDebit(PojoIntCredit creditDebit) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            creditDebit.setTimestamp(BloSalesV2Utils.getTimestamp());
            creditDebit.setAvailable(true);
            creditDebit.setUpdateDate(BloSalesV2Utils.EMPTY_STRING);
            creditDebit.setPayments(BloSalesV2Utils.JSON_EMPTY_ARRAY);
            creditDebit.setPayed(false);
            final var creditoGuardado = model.openCreditDebit(creditDebit);
            logger.info("guardando crédito [%s]", String.valueOf(creditoGuardado));
            transactionController.doCommit();
            return creditoGuardado;
        } catch (BloSalesV2Exception ex) {
            transactionController.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            transactionController.enableAutocommit();
        }
        
    }

    @Override
    public PojoIntCredit addPayment(BigDecimal payment, long idCreditDebit) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            logger.info("cambiando nombre de prestamista");
            final var creditoEncontrado = model.getCreditDebtById(idCreditDebit);
            BloSalesV2Utils.validateRule(creditoEncontrado == null, BloSalesV2Utils.CODE_CREDIT_DEBIT_NOT_FOUND, BloSalesV2Utils.ERROR_CREDIT_DEBIT_NOT_FOUND);
            BloSalesV2Utils.validateRule(!creditoEncontrado.isAvailable() || creditoEncontrado.isPayed(), BloSalesV2Utils.ERROR_CREDIT_DEBIT_UNAVAILABLE, BloSalesV2Utils.CODE_CREDIT_DEBIT_UNAVAILABLE);
            // variable para almacenar temporalmente el monto y usarlo cuando son debitos
            var montoStore = creditoEncontrado.getAmount();
            var toPayment = payment;
            final var nuevoMonto = creditoEncontrado.getAmount().subtract(payment);
            // validar monto
            creditoEncontrado.setAmount(nuevoMonto);
            if (nuevoMonto.compareTo(BigDecimal.ZERO) <= 0) {
                logger.info("credito pagado");
                creditoEncontrado.setAmount(BigDecimal.ZERO);
                creditoEncontrado.setAvailable(false);
                creditoEncontrado.setPayed(true);
            }
            creditoEncontrado.setUpdateDate(BloSalesV2Utils.getTimestamp());
            // agregar el pago a la caja
            if (creditoEncontrado.getType().compareTo(TypeCreditDebtIntEnum.DEBT) == 0) {
                logger.info("credito encontrado es debito");
                // recupera caja abierta
                var openCashbox = cashboxController.getOpenCashbox();
                // si no existe se crea
                if (openCashbox == null) {
                    logger.info("cashbox inexistente");
                    final var newCashbox = new PojoIntCashbox();
                    newCashbox.setFkUser(creditoEncontrado.getFkUser());
                    newCashbox.setAmount(BigDecimal.ZERO);
                    newCashbox.setStatus(CashboxStatusIntEnum.OPEN);
                    newCashbox.setTimestamp(BloSalesV2Utils.getTimestamp());
                    openCashbox = cashboxController.addCashbox(newCashbox);
                }
                logger.info("cashbox %s", String.valueOf(openCashbox));
                // se suma la cantidad de la venta al monto de la caja abierta
                if (payment.compareTo(creditoEncontrado.getAmount()) >= 0) {
                    // si el pago es mayor a la cantidad del crédito entonces el
                    // pago se cubrió completamente y se usa el monto restante del crédito
                    logger.info("debito pagado completamente");
                    toPayment = montoStore;
                }
                openCashbox.setAmount(openCashbox.getAmount().add(toPayment));
                openCashbox.setTimestamp(BloSalesV2Utils.getTimestamp());
                // actualizar cantidad en la caja
                logger.info("actualizando caja abierta %s", String.valueOf(openCashbox));
                cashboxController.updateCAshbox(openCashbox, openCashbox.getIdCashbox());
                
            }
            
            // agregar pago a historial
            final var gson = new Gson();
            final var historialPagos = new ArrayList<>(Arrays.asList(gson.fromJson(creditoEncontrado.getPayments(), String[].class)));
            historialPagos.add(String.format(BloSalesV2Utils.JSON_PAYMENT_HISTORY_ITEM, toPayment, BloSalesV2Utils.getTimestamp()));
            creditoEncontrado.setPayments(gson.toJson(historialPagos));
            final var guardado = model.updateCreditDebit(creditoEncontrado);
            logger.info("cambio de nombre %s", String.valueOf(guardado));
            transactionController.doCommit();
            return guardado;
        } catch (BloSalesV2Exception ex) {
            transactionController.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            transactionController.enableAutocommit();
        }
    }

    @Override
    public void deleteCreditDebit(long idCreditDebt) throws BloSalesV2Exception {
        logger.info("eliminando credito");
        final var creditoEncontrado = model.getCreditDebtById(idCreditDebt);
        BloSalesV2Utils.validateRule(creditoEncontrado == null, BloSalesV2Utils.CODE_CREDIT_DEBIT_NOT_FOUND, BloSalesV2Utils.ERROR_CREDIT_DEBIT_NOT_FOUND);
        creditoEncontrado.setAvailable(false);
        creditoEncontrado.setPayed(false);
        creditoEncontrado.setUpdateDate(BloSalesV2Utils.getTimestamp());
        model.updateCreditDebit(creditoEncontrado);
        logger.info("credito eliminado");
    }

}
