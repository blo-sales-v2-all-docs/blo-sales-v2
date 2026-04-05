package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones cashboxes-ventas en la db
 * @version 1.0.0
 * @author BLO
 *
 */
public interface ICashboxesSalesModel {
    
	/**
	 * Metodo que guarda la relacion cashbox-sale en la db
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param idCashbox
	 * @param idSale
	 * @return relacion guardada
	 * @throws BloSalesV2Exception
	 */
    PojoIntCashboxSale addCashboxSale(long idCashbox, long idSale) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera la relacion cashbox-sales
     * @param idCashbox 
     * @return items relacionadas con la cashbox
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntCashboxesSalesDetails getCashboxSalesDetailById(long idCashbox) throws BloSalesV2Exception;
}
