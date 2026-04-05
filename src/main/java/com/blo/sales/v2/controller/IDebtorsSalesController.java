package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para la relacion deudor-venta
 * @version 1.0.0
 * @author BLO
 */
public interface IDebtorsSalesController {
    
    /**
     * Guarda la ralacion deudor - venta
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param debtor
     * @return relacion guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception;
    
    void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception;
    
}
