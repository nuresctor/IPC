/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXMLApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
     
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("/view/FXMLSignIn.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/style.css");
 
        stage.setScene(scene);
        stage.setTitle("LOGIN");
        stage.setResizable(false); //para que no se pueda redimensionar
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }


    
}
