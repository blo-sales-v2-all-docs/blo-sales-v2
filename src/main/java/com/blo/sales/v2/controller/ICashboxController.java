package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntCashbox;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxes;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesDetails;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para cashbox
 * @version 1.0.0
 * @author BLO
 */
public interface ICashboxController {
    
    PojoIntCashbox closeCashbox(PojoIntCashbox cashbox, WrapperPojoIntActivesCosts activesCosts) throws BloSalesV2Exception;
    
    /**
     * Crea una nueva cashbox abierta
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param cashbox
     * @return cashbox
     * @throws BloSalesV2Exception 
     */
    PojoIntCashbox addCashbox(PojoIntCashbox cashbox) throws BloSalesV2Exception;
    
    /**
     * Actualiza la informacion de una cashbox
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param cashbox
     * @param idCashbox
     * @return cashbox actualizada
     * @throws BloSalesV2Exception 
     */
    PojoIntCashbox updateCAshbox(PojoIntCashbox cashbox, long idCashbox) throws BloSalesV2Exception;
    
    /**
     * Recupera una caja abierta
     * @return null si no existe una caja abierta
     * @throws BloSalesV2Exception 
     */
    PojoIntCashbox getOpenCashbox() throws BloSalesV2Exception;
    
    WrapperPojoIntCashboxes getAllCashboxes() throws BloSalesV2Exception;
    
    WrapperPojoIntCashboxesDetails getCashboxesDetail() throws BloSalesV2Exception;
}
