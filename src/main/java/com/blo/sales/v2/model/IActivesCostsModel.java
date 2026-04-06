package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones de activos y costos en la bd
 * @version 1.0.0
 * @author BLO
 *
 */
public interface IActivesCostsModel {
    
	/**
	 * Metodo que guarda activos y costos
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param activeCost
	 * @return
	 * @throws BloSalesV2Exception
	 */
    WrapperPojoIntActivesCosts addActiveCost(WrapperPojoIntActivesCosts activeCost) throws BloSalesV2Exception;
    
}
