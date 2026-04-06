package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para registrar recargas telefonicas en la bd
 * @version 1.0.0
 * @author BLO
 *
 */
public interface ITopUpModel {
    
	/**
	 * Metodo que guarda un registro de una db
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param data
	 * @return recarga guardada
	 * @throws BloSalesV2Exception
	 */
    PojoIntTopUp addTopUp(PojoIntTopUp data) throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza la informacion de un registro de la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param data
     * @param idTopUp
     * @return item actualizado
     * @throws BloSalesV2Exception
     */
    PojoIntTopUp updateTopUp(PojoIntTopUp data, long idTopUp) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera una lista de recargas por status
     * @param status
     * @return lista de items
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception;
}
