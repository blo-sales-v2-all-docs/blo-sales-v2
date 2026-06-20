package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.model.IAccountsModel;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.AccountEntity;
import com.blo.sales.v2.model.mapper.AccountEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;

@Singleton
public class AccountsModelImpl implements IAccountsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(AccountsModelImpl.class.getName());
    
    @Inject
    private AccountEntityMapper accountEntityMapper;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;

    @Override
    public PojoIntAccount getAccountById(long id) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_ACCOUNT);
            ps.setLong(1, id);
            final var data = ps.executeQuery();
            
            AccountEntity account = null;
            logger.info("recuperando cuenta por id %s");
            while(data.next()) {
                account = new AccountEntity();
                account.setAccount(data.getString(BloSalesV2Columns.ACCOUNT));
                account.setControl_amount(data.getBigDecimal(BloSalesV2Columns.CONTROL_AMOUNT));
                account.setId_account(data.getLong(BloSalesV2Columns.ID_ACCOUNT));
                account.setTimestamp(data.getString(BloSalesV2Columns.TIMESTAMP));
            }
            logger.info("cuenta recuperada %s", String.valueOf(account));
            return accountEntityMapper.toOuter(account);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntAccount updateAccount(long idAccount, PojoIntAccount account) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_ACCOUNT);
            final var innerData = accountEntityMapper.toInner(account);
            logger.info("actualizando informacion de la cuenta %s", String.valueOf(account));
            ps.setString(1, innerData.getAccount());
            ps.setBigDecimal(2, innerData.getControl_amount());
            ps.setString(3, innerData.getTimestamp());
            ps.setLong(4, idAccount);
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_UPDATE_EXCEPTION_CODE, BloSalesV2Utils.ERROR_UPDATING_ON_DATA_BASE);
            
            logger.info("cuenta actualizada %s", String.valueOf(innerData));
            return accountEntityMapper.toOuter(innerData);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
