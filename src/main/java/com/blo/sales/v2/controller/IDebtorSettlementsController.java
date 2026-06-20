package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtSettlement;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para pagos de deudores
 * @version 1.0.0
 * @author BLO
 */
public interface IDebtorSettlementsController {
    
    /**
     * Metodo que guarda la informacion sobre una liquidacion de un deudor
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * 
     * @param settlement
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtSettlement addSettlement(PojoIntDebtSettlement settlement) throws BloSalesV2Exception;
    
    /**
     * Recupera el historial de los deudores que han pagado
     * 
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntDebtSettlement getDebtorsPaymentsHistory() throws BloSalesV2Exception;
    
}
