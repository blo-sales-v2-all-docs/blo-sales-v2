package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.controller.pojos.enums.TypeCreditDebtIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Gestor de operaciones en base de datos para creditos
 * @version 1.0.0
 * @author BLO
 */
public interface ICreditsDebtsModel {
    
    /**
     * Recupera todos los créditos
     * @param type
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntCredits getAllCreditsByType(TypeCreditDebtIntEnum type) throws BloSalesV2Exception;
    
    /**
     * Recupera un crédito de la bd con el id credit
     * @param idCreditDebt
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit getCreditDebtById(long idCreditDebt) throws BloSalesV2Exception;
    
    /**
     * Abre un crédito en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param creditDebit
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit openCreditDebit(PojoIntCredit creditDebit) throws BloSalesV2Exception;
    
    /**
     * Actualiza un crédito en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param creditDebitInfo
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCredit updateCreditDebit(PojoIntCredit creditDebitInfo) throws BloSalesV2Exception;
    
}
