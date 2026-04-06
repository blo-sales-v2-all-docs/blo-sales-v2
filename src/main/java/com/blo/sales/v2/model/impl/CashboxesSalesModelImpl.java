package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.model.ICashboxesSalesModel;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.CashboxEntity;
import com.blo.sales.v2.model.entities.CashboxSaleDetailEntity;
import com.blo.sales.v2.model.entities.CashboxSaleEntity;
import com.blo.sales.v2.model.entities.PaymentTypeInfoEntity;
import com.blo.sales.v2.model.entities.ProductEntity;
import com.blo.sales.v2.model.entities.SaleEntity;
import com.blo.sales.v2.model.entities.SaleProductEntity;
import com.blo.sales.v2.model.entities.UserEntity;
import com.blo.sales.v2.model.entities.WrapperCashboxesSalesDetailsEntity;
import com.blo.sales.v2.model.entities.enums.CashboxEntityEnum;
import com.blo.sales.v2.model.entities.enums.PaymentTypeEntityEnum;
import com.blo.sales.v2.model.entities.enums.RolesEntityEnum;
import com.blo.sales.v2.model.entities.enums.SaleStatusEntityEnum;
import com.blo.sales.v2.model.mapper.CashboxSaleEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperCashboxesSalesDetailEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class CashboxesSalesModelImpl implements ICashboxesSalesModel {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxesSalesModelImpl.class.getName());
    
    @Inject
    private CashboxSaleEntityMapper mapper;
    
    @Inject
    private WrapperCashboxesSalesDetailEntityMapper wrapperCashboxesSalesDetailsMapper;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Override
    public PojoIntCashboxSale addCashboxSale(long idCashbox, long idSale) throws BloSalesV2Exception {
        logger.info("guardando datos cashbox - sale");
        try {
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
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
        }
    }

    @Override
    public WrapperPojoIntCashboxesSalesDetails getCashboxSalesDetailById(long idCashbox) throws BloSalesV2Exception {
        try {
            logger.info("recuperando todas las categorias");
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.GET_CASHBOXES_ALL_DATA_DETAIL_BY_CASHBOX_ID);
            ps.setLong(1, idCashbox);
            final var data = ps.executeQuery();
            CashboxSaleDetailEntity detail;
            CashboxEntity cashbox;
            SaleEntity sale;
            ProductEntity product;
            UserEntity user;
            SaleProductEntity saleProduct;
            PaymentTypeInfoEntity info;
            final var output = new WrapperCashboxesSalesDetailsEntity();
            final var lst = new ArrayList<CashboxSaleDetailEntity>();
            while (data.next()) {                
                detail = new CashboxSaleDetailEntity();
                cashbox = new CashboxEntity();
                cashbox.setId_cashbox(data.getLong(BloSalesV2Columns.ID_CASHBOX));
                cashbox.setAmount(data.getBigDecimal(BloSalesV2Columns.AMOUNT));
                cashbox.setStatus(CashboxEntityEnum.valueOf(data.getString(BloSalesV2Columns.STATUS)));
                cashbox.setTimestamp(data.getString("cb_timestamp"));
                detail.setCashbox(cashbox);
                
                sale = new SaleEntity();
                sale.setId_sale(data.getLong(BloSalesV2Columns.ID_SALE));
                sale.setTotal(data.getBigDecimal(BloSalesV2Columns.TOTAL));
                sale.setSale_status(SaleStatusEntityEnum.valueOf(data.getString(BloSalesV2Columns.SALE_STATUS)));
                sale.setTimestamp(data.getString(BloSalesV2Columns.TIMESTAMP));
                detail.setSale(sale);
                
                product = new ProductEntity();
                product.setProduct(data.getString(BloSalesV2Columns.PRODUCT));
                detail.setProduct(product);
                
                saleProduct = new SaleProductEntity();
                saleProduct.setQunatity_sale(data.getBigDecimal(BloSalesV2Columns.QUANTITY_ON_SALE));
                saleProduct.setProduct_total_on_sale(data.getBigDecimal(BloSalesV2Columns.PRODUCT_TOTAL_ON_SALE));
                saleProduct.setTotal_on_sale(data.getBigDecimal(BloSalesV2Columns.TOTAL_ON_SALE));
                detail.setSale_product(saleProduct);
                
                user = new UserEntity();
                user.setUsername(data.getString(BloSalesV2Columns.USER_NAME));
                user.setRole(RolesEntityEnum.valueOf(data.getString(BloSalesV2Columns.ROL)));
                detail.setUser(user);
                
                info = new PaymentTypeInfoEntity();
                info.setReference(data.getString(BloSalesV2Columns.REFERENCE));
                info.setCard_pay(data.getBigDecimal(BloSalesV2Columns.TOTAL_CARD));
                info.setCash(data.getBigDecimal(BloSalesV2Columns.TOTAL_CASH));
                info.setPayment_type(PaymentTypeEntityEnum.valueOf(data.getString(BloSalesV2Columns.PAYMENT_TYPE)));
                info.setId_sale(sale.getId_sale());
                detail.setPayment_info_tmp(info);
                
                lst.add(detail);
            }
            logger.info("ventas encontradas [%s]", lst.size());
            output.setCashboxes(lst);
            return wrapperCashboxesSalesDetailsMapper.toOuter(output);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
}
