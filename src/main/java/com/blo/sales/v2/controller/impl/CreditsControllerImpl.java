package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ICreditsController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.model.ICreditsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

@Singleton
public class CreditsControllerImpl implements ICreditsController {
    
    private static final GUILogger logger = GUILogger.getLogger(CreditsControllerImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerController transactionController;
    
    @Inject
    private ICreditsModel model;

    @Override
    public WrapperPojoIntCredits getAllCredits() throws BloSalesV2Exception {
        logger.info("recupera todos los creditos");
        return model.getAllCredits();
    }

    @Override
    public PojoIntCredit changeNameOfLanderName(String name, long idCredit) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            logger.info("cambiando nombre de prestamista");
            final var creditoEncontrado = model.getCreditById(idCredit);
            BloSalesV2Utils.validateRule(creditoEncontrado == null, "code", "msg");
            creditoEncontrado.setLenderName(name);
            creditoEncontrado.setUpdateDate(BloSalesV2Utils.getTimestamp());
            final var guardado = model.updateCredit(creditoEncontrado);
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
    public PojoIntCredit saveCredit(PojoIntCredit credit) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            credit.setTimestamp(BloSalesV2Utils.getTimestamp());
            credit.setAvailable(true);
            credit.setUpdateDate(BloSalesV2Utils.EMPTY_STRING);
            credit.setPayments(BloSalesV2Utils.JSON_EMPTY_ARRAY);
            credit.setPayed(false);
            final var creditoGuardado = model.openCredit(credit);
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
    public PojoIntCredit addPayment(BigDecimal payment, long idCredit) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            logger.info("cambiando nombre de prestamista");
            final var creditoEncontrado = model.getCreditById(idCredit);
            BloSalesV2Utils.validateRule(creditoEncontrado == null, "code", "msg");
            BloSalesV2Utils.validateRule(!creditoEncontrado.isAvailable() || creditoEncontrado.isPayed(), "", "");
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
            // agregar pago a historial
            final var gson = new Gson();
            final var historialPagos = new ArrayList<>(Arrays.asList(gson.fromJson(creditoEncontrado.getPayments(), String[].class)));
            historialPagos.add(String.format(BloSalesV2Utils.JSON_PAYMENT_HISTORY_ITEM, payment, BloSalesV2Utils.getTimestamp()));
            creditoEncontrado.setPayments(gson.toJson(historialPagos));
            final var guardado = model.updateCredit(creditoEncontrado);
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
    public void deleteCredit(long idCredit) throws BloSalesV2Exception {
        logger.info("eliminando credito");
        final var creditoEncontrado = model.getCreditById(idCredit);
        BloSalesV2Utils.validateRule(creditoEncontrado == null, "code", "msg");
        creditoEncontrado.setAvailable(false);
        creditoEncontrado.setPayed(false);
        creditoEncontrado.setUpdateDate(BloSalesV2Utils.getTimestamp());
        model.updateCredit(creditoEncontrado);
        logger.info("credito eliminado");
    }

}
