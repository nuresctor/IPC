/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Navigation class made for simplify switching between FXMLs
 * @author chw99
 */
public class Navigation {
    /**
     * Root method
    */
    private static void navigate(Stage stage, Class classType, String res) {
        try {
            Parent root = FXMLLoader.load(classType.getResource(res));
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch(IOException err) {
            System.out.println(err);
        }
    }
    
    public static void navigateToSignIn(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLSignIn.fxml");
    }
    public static void navigateToSignUp(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLSignUp.fxml");
    }
    public static void navigateToHome(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLHome.fxml");
    }
    
    public static void navigateToResetPass(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLResetPass.fxml");
    }

    public static void navigateToMain(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLMain.fxml");
    }
    
    public static void navigateToResults(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLResults.fxml");
    }
    public static void navigateToCambioUsuario(Stage stage, Class classType){
        navigate(stage, classType, "/view/FXMLCambioUsuario.fxml");
    }
}
