package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntProducts;
import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para productos
 * @version 1.0.0
 * @author BLO
 */
public interface IProductsController {
    
    /**
     * Metodo que guarda la informacion de un nuevo producto
     * @param product
     * @return producto guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntProduct registerProduct(PojoIntProduct product) throws BloSalesV2Exception;
    
    /**
     * Actualiza informacion de un producto
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param product
     * @param reasons
     * @param idUser
     * @param type
     * @return
     * @throws BloSalesV2Exception
     */
    PojoIntProduct updateProductInfoNoCommitEnabled(PojoIntProduct product, ReasonsIntEnum reasons, long idUser, TypesIntEnum type) throws BloSalesV2Exception;
    
    /**
     * Actualiza la informacion de un producto
     * @param product
     * @param reasons
     * @param idUser
     * @param type
     * @return producto actualizado
     * @throws BloSalesV2Exception 
     */
    PojoIntProduct updateProductInfo(PojoIntProduct product, ReasonsIntEnum reasons, long idUser, TypesIntEnum type) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todos los productos de la bd
     * @return todos productos de la bd
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntProducts getAllProducts() throws BloSalesV2Exception;
    
    /**
     * Recupera un producto mediante el id
     * @param idProduct
     * @return producto encontrado
     * @throws BloSalesV2Exception 
     */
    PojoIntProduct getProductById(long idProduct) throws BloSalesV2Exception;
       
    /**
     * Actualiza la informacion de un producto guardando el cambio de precio en el historial
     * @param product
     * @param reasons
     * @param idUser
     * @param type
     * @return producto actualizado
     * @throws BloSalesV2Exception 
     */
    PojoIntProduct updateProductInfoSavingPriceOnHistory(PojoIntProduct product, ReasonsIntEnum reasons, long idUser, TypesIntEnum type) throws BloSalesV2Exception;
}
