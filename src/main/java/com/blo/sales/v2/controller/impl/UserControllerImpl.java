package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IUserController;
import com.blo.sales.v2.controller.pojos.PojoIntLoggedInUser;
import com.blo.sales.v2.controller.pojos.PojoIntNote;
import com.blo.sales.v2.controller.pojos.PojoIntUser;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntNotes;
import com.blo.sales.v2.model.IUserModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserControllerImpl implements IUserController {
    
    private static final GUILogger logger = GUILogger.getLogger(UserControllerImpl.class.getName());
    
    @Inject
    private IUserModel userModel;
    
    @Inject
    private IDBTransactionManagerController dbtm;
    
    @Override
    public PojoIntLoggedInUser doLogin(PojoIntUser userData) throws BloSalesV2Exception {
        return userModel.doLogin(userData);
    }

    @Override
    public PojoIntUser getUserById(long id) throws BloSalesV2Exception {
        return userModel.getUserById(id);
    }

    @Override
    public PojoIntNote addNote(PojoIntNote note) throws BloSalesV2Exception {
        try {
            dbtm.disableAutocommit();
            final var noteSaved = userModel.addNote(note);
            dbtm.doCommit();
            return noteSaved;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtm.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtm.enableAutocommit();
        }
    }

    @Override
    public WrapperPojoIntNotes getNotesByUserId(long idUser) throws BloSalesV2Exception {
        return userModel.getNotesByUserId(idUser);
    }

    @Override
    public PojoIntNote updateNote(PojoIntNote note) throws BloSalesV2Exception {
        try {
            dbtm.disableAutocommit();
            note.setTimesamp(BloSalesV2Utils.getTimestamp());
            final var noteUpdated = userModel.updateNote(note);
            dbtm.doCommit();
            return noteUpdated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtm.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtm.enableAutocommit();
        }
    }

    @Override
    public void deleteNote(long idNote) throws BloSalesV2Exception {
        try {
            dbtm.disableAutocommit();
            userModel.deleteNote(idNote);
            dbtm.doCommit();
        } catch(BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtm.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtm.enableAutocommit();
        }
    }
    
}
