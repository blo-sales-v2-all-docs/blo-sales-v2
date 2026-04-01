package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IUserController;
import com.blo.sales.v2.controller.pojos.PojoIntLoggedInUser;
import com.blo.sales.v2.controller.pojos.PojoIntNote;
import com.blo.sales.v2.controller.pojos.PojoIntUser;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntNotes;
import com.blo.sales.v2.model.IUserModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserControllerImpl implements IUserController {
    
    @Inject
    private IUserModel userModel;
    
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
        return userModel.addNote(note);
    }

    @Override
    public WrapperPojoIntNotes getNotesByUserId(long idUser) throws BloSalesV2Exception {
        return userModel.getNotesByUserId(idUser);
    }

    @Override
    public PojoIntNote updateNote(PojoIntNote note) throws BloSalesV2Exception {
        note.setTimesamp(BloSalesV2Utils.getTimestamp());
        return userModel.updateNote(note);
    }

    @Override
    public void deleteNote(long idNote) throws BloSalesV2Exception {
        userModel.deleteNote(idNote);
    }
    
}
