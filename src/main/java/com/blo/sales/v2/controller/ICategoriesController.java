package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntCategory;
import com.blo.sales.v2.controller.pojos.WrapperIntPojoCategories;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Operaciones para las categorias dispobibles
 * @version 1.0.0
 * @author BLO
 */
public interface ICategoriesController {

    /**
     * guarda una categoria en la base de datos
     * 
     * @param category
     * @return categoria guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntCategory registerCategory(PojoIntCategory category) throws BloSalesV2Exception;
    
    /**
     * Recupera todas las categorias
     * @return lista de categorias
     * @throws BloSalesV2Exception 
     */
    WrapperIntPojoCategories getAllCategories() throws BloSalesV2Exception;
    
    /**
     * Actualiza una categoria
     * @param id
     * @param newData
     * @return categoria actualizada
     * @throws BloSalesV2Exception 
     */
    PojoIntCategory updateCategory(long id, PojoIntCategory newData) throws BloSalesV2Exception;
    
    /**
     * Recupera una categoria especifica
     * @param id
     * @return categoria
     * @throws BloSalesV2Exception 
     */
    PojoIntCategory getCategoryById(long id) throws BloSalesV2Exception;

}
