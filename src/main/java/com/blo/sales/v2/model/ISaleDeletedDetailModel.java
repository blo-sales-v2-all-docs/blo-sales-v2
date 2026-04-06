package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo utilizada para guardar los datos de una cancelacion de venta en la db
 * @version 1.0.0
 * @author BLO
 *
 */
public interface ISaleDeletedDetailModel {
    
	/**
	 * Guarda relacion detalles de una venta cancelada en la db
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param detail
	 * @return venta cancelada en db
	 * @throws BloSalesV2Exception
	 */
    PojoIntSaleDeletedDetail addSaleDeletedDetail(PojoIntSaleDeletedDetail detail) throws BloSalesV2Exception;
    
}
