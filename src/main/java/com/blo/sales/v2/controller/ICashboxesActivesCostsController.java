package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxesActivesCosts;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase que guarda la relacion cashbox-activos/costos
 * @version 1.0.0
 * @author BLO
 */
public interface ICashboxesActivesCostsController {
    
    /**
     * Metodo que guarda relacion cashbox-activos/costos
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param data
     * @return relacion guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntCashboxesActivesCosts addRelationship(PojoIntCashboxesActivesCosts data) throws BloSalesV2Exception;
    
}
