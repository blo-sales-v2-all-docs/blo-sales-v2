package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.controller.pojos.PojoIntDebtorSaleProductInfo;
import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IDebtorsSalesModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.DebtorSaleProductInfoEntity;
import com.blo.sales.v2.model.entities.enums.PaymentTypeEntityEnum;
import com.blo.sales.v2.model.mapper.DebtorSaleEntityMapper;
import com.blo.sales.v2.model.mapper.DebtorSaleProductInfoEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Singleton
public class DebtorsSalesModelImpl implements IDebtorsSalesModel {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsSalesModelImpl.class.getName());
    
    @Inject
    private DebtorSaleEntityMapper mapper;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Inject
    private DebtorSaleProductInfoEntityMapper debtorSaleProductInfoEntityMapper;
    
    @Override
    public PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception {
        try {
            logger.info("guardando relacion deudor venta");
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            final var relationInner = mapper.toInner(debtor);
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_DEBTOR_SALE, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, relationInner.getFk_debtor());
            ps.setLong(2, relationInner.getFk_sale());
            ps.setString(3, relationInner.getTimestamp());
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                relationInner.setId_debtor_sale(rs.getLong(1));
            }
            logger.info("relacion guardada exitosamente %s", String.valueOf(relationInner));
            return mapper.toOuter(relationInner);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception {
         try {
             logger.info("eliminado relacion deudor - venta fkDebtor = %s", fkDebtor);
             final var conn = DBConnection.getConnection();
             transactionManager.disableAutocommit();
            final var ps = conn.prepareStatement(BloSalesV2Queries.DELETE_DEBTOR_SALE);
            ps.setLong(1, fkDebtor);
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
            
            logger.info("relacion eliminada");
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntDebtorSaleProductInfo retrieveSalesProductsDataByIdDebtor(long idDebtor) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            logger.info("buscando informacion detallada del deudor %s", idDebtor);
            final var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_DEBTOR_SALE_PRODUCTS_INFO);
            ps.setLong(1, idDebtor);
            final var rs = ps.executeQuery();
            
            BloSalesV2Utils.validateRule(!rs.next(), BloSalesV2Utils.CODE_PRODUCT_NOT_FOUND, BloSalesV2Utils.ERROR_PRODUCT_NOT_FOUND);
            
            logger.info("informacion recuperada");
            
            DebtorSaleProductInfoEntity debtorSaleProductInfo = null;
            final var lst = new ArrayList<DebtorSaleProductInfoEntity>();
            while(rs.next()) {
                debtorSaleProductInfo = new DebtorSaleProductInfoEntity();
                debtorSaleProductInfo.setId_debtor(rs.getLong(BloSalesV2Columns.ID_DEBTOR));
                debtorSaleProductInfo.setName(rs.getString(BloSalesV2Columns.NAME));
                debtorSaleProductInfo.setId_sale(rs.getLong(BloSalesV2Columns.ID_SALE));
                debtorSaleProductInfo.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                debtorSaleProductInfo.setAuthorization(rs.getString(BloSalesV2Columns.REFERENCE));
                debtorSaleProductInfo.setPayment_type(PaymentTypeEntityEnum.valueOf(rs.getString(BloSalesV2Columns.PAYMENT_TYPE)));
                debtorSaleProductInfo.setProduct(rs.getString(BloSalesV2Columns.PRODUCT));
                debtorSaleProductInfo.setPayments(rs.getString(BloSalesV2Columns.PAYMENTS));
                lst.add(debtorSaleProductInfo);
            }
            logger.info("detalles encontrados %s", lst.size());
            if (!lst.isEmpty()) {
                final var gson = new Gson();
                logger.info("parseando informacion");
                final var firstDetail = lst.get(0);
                final var output = debtorSaleProductInfoEntityMapper.toOuter(firstDetail);
                final var products = lst.stream().map(DebtorSaleProductInfoEntity::getProduct).collect(Collectors.toList());
                output.setProducts(String.join(BloSalesV2Utils.SEPARATOR_PAYMENTS, products));
                
                final var idSales = lst.stream().map(DebtorSaleProductInfoEntity::getId_sale).collect(Collectors.toList());
                
                output.setIdSales(idSales);
                
                final var idsPaymentsType = lst.stream().
                        map(info -> PaymentTypeIntEnum.valueOf(info.getPayment_type().name())).
                        collect(Collectors.toList());
                output.setPaymentType(idsPaymentsType);
                
                return output;
            }
            return null;
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
