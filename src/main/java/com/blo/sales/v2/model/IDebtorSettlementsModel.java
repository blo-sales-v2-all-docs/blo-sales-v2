package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtSettlement;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para pagos hechos por deudores hacia la db
 * @version 1.0.0
 * @author BLO
 */
public interface IDebtorSettlementsModel {
    
    /**
     * Metodo que guarda la informacion sobre una liquidacion de un deudor en la bd
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
