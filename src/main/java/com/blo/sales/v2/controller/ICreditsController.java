package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;

/**
 * Clase para operaciones de créditos
 * @version 1.0.0
 * @author BLO
 */
public interface ICreditsController {
    
    /**
     * Recupera todos los créditos de la db son filtros
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntCredits getAllCredits() throws BloSalesV2Exception;
    
    /**
     * cambia el nombre del prestamista
     * @param name
     * @param idCredit
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit changeNameOfLanderName(String name, long idCredit) throws BloSalesV2Exception;
    
    /**
     * Guarda un nuevo crédito
     * @param credit
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit saveCredit(PojoIntCredit credit) throws BloSalesV2Exception;
    
    /**
     * Agrega un pago
     * @param payment
     * @param idCredit
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit addPayment(BigDecimal payment, long idCredit) throws BloSalesV2Exception;
    
    /**
     * Elimina un crédito de forma lógica
     * @param idCredit
     * @throws BloSalesV2Exception 
     */
    void deleteCredit(long idCredit) throws BloSalesV2Exception;
    
    
}
