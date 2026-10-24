package com.blo.sales.v2.view.pages.login;

import com.blo.sales.v2.controller.IUserController;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.LoginFrm;
import com.blo.sales.v2.view.commons.AbstractController;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.components.inputPassword.InputPassword;
import com.blo.sales.v2.view.components.inputText.InputText;
import com.blo.sales.v2.view.mappers.LoggedInUserMapper;
import com.blo.sales.v2.view.mappers.UserMapper;
import com.blo.sales.v2.view.pojos.PojoLoggedInUser;
import com.blo.sales.v2.view.pojos.PojoUser;
import jakarta.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AbstractController {
    
    private static final GUILogger logger = GUILogger.getLogger(LoginFrm.class.getName());
    
    @Inject
    private IUserController userController;
    
    @Inject
    private UserMapper userMapper;
    
    @Inject
    private LoggedInUserMapper loggedInUserMapper;

    @FXML
    private InputText inputUsuario;

    @FXML
    private InputPassword inputPassword;

    @FXML
    private Label lblMensaje;
    
    @FXML
    private void handleLoginButtonAction() {
        try {
            final PojoUser userData = 
                PojoUser.builder().username(getTextFrom(inputUsuario)).password(getTextFrom(inputPassword)).build();
            
            if (userData.getUsername().isBlank() || userData.getPassword().isBlank()) {
            	inputUsuario.setError("Campo requerido");
                inputPassword.setError("Campo requerido");
                return;
            }
        
            logger.info("Iniciando sesion %s", userData);
            final PojoLoggedInUser userLogged = 
                    loggedInUserMapper.toOuter(userController.doLogin(userMapper.toInner(userData)));
        } catch (BloSalesV2Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
