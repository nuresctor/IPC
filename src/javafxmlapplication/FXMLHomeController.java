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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import navigation.Navigation;

/**
 * FXML Controller class
 *
 * @author chw99
 */
public class FXMLHomeController extends FXMLBaseController {

    @FXML
    private ImageView UserAvatar;
    @FXML
    private Button UserChange;
    @FXML
    private Text UserName;
    @FXML
    private Button ButtonRandom;
    @FXML
    private Button ButtonChoose;
    @FXML
    private Button ButtonResults;
    @FXML
    private Button BotonCerrarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UserLogOut(ActionEvent event) { 
        Navigation.navigateToSignIn((Stage) BotonCerrarSesion.getScene().getWindow(), getClass());
    }

    @FXML
    private void NavigateToMain(ActionEvent event) {
        Navigation.navigateToMain((Stage) ButtonRandom.getScene().getWindow(), getClass());
    }


    @Override
    void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void NavigateToResults(ActionEvent event) {
        Navigation.navigateToResults((Stage) ButtonResults.getScene().getWindow(), getClass());
    }

    @FXML
    private void NavigateToCambioUsuario(ActionEvent event) {
        Navigation.navigateToCambioUsuario((Stage) UserChange.getScene().getWindow(), getClass());
    }
    
}
