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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author chw99
 */
public class FXMLResultsController implements Initializable {

    @FXML
    private DatePicker StartDay;
    @FXML
    private DatePicker EndDay;
    @FXML
    private LineChart<?, ?> LineChart;
    @FXML
    private NumberAxis AxisY;
    @FXML
    private CategoryAxis AxisX;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NavigateToHome(ActionEvent event) {
    }
    
}
