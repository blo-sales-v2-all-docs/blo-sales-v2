package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMovementsDetail;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones de movimientos en la bd
 * @version 1.0.0
 * @author BLO
 */
public interface IHistoryModel {
    
    /**
     * Registra un movimiento en la bd
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param movement
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntMovement registerMovement(PojoIntMovement movement) throws BloSalesV2Exception;
    
    WrapperPojoIntMovementsDetail getHistoryFromProduct(long productId) throws BloSalesV2Exception;
}
