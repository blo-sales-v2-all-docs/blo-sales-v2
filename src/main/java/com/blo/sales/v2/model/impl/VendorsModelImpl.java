package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IVendorsModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.VendorEntity;
import com.blo.sales.v2.model.entities.WrapperVendorsEntity;
import com.blo.sales.v2.model.mapper.VendorEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperVendorsEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class VendorsModelImpl implements IVendorsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(VendorsModelImpl.class.getName());
    
    @Inject
    private VendorEntityMapper vendorMapper;
    
    @Inject
    private IDBTransactionManagerModel dbt;

    @Inject
    private WrapperVendorsEntityMapper wrapperVendorsMapper;
    
    @Override
    public PojoIntVendor addVendor(PojoIntVendor vendor) throws BloSalesV2Exception {
        try {
            logger.info("guardando informacion de proveedor %s", String.valueOf(vendor));
            final var conn = DBConnection.getConnection();
            dbt.disableAutocommit();
            final var data = vendorMapper.toInner(vendor);
            final var ps = conn.prepareStatement(BloSalesV2Queries.ADD_PROVIDER, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, data.getFk_user());
            ps.setString(2, data.getName());
            ps.setString(3, data.getBrand());
            ps.setString(4, data.getContact());
            ps.setString(5, data.getVisit_days());
            ps.setBoolean(6, data.isPre_sale());
            ps.setString(7, data.getTimestamp());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()){
                data.setId_vendor(rs.getLong(1));
            }
            logger.info("proveedor guardado %s", String.valueOf(data));
            return vendorMapper.toOuter(data);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntVendor getVendorByContact(String contact) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.GET_PROVIDER_BY_CONTACT);
            ps.setString(1, contact);
            final var data = ps.executeQuery();
            VendorEntity vendor = null;
            logger.info("recuperando proveedor por contacto %s", contact);
            while(data.next()) {
                vendor = new VendorEntity();
                vendor.setId_vendor(data.getLong(BloSalesV2Columns.ID_VENDOR));
                vendor.setName(data.getString(BloSalesV2Columns.NAME));
                vendor.setBrand(data.getString(BloSalesV2Columns.BRAND));
                vendor.setContact(data.getString(BloSalesV2Columns.CONTACT));
                vendor.setVisit_days(data.getString(BloSalesV2Columns.VISIT_DAYS));
                vendor.setPre_sale(data.getBoolean(BloSalesV2Columns.PRE_SALE));
                vendor.setTimestamp(data.getString(BloSalesV2Columns.TIMESTAMP));
            }
            logger.info("proveedor encontrado %s", String.valueOf(vendor));
            return vendorMapper.toOuter(vendor);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntVendor getVendorById(long id) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.GET_PROVIDER_BY_CONTACT);
            ps.setLong(1, id);
            final var data = ps.executeQuery();
            VendorEntity vendor = null;
            logger.info("recuperando proveedor por id %s", id);
            while(data.next()) {
                vendor = new VendorEntity();
                vendor.setId_vendor(data.getLong(BloSalesV2Columns.ID_VENDOR));
                vendor.setName(data.getString(BloSalesV2Columns.NAME));
                vendor.setBrand(data.getString(BloSalesV2Columns.BRAND));
                vendor.setContact(data.getString(BloSalesV2Columns.CONTACT));
                vendor.setVisit_days(data.getString(BloSalesV2Columns.VISIT_DAYS));
                vendor.setPre_sale(data.getBoolean(BloSalesV2Columns.PRE_SALE));
                vendor.setTimestamp(data.getString(BloSalesV2Columns.TIMESTAMP));
            }
            logger.info("proveedor encontrado %s", String.valueOf(vendor));
            return vendorMapper.toOuter(vendor);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntVendors getAllVendors() throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.GET_PROVIDERS);
            final var data = ps.executeQuery();
            final var wrapper = new WrapperVendorsEntity();
            final var lst = new ArrayList<VendorEntity>();
            VendorEntity vendor = null;
            logger.info("recuperando proveedores");
            while(data.next()) {
                vendor = new VendorEntity();
                vendor.setId_vendor(data.getLong(BloSalesV2Columns.ID_VENDOR));
                vendor.setName(data.getString(BloSalesV2Columns.NAME));
                vendor.setBrand(data.getString(BloSalesV2Columns.BRAND));
                vendor.setContact(data.getString(BloSalesV2Columns.CONTACT));
                vendor.setVisit_days(data.getString(BloSalesV2Columns.VISIT_DAYS));
                vendor.setPre_sale(data.getBoolean(BloSalesV2Columns.PRE_SALE));
                vendor.setTimestamp(data.getString(BloSalesV2Columns.TIMESTAMP));
                lst.add(vendor);
            }
            wrapper.setVendors(lst);
            logger.info("proveedores encontrados [%s]", lst.size());
            return wrapperVendorsMapper.toOuter(wrapper);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntVendor updateVendor(PojoIntVendor vendorData, long idVendor) throws BloSalesV2Exception {
        try {
            logger.info("actualizando informacion de proveedor %s", String.valueOf(vendorData));
            final var conn = DBConnection.getConnection();
            dbt.disableAutocommit();
            final var data = vendorMapper.toInner(vendorData);
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_PROVIDER);
            ps.setString(1, data.getName());
            ps.setString(2, data.getBrand());
            ps.setString(3, data.getContact());
            ps.setString(4, data.getVisit_days());
            ps.setString(5, data.getTimestamp());
            ps.setLong(6, data.getId_vendor());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_UPDATE_EXCEPTION_CODE, BloSalesV2Utils.ERROR_UPDATING_ON_DATA_BASE);
            
            logger.info("proveedor actualizado %s", String.valueOf(data));
            return vendorMapper.toOuter(data);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
