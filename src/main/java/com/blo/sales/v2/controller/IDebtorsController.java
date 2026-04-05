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
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param debtor
     * @return deudor guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntDebtor saveDebtor(PojoIntDebtor debtor) throws BloSalesV2Exception;
    
    PojoIntDebtor updateDebtor(PojoIntDebtor debtor, long idDebtor) throws BloSalesV2Exception;
    
    PojoIntDebtor addPayment(BigDecimal pay, long idUser, long idDebtor) throws BloSalesV2Exception;
    
    WrapperPojoIntDebtorsDetails getDebtorsDetails() throws BloSalesV2Exception;
    
    void deleteDebtor(long idDebtor) throws BloSalesV2Exception;
    
}
