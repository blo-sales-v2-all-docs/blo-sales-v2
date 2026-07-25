package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.controller.pojos.enums.TypeCreditDebtIntEnum;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.CreditDebitEntity;
import com.blo.sales.v2.model.entities.WrapperCreditsDebtsEntity;
import com.blo.sales.v2.model.mapper.CreditEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.blo.sales.v2.model.ICreditsDebtsModel;
import com.blo.sales.v2.model.entities.enums.TypeCreditDebtEntityEnum;

@Singleton
public class CreditsDebtsModelImpl implements ICreditsDebtsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(CreditsDebtsModelImpl.class.getName());
    
    private static final CreditEntityMapper CREDIT_ENTITY_MAPPER = CreditEntityMapper.INSTANCE;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Override
    public WrapperPojoIntCredits getAllCreditsByType(TypeCreditDebtIntEnum type) throws BloSalesV2Exception {
        try {
            logger.info("recuperando creditos");
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_CREDITS_DEBITS);
            ps.setString(1, type.name());
            
            final var rs = ps.executeQuery();
            
            final var outer = new WrapperCreditsDebtsEntity();
            final var lst = new ArrayList<CreditDebitEntity>();
            CreditDebitEntity item = null;
            while(rs.next()) {
                item = new CreditDebitEntity();
                item.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                item.setAvailable(rs.getBoolean(BloSalesV2Columns.AVAILABLE));
                item.setFk_user(rs.getLong(BloSalesV2Columns.FK_USER));
                item.setId_credit_debit(rs.getLong(BloSalesV2Columns.ID_CREDIT_DEBIT));
                item.setLender_debtor_name(rs.getString(BloSalesV2Columns.LENDER_DEBTOR_NAME));
                item.setPayed(rs.getBoolean(BloSalesV2Columns.PAYED));
                item.setPayments(rs.getString(BloSalesV2Columns.PAYMENTS));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                item.setUpdate_date(rs.getString(BloSalesV2Columns.UPDATE_DATE));
                item.setOriginal_amount(rs.getBigDecimal(BloSalesV2Columns.ORIGINAL_AMOUNT));
                item.setType(TypeCreditDebtEntityEnum.valueOf(rs.getString(BloSalesV2Columns.TYPE)));
                lst.add(item);
            }
            outer.setCredits(lst);
            logger.info("registros encontrados [%s]", lst.size());
            return CREDIT_ENTITY_MAPPER.wrapperCreditsToOuter(outer);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public PojoIntCredit getCreditDebtById(long idCreditDebt) throws BloSalesV2Exception {
        try {
            logger.info("recuperando credito por id %s", idCreditDebt);
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_CREDIT_DEBIT_BY_ID);
            ps.setLong(1, idCreditDebt);
            
            final var rs = ps.executeQuery();
            
            CreditDebitEntity item = null;
            while(rs.next()) {
                item = new CreditDebitEntity();
                item.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                item.setAvailable(rs.getBoolean(BloSalesV2Columns.AVAILABLE));
                item.setFk_user(rs.getLong(BloSalesV2Columns.FK_USER));
                item.setId_credit_debit(rs.getLong(BloSalesV2Columns.ID_CREDIT_DEBIT));
                item.setLender_debtor_name(rs.getString(BloSalesV2Columns.LENDER_DEBTOR_NAME));
                item.setPayed(rs.getBoolean(BloSalesV2Columns.PAYED));
                item.setPayments(rs.getString(BloSalesV2Columns.PAYMENTS));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                item.setUpdate_date(rs.getString(BloSalesV2Columns.UPDATE_DATE));
                item.setType(TypeCreditDebtEntityEnum.valueOf(rs.getString(BloSalesV2Columns.TYPE)));
            }
            logger.info("registro encontrado [%s]", String.valueOf(item));
            return CREDIT_ENTITY_MAPPER.toOuter(item);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntCredit openCreditDebit(PojoIntCredit creditDebit) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            logger.info("registrando credito %s", String.valueOf(creditDebit));
            final var entity = CREDIT_ENTITY_MAPPER.toInner(creditDebit);
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_CREDIT_DEBIT, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, entity.getFk_user());
            ps.setString(2, entity.getLender_debtor_name());
            ps.setBigDecimal(3, entity.getAmount());
            ps.setBoolean(4, entity.isPayed());
            ps.setString(5, entity.getTimestamp());
            ps.setString(6, entity.getPayments());
            ps.setString(7, entity.getUpdate_date());
            ps.setBigDecimal(8, entity.getOriginal_amount());
            ps.setString(9, entity.getType().name());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entity.setId_credit_debit(rs.getLong(1));
            }
            logger.info("credito registrado %s", String.valueOf(entity));
            return CREDIT_ENTITY_MAPPER.toOuter(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntCredit updateCreditDebit(PojoIntCredit creditDebitInfo) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            logger.info("actualizando credito %s", String.valueOf(creditDebitInfo));
            final var entity = CREDIT_ENTITY_MAPPER.toInner(creditDebitInfo);
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_CREDIT_DEBIT);
            ps.setString(1, entity.getLender_debtor_name());
            ps.setBoolean(2, entity.isPayed());
            ps.setString(3, entity.getTimestamp());
            ps.setString(4, entity.getPayments());
            ps.setBoolean(5, entity.isAvailable());
            ps.setString(6, entity.getUpdate_date());
            ps.setBigDecimal(7, entity.getAmount());
            ps.setLong(8, entity.getId_credit_debit());
            
            BloSalesV2Utils.validateRule(ps.executeUpdate() == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            logger.info("credito actualizado %s", String.valueOf(entity));
            return CREDIT_ENTITY_MAPPER.toOuter(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
