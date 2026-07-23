package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.model.ICashboxesOrdersVendorsModel;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.CashboxOrderVendorEntity;
import com.blo.sales.v2.model.entities.OrderVendorEntity;
import com.blo.sales.v2.model.entities.VendorEntity;
import com.blo.sales.v2.model.entities.WrapperOrdersVendorsEntity;
import com.blo.sales.v2.model.entities.enums.StatusOrderVendorEntityEnum;
import com.blo.sales.v2.model.mapper.CashboxOrderVendorEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperOrdersVendorsMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class CashboxexOrdersVendorsImpl implements ICashboxesOrdersVendorsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxexOrdersVendorsImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Inject
    private WrapperOrdersVendorsMapper wrapperOdenesVendedorMapper;

    @Override
    public PojoIntCashboxOrderVendor addCashboxOrderVendor(PojoIntCashboxOrderVendor orderVendorInfo) throws BloSalesV2Exception {
        logger.info("guardando datos cashbox - order vendor");
        try {
            final var entity = CashboxOrderVendorEntityMapper.INSTANCE.toInner(orderVendorInfo);
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            // 2. Usar prepareStatement con RETURN_GENERATED_KEYS (Más estándar que prepareCall para INSERT)
            final var ps = conn.prepareStatement(BloSalesV2Queries.ADD_CASHBOX_ORDER_VENDOR, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, entity.getFkOrderVendor());
            ps.setLong(2, entity.getFkCashbox());
            ps.setString(3, entity.getTimestamp());
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var out = new CashboxOrderVendorEntity() ;
            
            final var rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                out.setIdCashboxOrderVendor(rowsAffected);
            }
            logger.info("registro guardado ");
            return CashboxOrderVendorEntityMapper.INSTANCE.toOuter(out);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntOrdersVendors getOrdersVendorByIdCashbox(long idCashox) throws BloSalesV2Exception {
        try {
             final var conn = DBConnection.getConnection();
             logger.info("recuperando pedidos de la caja %s", idCashox);
            final var ps = conn.prepareStatement(BloSalesV2Queries.CASHBOXES_ORDER_VENDOR);
            ps.setLong(1, idCashox);
            final var data = ps.executeQuery();
            final var out = new WrapperOrdersVendorsEntity();
            final var lst = new ArrayList<OrderVendorEntity>();
            OrderVendorEntity ordenVendedor = null;
            VendorEntity informacionVendedor = null;
            while(data.next()) {
                informacionVendedor = new VendorEntity();
                ordenVendedor = new OrderVendorEntity();
                ordenVendedor.setAmount(data.getBigDecimal(BloSalesV2Columns.AMOUNT));
                ordenVendedor.setBrand(data.getString(BloSalesV2Columns.BRAND));
                ordenVendedor.setId_order_vendor(data.getLong(BloSalesV2Columns.ID_ORDER_VENDOR));
                ordenVendedor.setInvoice(data.getString(BloSalesV2Columns.INVOICE));
                ordenVendedor.setPayment_type(data.getString(BloSalesV2Columns.PAYMENT_TYPE));
                ordenVendedor.setProducts_info(data.getString(BloSalesV2Columns.PRODUCTS_INFO));
                ordenVendedor.setStatus_order(StatusOrderVendorEntityEnum.valueOf(data.getString(BloSalesV2Columns.STATUS_ORDER)));
                ordenVendedor.setTimestamp(data.getString(BloSalesV2Columns.TIMESTAMP));
                // informacion del vendedor
                informacionVendedor.setBrand(data.getString(BloSalesV2Columns.BRAND));
                informacionVendedor.setName(data.getString(BloSalesV2Columns.NAME));
                informacionVendedor.setId_vendor(data.getLong(BloSalesV2Columns.ID_VENDOR));
                ordenVendedor.setVendor_info(informacionVendedor);
                lst.add(ordenVendedor);
            }
            logger.info("pedidos de la caja %s", lst.size());
            out.setOrders(lst);
            return wrapperOdenesVendedorMapper.toOuter(out);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
