package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones de detalles de borrado de una venta
 * @version 1.0.0
 * @author BLO
 *
 */
public interface ISaleDeletedDetailController {
    
	/**
	 * Este metodo registra un item que es el detalle de haber eliminado una venta
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param detail
	 * @return
	 * @throws BloSalesV2Exception
	 */
    PojoIntSaleDeletedDetail addSaleDeletedDetail(PojoIntSaleDeletedDetail detail) throws BloSalesV2Exception;
    
}
