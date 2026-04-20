package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;

/**
 * controlador para las operaciones de cuentas
 * @version 1.0.0
 * @author BLO
 */
public interface IAccountsController {
    
    /**
     * Metodo que se encarga de agregar dinero a una cuenta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idAccount
     * @param idUser
     * @param amount
     * @param authorization
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntAccount addMoney(long idAccount, long idUser, BigDecimal amount, String authorization) throws BloSalesV2Exception;
    
    /**
     * Metodo que se encarga de resar dinero a una cuenta
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idAccount
     * @param idUser
     * @param amount
     * @param authorization
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntAccount substractMoney(long idAccount, long idUser, BigDecimal amount, String authorization) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera una cuenta por id
     * @param id
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntAccount getAccountById(long id) throws BloSalesV2Exception;
    
}
