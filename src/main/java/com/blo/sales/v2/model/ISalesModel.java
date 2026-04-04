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
    
    PojoIntPaymentTypeInfo registerPaymentTypeData(PojoIntPaymentTypeInfo paymentData) throws BloSalesV2Exception;
    
    /**
     * Registro de una venta en la bd <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param sale
     * @return venta registrada
     * @throws BloSalesV2Exception 
     */
    PojoIntSale registerSale(PojoIntSale sale) throws BloSalesV2Exception;
    
    WrapperPojoIntSalesAndStock retrieveAllSalesDetail() throws BloSalesV2Exception;
    
    WrapperPojoIntSalesAndStock retrieveSalesByStatus(SalesStatusIntEnum saleStatus) throws BloSalesV2Exception;
    
    WrapperPojoIntSales retrieveSalesDataByStatus(SalesStatusIntEnum saleStatus) throws BloSalesV2Exception;
    
    boolean setCashboxSale(long idSale) throws BloSalesV2Exception;
}
