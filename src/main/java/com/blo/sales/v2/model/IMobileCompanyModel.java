package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo utilizada para operaciones de companias moviles en la bd
 * @version 1.0.0
 * @author BLO
 *
 */
public interface IMobileCompanyModel {
    
	/**
	 * Metodo que recupera todas las companias de la db
	 * @return wrapper con la lisa de companias
	 * @throws BloSalesV2Exception
	 */
    WrapperPojoIntMobilesCompanies getMobilesCompanies() throws BloSalesV2Exception;
    
    /**
     * Metodo que crea una nueva compania en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param company
     * @return compania creada
     * @throws BloSalesV2Exception
     */
    PojoIntMobileCompany createMobileCompany(PojoIntMobileCompany company) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera una compania especifica por id
     * @param id
     * @return compania encontrada
     * @throws BloSalesV2Exception
     */
    PojoIntMobileCompany getCompanyMobileById(long id) throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza los datos de una compania
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param companyData
     * @param id
     * @return compania actualizada
     * @throws BloSalesV2Exception
     */
    PojoIntMobileCompany updateCompanyMobile(PojoIntMobileCompany companyData, long id) throws BloSalesV2Exception;
}
