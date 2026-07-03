package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import jakarta.inject.Singleton;
import com.blo.sales.v2.model.IOrdersVendorsModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.OrderVendorEntity;
import com.blo.sales.v2.model.entities.WrapperOrdersVendorsEntity;
import com.blo.sales.v2.model.entities.enums.StatusOrderVendorEntityEnum;
import com.blo.sales.v2.model.mapper.OrderVendorEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperOrdersVendorsMapper;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class OrdersVendorsModelImpl implements IOrdersVendorsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(OrdersVendorsModelImpl.class.getName());

    @Inject
    private IDBTransactionManagerModel dbtm;
    
    @Inject
    private OrderVendorEntityMapper orderVendorMapper;
    
    @Inject
    private WrapperOrdersVendorsMapper wrapperMapper;
    
    @Override
    public PojoIntOrderVendor addOrder(PojoIntOrderVendor order) throws BloSalesV2Exception {
        try {
            dbtm.disableAutocommit();
            final var conn = DBConnection.getConnection();
            final var data = orderVendorMapper.toInner(order);
            logger.info("guardando orden %s", String.valueOf(order));
            final var ps = conn.prepareStatement(BloSalesV2Queries.ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, data.getFk_vendor());
            ps.setBigDecimal(2, data.getAmount());
            ps.setString(3, data.getStatus_order().name());
            ps.setString(4, data.getInvoice());
            ps.setString(5, data.getTimestamp());
            ps.setString(6, data.getDeadline());
            ps.setString(7, data.getPayment_type());
            ps.setString(8, data.getProducts_info());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId_order_vendor(rs.getInt(1));
            }
            logger.info("informacion de orden guardad exitosamente %s", String.valueOf(data));
            return orderVendorMapper.toOuter(data);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntOrderVendor updateOrder(PojoIntOrderVendor order) throws BloSalesV2Exception {
        try {
            dbtm.disableAutocommit();
            final var conn = DBConnection.getConnection();
            final var data = orderVendorMapper.toInner(order);
            logger.info("guardando orden %s", String.valueOf(order));
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_ORDER);
            ps.setBigDecimal(1, order.getAmount());
            ps.setString(2, order.getStatusOrder().name());
            ps.setString(3, order.getInvoice());
            ps.setString(4, order.getTimestamp());
            ps.setString(5, order.getDeadline());
            ps.setString(6, order.getProductsInfo());
            ps.setLong(7, order.getIdOrderVendor());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_UPDATE_EXCEPTION_CODE, BloSalesV2Utils.ERROR_UPDATING_ON_DATA_BASE);
            
            logger.info("informacion de orden guardad exitosamente %s", String.valueOf(data));
            return orderVendorMapper.toOuter(data);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntOrdersVendors getOrders() throws BloSalesV2Exception {
        try {
            logger.info("recuperando pedidos");
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.GET_ORDERS);
            
            final var rs = ps.executeQuery();
            
            final var out = new WrapperOrdersVendorsEntity();
            final var lst = new ArrayList<OrderVendorEntity>();
            OrderVendorEntity item = null;
            while(rs.next()) {
                item = new OrderVendorEntity();
                item.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                item.setDeadline(rs.getString(BloSalesV2Columns.DEADLINE));
                item.setFk_vendor(rs.getLong(BloSalesV2Columns.FK_VENDOR));
                item.setId_order_vendor(rs.getLong(BloSalesV2Columns.ID_ORDER_VENDOR));
                item.setInvoice(rs.getString(BloSalesV2Columns.INVOICE));
                item.setName(rs.getString(BloSalesV2Columns.NAME));
                item.setStatus_order(StatusOrderVendorEntityEnum.valueOf(rs.getString(BloSalesV2Columns.STATUS_ORDER)));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                item.setBrand(rs.getString(BloSalesV2Columns.BRAND));
                lst.add(item);
            }
            out.setOrders(lst);
            logger.info("registros encontrados [%s]", lst.size());
            return wrapperMapper.toOuter(out);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntOrderVendor getOrderById(long idOrder) throws BloSalesV2Exception {
        try {
            logger.info("recuperando orden por id %s", idOrder);
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.GET_ORDER_BY_ID);
            ps.setLong(1, idOrder);
            
            final var rs = ps.executeQuery();
            
            OrderVendorEntity item = null;
            while(rs.next()) {
                item = new OrderVendorEntity();
                item.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                item.setDeadline(rs.getString(BloSalesV2Columns.DEADLINE));
                item.setFk_vendor(rs.getLong(BloSalesV2Columns.FK_VENDOR));
                item.setId_order_vendor(rs.getLong(BloSalesV2Columns.ID_ORDER_VENDOR));
                item.setInvoice(rs.getString(BloSalesV2Columns.INVOICE));
                item.setName(rs.getString(BloSalesV2Columns.NAME));
                item.setStatus_order(StatusOrderVendorEntityEnum.valueOf(rs.getString(BloSalesV2Columns.STATUS_ORDER)));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
            }
            logger.info("registro encontrado [%s]", String.valueOf(item));
            return orderVendorMapper.toOuter(item);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
