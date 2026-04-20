package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IAccountsController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IFinancialHistoryController;
import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import com.blo.sales.v2.model.IAccountsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.math.BigDecimal;

@Singleton
public class AccountsControllerImpl implements IAccountsController {
    
    private static final GUILogger logger = GUILogger.getLogger(AccountsControllerImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerController dbtm;
    
    @Inject
    private IAccountsModel model;
    
    @Inject
    private IFinancialHistoryController financialHistoryController;

    @Override
    public PojoIntAccount addMoney(long idAccount, long idUser, BigDecimal amount, String authorization) throws BloSalesV2Exception {
        try {
            logger.info("agregando dinero");
            dbtm.disableAutocommit();
            logger.info("buscando cuenta %s", idAccount);
            final var account = getAccountById(idAccount);
            BloSalesV2Utils.validateRule(account == null, BloSalesV2Utils.CODE_ACCOUNT_NO_EXISTS, BloSalesV2Utils.ERROR_ACCOUNT_NO_EXISTS);
            final var newAmount = account.getControlAmount().add(amount);
            logger.info("%s + %s = %s", account.getControlAmount(), amount, newAmount);
            account.setControlAmount(newAmount);
            final var accountUpdated = model.updateAccount(idAccount, account);
            logger.info("cuenta actualizada %s", String.valueOf(accountUpdated));
            return accountUpdated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        }
    }

    @Override
    public PojoIntAccount substractMoney(long idAccount, long idUser, BigDecimal amount, String authorization) throws BloSalesV2Exception {
        try {
            logger.info("restando dinero");
            dbtm.disableAutocommit();
            logger.info("buscando cuenta %s", idAccount);
            final var account = getAccountById(idAccount);
            BloSalesV2Utils.validateRule(account == null, BloSalesV2Utils.CODE_ACCOUNT_NO_EXISTS, BloSalesV2Utils.ERROR_ACCOUNT_NO_EXISTS);
            final var newAmount = account.getControlAmount().subtract(amount);
            logger.info("%s - %s = %s", account.getControlAmount(), amount, newAmount);
            BloSalesV2Utils.validateRule(
                    newAmount.compareTo(BigDecimal.ZERO) < 0,
                    BloSalesV2Utils.CODE_INSUFFICIENT_MONEY,
                    BloSalesV2Utils.ERROR_INSUFFICIENT_MONEY
            );
            
            final var prevMovFinancialHistory = new PojoIntFinancialMovement();
            prevMovFinancialHistory.setAmount(account.getControlAmount());
            prevMovFinancialHistory.setFkAccount(idAccount);
            prevMovFinancialHistory.setFkUser(idUser);
            prevMovFinancialHistory.setReason(ReasonsIntEnum.HISTORY_MOV_PREV);
            prevMovFinancialHistory.setTimestamp(BloSalesV2Utils.getTimestamp());
            prevMovFinancialHistory.setType(TypesIntEnum.HISTORY_MOVEMENT);
            prevMovFinancialHistory.setAuthorization(authorization);
            final var prevMovement = financialHistoryController.addMovement(prevMovFinancialHistory);
            logger.info("registrando previo movimiento financiero %s", String.valueOf(prevMovement));
            
            // se actualiza monto
            account.setControlAmount(newAmount);
            final var accountUpdated = model.updateAccount(idAccount, account);
            logger.info("cuenta actualizada %s", String.valueOf(accountUpdated));
            
            final var aftMovFinancial = new PojoIntFinancialMovement();
            aftMovFinancial.setAmount(account.getControlAmount());
            aftMovFinancial.setFkAccount(idAccount);
            aftMovFinancial.setFkUser(idUser);
            aftMovFinancial.setReason(ReasonsIntEnum.HISTORY_MOV_AFT);
            aftMovFinancial.setTimestamp(BloSalesV2Utils.getTimestamp());
            aftMovFinancial.setType(TypesIntEnum.HISTORY_MOVEMENT);
            aftMovFinancial.setAuthorization(authorization);
            final var aftMovement = financialHistoryController.addMovement(aftMovFinancial);
            logger.info("movimiento posterior registrado %s", String.valueOf(aftMovement));
            
            return accountUpdated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        }
    }

    @Override
    public PojoIntAccount getAccountById(long id) throws BloSalesV2Exception {
        logger.info("recuperando informacion de la cuenta %s", id);
        return model.getAccountById(id);
    }
    
}
