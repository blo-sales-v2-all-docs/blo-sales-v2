package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Gestor de operaciones en base de datos para creditos
 * @version 1.0.0
 * @author BLO
 */
public interface ICreditsModel {
    
    /**
     * Recupera todos los créditos
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntCredits getAllCredits() throws BloSalesV2Exception;
    
    /**
     * Recupera un crédito de la bd con el id credit
     * @param idCredit
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit getCreditById(long idCredit) throws BloSalesV2Exception;
    
    /**
     * Abre un crédito en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param credit
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit openCredit(PojoIntCredit credit) throws BloSalesV2Exception;
    
    /**
     * Actualiza un crédito en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param creditInfo
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit updateCredit(PojoIntCredit creditInfo) throws BloSalesV2Exception;
    
}
