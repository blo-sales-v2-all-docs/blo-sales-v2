package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMovementsDetail;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para historial de movimientos
 * @version 1.0.0
 * @author BLO
 */
public interface IHistoryController {
    
    /**
     * Registro de un movimiento en la bd
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param movement
     * @return movimiento registrado
     * @throws BloSalesV2Exception 
     */
    PojoIntMovement registerMovement(PojoIntMovement movement) throws BloSalesV2Exception;
    
    WrapperPojoIntMovementsDetail getHistoryFromProduct(long productId) throws BloSalesV2Exception;
    
}
