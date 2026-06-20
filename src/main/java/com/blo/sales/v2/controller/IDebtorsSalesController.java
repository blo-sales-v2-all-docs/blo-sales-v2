package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.controller.pojos.PojoIntDebtorSaleProductInfo;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para la relacion deudor-venta
 * @version 1.2.0
 * @author BLO
 */
public interface IDebtorsSalesController {
    
    /**
     * Guarda la ralacion deudor - venta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param debtor
     * @return relacion guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception;
    
    /**
     * Este metodo elimina la relacion deudor-venta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param fkDebtor
     * @throws BloSalesV2Exception 
     */
    void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera toda la informacion de una venta y producto relacionada con un deudor
     * @param idDebtor
     * @return Lista de venta con productos
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtorSaleProductInfo retrieveSalesProductsDataByIdDebtor(long idDebtor) throws BloSalesV2Exception;
    
}
