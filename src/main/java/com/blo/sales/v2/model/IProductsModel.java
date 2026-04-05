package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntProducts;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones de productos de la bd
 * @version 1.0.0
 * @author BLO
 */
public interface IProductsModel {
    
    /**
     * Metodo utilizad para registrar un producto en la bd
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param product
     * @return producto guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntProduct registerProduct(PojoIntProduct product) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todos los productos de la bd
     * @return todos los productos de la bd
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntProducts getAllProducts() throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza informacion de un producto en la bd
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param product
     * @return producto actualizado
     * @throws BloSalesV2Exception 
     */
    PojoIntProduct updateProductInfo(PojoIntProduct product) throws BloSalesV2Exception;
    
    PojoIntProduct getProductById(long idProduct) throws BloSalesV2Exception;
    
    PojoIntProduct getProductByBarCode(String barCode) throws BloSalesV2Exception;
    
}
