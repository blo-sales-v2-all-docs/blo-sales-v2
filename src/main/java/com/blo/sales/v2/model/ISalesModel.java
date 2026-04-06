package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntPaymentTypeInfo;
import com.blo.sales.v2.controller.pojos.PojoIntSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSales;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesAndStock;
import com.blo.sales.v2.controller.pojos.enums.SalesStatusIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones de venta sobre la db
 * @version 1.0.0
 * @author BLO
 */
public interface ISalesModel {
    
    /**
     * Metodo que complementa una venta con los datos de pago
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param paymentData
     * @return datos de pago
     * @throws BloSalesV2Exception 
     */
    PojoIntPaymentTypeInfo registerPaymentTypeData(PojoIntPaymentTypeInfo paymentData) throws BloSalesV2Exception;
    
    /**
     * Registro de una venta en la bd
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param sale
     * @return venta registrada
     * @throws BloSalesV2Exception 
     */
    PojoIntSale registerSale(PojoIntSale sale) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todos los detalles de una venta
     * @return lista de ventas-productos
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntSalesAndStock retrieveAllSalesDetail() throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera las ventas por un status
     * @param saleStatus
     * @return ventas
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntSalesAndStock retrieveSalesByStatus(SalesStatusIntEnum saleStatus) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todos los datos de una venta por un status 
     * @param saleStatus
     * @return ventas con detalles
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntSales retrieveSalesDataByStatus(SalesStatusIntEnum saleStatus) throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza el status de la venta ON_CASHBOX (<code>sale_status = 'ON_CASHBOX'</code>)
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idSale
     * @return true
     * @throws BloSalesV2Exception
     */
    boolean setCashboxSale(long idSale) throws BloSalesV2Exception;
}
