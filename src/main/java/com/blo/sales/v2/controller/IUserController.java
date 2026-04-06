package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntLoggedInUser;
import com.blo.sales.v2.controller.pojos.PojoIntNote;
import com.blo.sales.v2.controller.pojos.PojoIntUser;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntNotes;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones de usuario
 * @version 1.0.0
 * @author BLO
 */
public interface IUserController {
    
    /**
     * Metodo que guarda una nota ligada a un usuario
     * @param note
     * @return nota guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntNote addNote(PojoIntNote note) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera las notas de un usuario
     * @param idUser
     * @return notas de usuario
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntNotes getNotesByUserId(long idUser) throws BloSalesV2Exception;
    
    /**
     * Metodo que actualiza los datos de una nota
     * @param note
     * @return nota actualizada
     * @throws BloSalesV2Exception 
     */
    PojoIntNote updateNote(PojoIntNote note) throws BloSalesV2Exception;
    
    /**
     * Metodo que borra una nota
     * @param idNote
     * @throws BloSalesV2Exception 
     */
    void deleteNote(long idNote) throws BloSalesV2Exception;
    
    /**
     * Metodo login para usuario
     * @param userData
     * @return datos de login <code>id, username, rol</code>
     * @throws BloSalesV2Exception 
     */
    PojoIntLoggedInUser doLogin(PojoIntUser userData) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera informacion basica de un usuario
     * @param id
     * @return informacion basica de usuario
     * @throws BloSalesV2Exception 
     */
    PojoIntUser getUserById(long id) throws BloSalesV2Exception;
}
