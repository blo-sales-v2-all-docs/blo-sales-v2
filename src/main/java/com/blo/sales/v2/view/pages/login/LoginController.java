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

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	private Button btnLogin;

	@FXML
	private void handleLoginButtonAction() {
		try {
			final PojoUser userData = PojoUser.builder().username(getTextFrom(inputUsuario))
					.password(getTextFrom(inputPassword)).build();

			if (userData.getUsername().isBlank() || userData.getPassword().isBlank()) {
				inputUsuario.setError("Campo requerido");
				inputPassword.setError("Campo requerido");
				return;
			}

			logger.info("Iniciando sesion %s", userData);
			final PojoLoggedInUser userLogged = loggedInUserMapper
					.toOuter(userController.doLogin(userMapper.toInner(userData)));
		} catch (BloSalesV2Exception ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    if (inputUsuario != null && inputPassword != null) {
	        
	        // Estado inicial: deshabilitar el botón si al menos uno está vacío al arrancar
	        actualizarEstadoBoton();

	        // Listener para el input de usuario
	        inputUsuario.getTextProperty().addListener((observable, oldValue, newValue) -> {
	            if (newValue == null || newValue.trim().isBlank()) {
	                inputUsuario.setError("Campo requerido");
	            } else {
	                inputUsuario.setError(null); // Limpia el error si hay texto
	            }
	            actualizarEstadoBoton(); // Reevalúa si el botón debe estar activo o no
	        });

	        // Listener para el input de contraseña
	        inputPassword.getTextProperty().addListener((observable, oldValue, newValue) -> {
	            if (newValue == null || newValue.trim().isBlank()) {
	                inputPassword.setError("Campo requerido");
	            } else {
	                inputPassword.setError(null); // Limpia el error si hay texto
	            }
	            actualizarEstadoBoton(); // Reevalúa si el botón debe estar activo o no
	        });
	    }
	}

	// Método auxiliar para verificar si ambos campos tienen contenido válido
	private void actualizarEstadoBoton() {
	    boolean usuarioValido = inputUsuario.getText() != null && !inputUsuario.getText().trim().isBlank();
	    boolean passwordValido = inputPassword.getText() != null && !inputPassword.getText().trim().isBlank();
	    
	    // El botón se habilita únicamente si ambos campos tienen texto
	    btnLogin.setDisable(!(usuarioValido && passwordValido));
	}
}
