package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Modelo para las operaciones de cuentas en la bd
 * @version 1.0.0
 * @author BLO
 */
public interface IAccountsModel {
    
    /**
     * Metodo que actualiza una cuenta en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idAccount
     * @param account
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntAccount updateAccount(long idAccount, PojoIntAccount account) throws BloSalesV2Exception;
    
    /**
     * Recupera la informacion de una cuenta por id
     * @param id
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntAccount getAccountById(long id) throws BloSalesV2Exception;
    
}
