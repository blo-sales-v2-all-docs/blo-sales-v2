package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.model.ICashboxesSalesModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.CashboxEntity;
import com.blo.sales.v2.model.entities.CashboxSaleEntity;
import com.blo.sales.v2.model.entities.SaleEntity;
import com.blo.sales.v2.model.mapper.CashboxSaleEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CashboxesSalesModelImpl implements ICashboxesSalesModel {
    
    private static final Connection conn = DBConnection.getConnection();
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxesSalesModelImpl.class.getName());
    
    private static final CashboxSaleEntityMapper mapper = CashboxSaleEntityMapper.getInstance();
    
    private static CashboxesSalesModelImpl instance;
    
    private CashboxesSalesModelImpl() { }
    
    public static CashboxesSalesModelImpl getInstance() {
        if (instance == null) {
            instance = new CashboxesSalesModelImpl();
        }
        return instance;
    }

    @Override
    public PojoIntCashboxSale addCashboxSale(long idCashbox, long idSale) throws BloSalesV2Exception {
        logger.info("guardando datos cashbox - sale");
        try {
            DBConnection.disableAutocommit();
            // 2. Usar prepareStatement con RETURN_GENERATED_KEYS (Más estándar que prepareCall para INSERT)
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_CASHBOX_SALE_RELATIONSHIP, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, idCashbox);
            ps.setLong(2, idSale);
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var out = new CashboxSaleEntity();
            
            final var rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                out.setId_cashbox_sale(rs.getLong(1));
                DBConnection.doCommit();
                final var fkSale = new SaleEntity();
                fkSale.setId_sale(idSale);
                final var fkCashbox = new CashboxEntity();
                fkCashbox.setId_cashbox(idCashbox);
                out.setFk_cashbox(fkCashbox);
                out.setFk_sale(fkSale);
            }
            logger.info("registro guardado ");
            return mapper.toOuter(out);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        } finally {
            try {
                DBConnection.enableAutocommit();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
                throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
            }
        }
    }
    
}
