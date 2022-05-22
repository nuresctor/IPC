/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import navigation.Navigation;
import model.User;
import model.Navegacion;

/**
 * FXML Controller class
 *
 * @author chw99
 */
public class FXMLSignInController extends FXMLBaseController {

    @FXML
    private TextField CampoUsuario;
    @FXML
    private PasswordField CampoPassword;
    @FXML
    private Button BotonIniciarSesion;
    @FXML
    private Button BotonRegistrar;
    @FXML
    private Text TextoError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IniciarSesion(ActionEvent event) {
        User u = getUser(CampoUsuario.getText(), CampoPassword.getText());
        if (u != null){
            NavigateToHome();
        } else {
            TextoError.setVisible(true);
        }
    }
   
    private User getUser(String nickName, String password) {
        User u = db.loginUser(nickName, password);
        return u;
    }

    @FXML
    private void NavigateToSignUp(ActionEvent event) {
        Navigation.navigateToSignUp((Stage) BotonIniciarSesion.getScene().getWindow(), getClass());
    }
    
    private void NavigateToHome(){
        Navigation.navigateToHome((Stage) BotonIniciarSesion.getScene().getWindow(), getClass());
    }

    @Override
    void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
