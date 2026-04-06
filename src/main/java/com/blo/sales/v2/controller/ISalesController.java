package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntDebtor;
import com.blo.sales.v2.controller.pojos.PojoIntPaymentTypeInfo;
import com.blo.sales.v2.controller.pojos.PojoIntSale;
import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.controller.pojos.PojoIntSaleProductData;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSales;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesAndStock;
import com.blo.sales.v2.controller.pojos.enums.SalesStatusIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;
import java.util.List;

/**
 * Clase controlador para flujo de ventas
 * @version 1.0.0
 * @author BLO
 */
public interface ISalesController {
    
    /**
     * Metodo que registra una venta por pago con tarjeta
     * @param paymentData
     * @param totalSale
     * @param productsInfo
     * @param idUser
     * @return datos de venta
     * @throws BloSalesV2Exception 
     */
    PojoIntPaymentTypeInfo registerPaymentTypeData(PojoIntPaymentTypeInfo paymentData, BigDecimal totalSale, List<PojoIntSaleProductData> productsInfo, long idUser) throws BloSalesV2Exception;
    
    /**
     * Flujo que registra una venta, reduce unidades de stock, agrega dinero en cashbox
     * @param totalSale
     * @param productsInfo
     * @param idUser
     * @return Venta registrada
     * @throws BloSalesV2Exception 
     */
    PojoIntSale registerSale(BigDecimal totalSale, List<PojoIntSaleProductData> productsInfo, long idUser) throws BloSalesV2Exception;
    
    /**
     * Metodo que registra la comision de una venta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idUser
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntSale registerTopUpComission(long idUser) throws BloSalesV2Exception;
    
    /**
     * Flujo que registra una venta con un nuevo deudor
     * @param totalSale
     * @param productsInfo
     * @param idUser
     * @param debtorData
     * @return Deudor registrado
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor registerSaleWithNewDebtor(BigDecimal totalSale, List<PojoIntSaleProductData> productsInfo,long idUser, PojoIntDebtor debtorData) throws BloSalesV2Exception;
    
    /**
     * Registra una venta con deudor existente
     * @param totalSale
     * @param productsInfo
     * @param partialPay
     * @param partialPayments
     * @param idUser
     * @param idDebtor
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor registerSaleWithDebtor(BigDecimal totalSale, List<PojoIntSaleProductData> productsInfo, BigDecimal partialPay, String partialPayments, long idUser, long idDebtor) throws BloSalesV2Exception;
            
    WrapperPojoIntSalesAndStock retrieveAllSalesDetail() throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera las ventas del dia con status de CLOSE
     * @param saleStatus
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntSalesAndStock retrieveSalesByStatus(SalesStatusIntEnum saleStatus) throws BloSalesV2Exception;
    
    WrapperPojoIntSales retrieveSalesDataByStatus(SalesStatusIntEnum saleStatus) throws BloSalesV2Exception;
    
    /**
     * Metodo que marca la venta como registrada en una cashbox
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idSale
     * @return
     * @throws BloSalesV2Exception 
     */
    boolean setCashboxSale(long idSale) throws BloSalesV2Exception;
    
    /**
     * Metodo que registra una venta en la bd.
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param totalSale
     * @param products
     * @param idUser
     * @return venta registrada
     * @throws BloSalesV2Exception 
     */
    PojoIntSale registerSaleCommitNotEnabled(BigDecimal totalSale, List<PojoIntSaleProductData> products, long idUser) throws BloSalesV2Exception;
    
    PojoIntSaleDeletedDetail deleteSaleProduct(long idUser, long idSale, long idProduct, String reason) throws BloSalesV2Exception;
    
    /**
     * Metodo que permite actualizar el tipo de pago
     * @param paymentData
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntPaymentTypeInfo registerPaymentTypeData(PojoIntPaymentTypeInfo paymentData) throws BloSalesV2Exception;
}
