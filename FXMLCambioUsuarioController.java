/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DBAccess.NavegacionDAOException;
import com.sun.javafx.logging.PlatformLogger;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import navigation.Navigation;

/**
 * FXML Controller class
 *
 * @author chw99
 */
public class FXMLCambioUsuarioController extends FXMLBaseController {

    @FXML
    private Button BotonCancelar;
    @FXML
    private Text ErrorPassword;
    @FXML
    private TextField CampoEmail;
    @FXML
    private DatePicker FechaNacimiento;
    @FXML
    private PasswordField PasswordActual;
    @FXML
    private PasswordField PasswordNuevo;
    @FXML
    private ImageView AvatarActual;
    @FXML
    private MenuButton MenuAvatar;
    @FXML
    private Button GuardarCambios;
    @FXML
    private CustomMenuItem avatar1;
    @FXML
    private CustomMenuItem avatar2;
    @FXML
    private CustomMenuItem avatar3;
    @FXML
    private CustomMenuItem avatar4;
    @FXML
    private CustomMenuItem avatarDefault;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    void init() {
        initUserInfo();
    }
    
    @FXML
    private void NavigateToHome(){
        Navigation.navigateToHome((Stage) BotonCancelar.getScene().getWindow(), getClass());
    }
    
    private void initUserInfo(){
        User currentUser = applicationState.getUser();
        CampoEmail.setText(currentUser.getEmail());
        FechaNacimiento.setValue(currentUser.getBirthdate());
        AvatarActual.setImage(currentUser.getAvatar());
        
        CustomMenuItem[] avatars = new CustomMenuItem[] {avatar1, avatar2, avatar3, avatar4, avatarDefault};
        for(CustomMenuItem selectAvatar : avatars){
            selectAvatar.setOnAction(event -> {
                MenuAvatar.setText(selectAvatar.getText());
                String avatarUrl = "/avatars/" + selectAvatar.getText() + "." + "png";
                Image avatar = new Image(avatarUrl, 180, 220, false, false);
                AvatarActual.setImage(avatar);
            }
            );
        }
         
        Button[] actionButton = new Button[]{GuardarCambios, BotonCancelar};
        
        for(Button change: actionButton)
        {
            change.setOnAction(event -> {
                clickedActionButton(change.getText());
            });
        }
    }

    private void clickedActionButton(String text) {
        User changedUser = null;
        changedUser = applicationState.getUser();
        
        if(text == GuardarCambios.getText()){
            if(PasswordActual.getText().length() > 0 && changedUser.getPassword().compareTo(PasswordActual.getText()) == 0)
            {
                if(PasswordNuevo.getText().length() > 0) {
                    Image SelectedAvatar = AvatarActual.getImage();
                    String SelectedEmail = CampoEmail.getText();
                    LocalDate SelectedBirth = FechaNacimiento.getValue();
                    String NewPass = PasswordNuevo.getText();
                    try {
                        changedUser.setEmail(SelectedEmail);
                        changedUser.setBirthdate(SelectedBirth);
                        changedUser.setAvatar(SelectedAvatar);
                        changedUser.setPassword(NewPass);
                    } catch (NavegacionDAOException ex) {
                        Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    NavigateToHome();
                }
                else {
                    ErrorPassword.setVisible(true);
                }
            }
            else {
                ErrorPassword.setVisible(true);
            }
        }
        else {
            NavigateToHome();
        }
        
    }
    
}
