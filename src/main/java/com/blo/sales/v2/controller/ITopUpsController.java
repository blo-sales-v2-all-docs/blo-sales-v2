package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para recargas telefonicas
 * @version 1.0.0
 * @author BLO
 */
public interface ITopUpsController {
    
    /**
     * Metodo que guarda una recarga y agrega la comision a la cuenta
     * @param data
     * @param idCompany
     * @return recarga guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntTopUp addTopUp(PojoIntTopUp data, long idCompany) throws BloSalesV2Exception;
    
    /**
     * Metodo que cierra todas las recargas, es decir, ya se pago
     * @param topUps
     * @return lista de recargas hechas
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntTopUp closeTopUps(WrapperPojoIntTopUp topUps) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todas las recargas por un filtro
     * @param status
     * @return recargas
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception;
    
}
