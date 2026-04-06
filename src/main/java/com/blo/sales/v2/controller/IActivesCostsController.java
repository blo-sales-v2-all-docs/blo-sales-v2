package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones de activos y costos
 * @author orlndo
 */
public interface IActivesCostsController {
    
    /**
     * Metodo que guarda activos y costoss
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param activeCost
     * @return activos y costos guardados
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntActivesCosts addActiveCost(WrapperPojoIntActivesCosts activeCost) throws BloSalesV2Exception;
    
}
