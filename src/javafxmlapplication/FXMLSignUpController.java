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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import model.Navegacion;
import navigation.Navigation;
import DBAccess.NavegacionDAOException;
import com.sun.javafx.logging.PlatformLogger;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.PrintStream;
import java.lang.System.Logger;
import java.time.LocalDate;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author chw99
 */
public class FXMLSignUpController extends FXMLBaseController {

    @FXML
    private Button BotonCancelar;
    @FXML
    private TextField CampoUsuario;
    @FXML
    private TextField CampoEmail;
    @FXML
    private PasswordField CampoContraseña;
    @FXML
    private DatePicker FechaNacimiento;
    @FXML
    private Button BotonRegistrarse;
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
    private void NavigateToSignIn(ActionEvent event) {
        Navigation.navigateToSignIn((Stage) BotonCancelar.getScene().getWindow(), getClass());
    }
    
    private void NavigateToHome(){
        Navigation.navigateToHome((Stage) BotonRegistrarse.getScene().getWindow(), getClass());
    }

    @FXML
    private void RegistrarNuevo(ActionEvent event) {
        User u = insertUser(CampoUsuario.getText(), CampoEmail.getText(), CampoContraseña.getText(), LocalDate.MIN);
        if(u != null){
            NavigateToHome();
        } else {
            TextoError.setVisible(true);
        }
    }
    
    private User insertUser(String nickName, String email, String password, LocalDate birthday){
        if(getEmail(email)){
            if(!db.exitsNickName(nickName)){
                User u = null;
                try {
                    u = db.registerUser(nickName, email, password,  birthday);
                } catch (NavegacionDAOException ex) {
                    
                }
                return u;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    private boolean getEmail(String email){
        if (User.checkEmail(email)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
