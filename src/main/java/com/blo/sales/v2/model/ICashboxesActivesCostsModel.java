package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxesActivesCosts;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones en la bd sobre la relacion cashboxes-actives/costs
 * @version 1.0.0
 * @author BLO
 *
 */
public interface ICashboxesActivesCostsModel {
    
	/**
	 * Metodo que guarda la relacion cashbox-actives/costs
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param data
	 * @return relacion guardada 
	 * @throws BloSalesV2Exception
	 */
    PojoIntCashboxesActivesCosts addRelationship(PojoIntCashboxesActivesCosts data) throws BloSalesV2Exception;
    
}
