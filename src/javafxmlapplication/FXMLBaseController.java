/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DBAccess.NavegacionDAOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.Navegacion;

/**
 *
 * @author chw99
 */
public abstract class FXMLBaseController implements Initializable {
    
    protected Navegacion db;
    protected ApplicationState applicationState;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDB();
        init();
    }
    
    private void initDB() {
        try {
            db = Navegacion.getSingletonNavegacion();
        } catch (NavegacionDAOException err) {
            System.out.println(err);
        }
    }
   
    
    abstract void init();
    
}
