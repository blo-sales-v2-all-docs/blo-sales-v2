package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntLoggedInUser;
import com.blo.sales.v2.controller.pojos.PojoIntNote;
import com.blo.sales.v2.controller.pojos.PojoIntUser;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntNotes;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones de usuario en la bd
 * @version 1.0.0
 * @author BLO
 *
 */
public interface IUserModel {
    
	/**
	 * Metodo que registra una nota
	 * <br>
	 * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
	 * @param note
	 * @return nota guardada
	 * @throws BloSalesV2Exception
	 */
    PojoIntNote addNote(PojoIntNote note) throws BloSalesV2Exception;
    
    /**
     * Recupera todas las notas relacionadas con un usuario
     * @param idUser
     * @return notas
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntNotes getNotesByUserId(long idUser) throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza la informacion de una nota. <i>No actualiza el tipo de nota</i>
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param note
     * @return
     * @throws BloSalesV2Exception
     */
    PojoIntNote updateNote(PojoIntNote note) throws BloSalesV2Exception;
    
    /**
     * Metodo que elimina una nota de la bd
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param idNote
     * @throws BloSalesV2Exception
     */
    void deleteNote(long idNote) throws BloSalesV2Exception;
    
    /**
     * Metodo que hace login con los datos de usuario
     * @param userData
     * @return login
     * @throws BloSalesV2Exception
     */
    PojoIntLoggedInUser doLogin(PojoIntUser userData) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera los datos de un usuario usando el id como referencia
     * @param id
     * @return datos de usuario sin password
     * @throws BloSalesV2Exception
     */
    PojoIntUser getUserById(long id) throws BloSalesV2Exception;
    
}
