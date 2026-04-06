package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntDebtor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtors;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtorsDetails;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;

/**
 * Controlador para flujo de deudores
 * @version 1.0.0
 * @author BLO
 */
public interface IDebtorsController {
    
    WrapperPojoIntDebtors getAllDebtors()throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera un deudor por id
     * @param idDebtor
     * @return deudor encontrado
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor getDebtorById(long idDebtor) throws BloSalesV2Exception;
    
    /**
     * Metodo que guarda un deudor
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param debtor
     * @return deudor guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor saveDebtor(PojoIntDebtor debtor) throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza la informacion de un deudor
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param debtor
     * @param idDebtor
     * @return deudor actualizado
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor updateDebtor(PojoIntDebtor debtor, long idDebtor) throws BloSalesV2Exception;
    
    /**
     * Metodo que guarda un pago de deudor o lo elimina si se paga completamente
     * @param pay
     * @param idUser
     * @param idDebtor
     * @return deudor con el id de la venta
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor addPayment(BigDecimal pay, long idUser, long idDebtor) throws BloSalesV2Exception;
    
    PojoIntDebtor addPaymentNotCommitEnabled(BigDecimal pay, long idUser, long idDebtor) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todos los deudores de la bd
     * @return lista de deudores
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntDebtorsDetails getDebtorsDetails() throws BloSalesV2Exception;
    
    /**
     * Metodo que elimina un deudor de la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idDebtor
     * @throws BloSalesV2Exception 
     */
    void deleteDebtor(long idDebtor) throws BloSalesV2Exception;
    
}
