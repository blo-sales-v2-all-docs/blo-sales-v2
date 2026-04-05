package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCashbox;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxes;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesDetails;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para guardar operaciones de la cashbox en la bd
 * @version 1.0.0
 * @author BLO
 */
public interface ICashboxModel {
    
    /**
     * Crea una nueva cashbox en la bd
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param cashbox
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCashbox addCashbox(PojoIntCashbox cashbox) throws BloSalesV2Exception;
    
    /**
     * Actualiza la informacion de una cashbox en la bd
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param cashbox
     * @param idCashbox
     * @return cashbox con informacion actualizada
     * @throws BloSalesV2Exception 
     */
    PojoIntCashbox updateCashbox(PojoIntCashbox cashbox, long idCashbox) throws BloSalesV2Exception;
    
    /**
     * Recupera la informacion de la cashbox abierta de la bd
     * @return null si no existe una caja abierta
     * @throws BloSalesV2Exception 
     */
    PojoIntCashbox getOpenCashbox() throws BloSalesV2Exception;
    
    WrapperPojoIntCashboxes getAllCashboxes() throws BloSalesV2Exception;
    
    WrapperPojoIntCashboxesDetails getCashboxesDetail() throws BloSalesV2Exception;
}
