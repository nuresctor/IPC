/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import navigation.Navigation;
import model.Session;
import model.User;

/**
 * FXML Controller class
 *
 * @author chw99
 */
public class FXMLResultsController extends FXMLBaseController {

    @FXML
    private DatePicker StartDay;
    @FXML
    private DatePicker EndDay;
    @FXML
    private Button BotonVolver;
    @FXML
    private BarChart<String, Number> BarChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NavigateToHome(ActionEvent event) {
        Navigation.navigateToHome((Stage) BotonVolver.getScene().getWindow(), getClass());
    }

    @Override
    void init() {
        initChart();
        initGraph();
    }

    private void initChart() {
        
        User u = applicationState.getUser();
        
        DatePicker[] days = new DatePicker[] {StartDay, EndDay};
        for(DatePicker day: days){
            day.setOnAction(event -> {
                if(StartDay.getValue().compareTo(EndDay.getValue()) <= 0) {
                    changeDate();
                }
                else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setHeaderText("Fecha incorrecta");
                    alert.show();
                }
            });
        }
    }

    private void changeDate() {
        applicationState.setStartDate(StartDay.getValue());
        applicationState.setEndDate(EndDay.getValue());
        initGraph();
    }
        
    private void initGraph() {
        BarChart.getData().clear();
        BarChart.animatedProperty().setValue(false);
        BarChart.setTitle("Historial");
        XYChart.Series serie = new XYChart.Series();
        
        serie.setName("Historial");
        serie.getData().add(new XYChart.Data("Aciertos", sesion.getHits()));
        serie.getData().add(new XYChart.Data("Fallos", sesion.getFaults()));
        BarChart.getData().addAll(serie);
        StartDay.setValue(applicationState.getStartDate());
        EndDay.setValue(applicationState.getEndDate());
    }

}
