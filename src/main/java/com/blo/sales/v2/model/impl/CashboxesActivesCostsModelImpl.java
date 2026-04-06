package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxesActivesCosts;
import com.blo.sales.v2.model.ICashboxesActivesCostsModel;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.mapper.CashboxesActivesCostsEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;

public @Singleton class CashboxesActivesCostsModelImpl implements ICashboxesActivesCostsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxesActivesCostsModelImpl.class.getName());
    
    @Inject
    private CashboxesActivesCostsEntityMapper mapper;
    
    @Inject
    private IDBTransactionManagerModel dbTransactionManager;
    
    @Override
    public PojoIntCashboxesActivesCosts addRelationship(PojoIntCashboxesActivesCosts data) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            dbTransactionManager.disableAutocommit();
            logger.info("guardando %s", String.valueOf(data));
            final var dataInner = mapper.toInner(data);
            // 2. Usar prepareStatement con RETURN_GENERATED_KEYS (Más estándar que prepareCall para INSERT)
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_CASHBOXES_ACTIVE_COSTS, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, dataInner.getFk_cashbox());
            ps.setLong(2, dataInner.getFk_actives_costs());
            ps.setString(3, dataInner.getTimestamp());
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()){
                dataInner.setId_cashboxes_actives_costs(rs.getLong(1));
            }
            logger.info("registro guardado ");
            return mapper.toOuter(dataInner);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
