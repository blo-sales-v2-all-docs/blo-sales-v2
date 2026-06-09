package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtSettlement;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IDebtorSettlementsModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.DebtorSettlementEntity;
import com.blo.sales.v2.model.entities.SaleEntity;
import com.blo.sales.v2.model.entities.WrapperDebtorSettlementEntity;
import com.blo.sales.v2.model.mapper.DebtorSettlementEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperDebtorSettlementEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class DebtorSettlementsModelImpl implements IDebtorSettlementsModel{
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsSalesModelImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Inject
    private DebtorSettlementEntityMapper debtorSettlementMapper;
    
    @Inject
    private WrapperDebtorSettlementEntityMapper wrapperDebtorSettlementMapper;
    
    @Override
    public PojoIntDebtSettlement addSettlement(PojoIntDebtSettlement settlement) throws BloSalesV2Exception {
        try {
            logger.info("guardando informacion sobre la liquidacion de un cliente");
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            final var data = debtorSettlementMapper.toInner(settlement);
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_SETTLEMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, data.getFk_sale().getId_sale());
            ps.setString(2, data.getDebtor());
            ps.setString(3, data.getProducts_details());
            ps.setString(4, data.getPayments());
            ps.setString(5, data.getTimestamp());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId_debt_settlement(rs.getLong(1));
            }
            logger.info("informacion guardada exitosamente %s", String.valueOf(data));
            return debtorSettlementMapper.toOuter(data);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntDebtSettlement getDebtorsPaymentsHistory() throws BloSalesV2Exception {
        try {
            logger.info("consultando informacion en la db");
            final var conn = DBConnection.getConnection();
            final var st = conn.prepareStatement(BloSalesV2Queries.SELECT_SETTLEMENTS_INFO);
            final var rs = st.executeQuery();
            final var wrapper = new WrapperDebtorSettlementEntity();
            final var lst = new ArrayList<DebtorSettlementEntity>();
            DebtorSettlementEntity item = null;
            SaleEntity sale = null;
            while (rs.next()) {
                item = new DebtorSettlementEntity();
                sale = new SaleEntity();
                item.setDebtor(rs.getString(BloSalesV2Columns.DEBTOR));
                item.setId_debt_settlement(rs.getLong(BloSalesV2Columns.ID_DEBT_SETTLEMENT));
                item.setPayments(rs.getString(BloSalesV2Columns.PAYMENTS));
                item.setProducts_details(rs.getString(BloSalesV2Columns.PRODUCTS_DETAILS));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                sale.setId_sale(rs.getLong(BloSalesV2Columns.FK_SALE));
                item.setFk_sale(sale);
                lst.add(item);
            }
            logger.info("historial recuperado %s", lst.size());
            wrapper.setDebtor_settlements(lst);
            return wrapperDebtorSettlementMapper.toOuter(wrapper);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
