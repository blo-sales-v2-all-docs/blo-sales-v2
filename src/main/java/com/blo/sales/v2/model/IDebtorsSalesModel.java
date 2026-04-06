package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones deudor-venta en la bd
 * @version 1.0.0
 * @author BLO
 */
public interface IDebtorsSalesModel {
    
    /**
     * Metodo que guarda la relacion deudor-venta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param debtor
     * @return relacion deudor-venta
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception;
    
    /**
     * Metodo que elimina la relacion deudor-venta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param fkDebtor
     * @throws BloSalesV2Exception
     */
    void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception;
    
}
