package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IMobileCompanyModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.MobileCompanyEntity;
import com.blo.sales.v2.model.entities.WrapperMobilesCompaniesEntity;
import com.blo.sales.v2.model.mapper.MobileCompanyEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperMobilesCompaniesEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class MobileCompanyModelImpl implements IMobileCompanyModel {
    
    private static final GUILogger logger = GUILogger.getLogger(MobileCompanyModelImpl.class.getName());
    
    @Inject
    private MobileCompanyEntityMapper mobileCompanyMapper;
    
    @Inject
    private WrapperMobilesCompaniesEntityMapper companiesMobilesMapper;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;

    @Override
    public WrapperPojoIntMobilesCompanies getMobilesCompanies() throws BloSalesV2Exception {
        try {
        	final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.RETRIEVE_ALL_MOBILES_COMPANIES);
            final var rs = ps.executeQuery();
            final var wrapper = new WrapperMobilesCompaniesEntity();
            final var companies = new ArrayList<MobileCompanyEntity>();
            logger.info("recuperando companias para recargas");
            while(rs.next()) {
                final var m = new MobileCompanyEntity();
                m.setId_mobile_company(rs.getLong(BloSalesV2Columns.ID_COMPANY));
                m.setMobile_company(rs.getString(BloSalesV2Columns.COMPANY));
                companies.add(m);
            }
            wrapper.setCompanies(companies);
            logger.info("compañias encontradas %s", companies.size());
            return companiesMobilesMapper.toOuter(wrapper);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntMobileCompany createMobileCompany(PojoIntMobileCompany company) throws BloSalesV2Exception {
        try {
        	final var conn = DBConnection.getConnection();
        	transactionManager.disableAutocommit();
            final var entity = mobileCompanyMapper.toInner(company);
            logger.info("Guardando [%s]", String.valueOf(company));
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_MOBILE_COMPANY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getMobile_company());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                entity.setId_mobile_company(rs.getLong(1));
            }
            logger.info("datos guardados %s", String.valueOf(entity));
            return mobileCompanyMapper.toOuter(entity);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntMobileCompany getCompanyMobileById(long id) throws BloSalesV2Exception {
        try {
        	final var conn = DBConnection.getConnection();
            logger.info("recuperando compania mobile by id [%s]", id);
            final var ps = conn.prepareStatement(BloSalesV2Queries.RETRIEVE_MOBILE_COMPANY_BY_ID);
            ps.setLong(1, id);
            final var rs = ps.executeQuery();
            BloSalesV2Utils.validateRule(!rs.next(), BloSalesV2Utils.CODE_COMPANY_NOT_FOUND, BloSalesV2Utils.ERROR_COMPANY_NOT_FOUND);
            final var company = new MobileCompanyEntity();
            company.setId_mobile_company(rs.getLong(BloSalesV2Columns.ID_COMPANY));
            company.setMobile_company(rs.getString(BloSalesV2Columns.COMPANY));
            logger.info("Compania encontrada %s", String.valueOf(company));
            return mobileCompanyMapper.toOuter(company);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntMobileCompany updateCompanyMobile(PojoIntMobileCompany companyData, long id) throws BloSalesV2Exception {
        try {
        	final var conn = DBConnection.getConnection();
        	transactionManager.disableAutocommit();
            final var innerCompany = mobileCompanyMapper.toInner(companyData);
            logger.info("Actualizando compania %s por id %s", String.valueOf(companyData), id);
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_MOBILE_COMPANY);
            ps.setString(1, innerCompany.getMobile_company());
            ps.setLong(2, id);
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_UPDATE_EXCEPTION_CODE, BloSalesV2Utils.ERROR_UPDATING_ON_DATA_BASE);
            
            logger.info("Compania actualizada %s", String.valueOf(companyData));
            return mobileCompanyMapper.toOuter(innerCompany);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
