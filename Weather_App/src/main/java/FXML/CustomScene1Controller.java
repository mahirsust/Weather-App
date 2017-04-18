/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import java.lang.NullPointerException

/**
 * FXML Controller class
 *
 * @author MAHIR HASAN
 */
public class CustomScene1Controller implements Initializable {

    @FXML
    private Pane Pane1;
    @FXML
    public Button enter_button;
    @FXML
    public TextField location_name;
    @FXML
    private Button about_button;
    boolean hoise = false;

    public String List, countryY;
    public String cityY, cityY1;
    public String[] des1 = new String[10];
    public String[] weather_icon = new String[10];
    public String[] WD = new String[10];
    public double tempP[] = new double[10];
    public double temp_max[] = new double[10];
    public double temp_min[] = new double[10];
    public double clouds[] = new double[10];
    public double hum[] = new double[10];
    public double press[] = new double[10];
    public double WS[] = new double[10];
    public double WD1[] = new double[10];
    public Date current_date = new Date();
    public Date nxtDate[] = new Date[10];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //enter_button.defaultButtonProperty().bind(enter_button.focusedProperty());
        //Platform.runLater(() -> location_name.requestFocus());
        enter_button.setDefaultButton(true);
    }
    
    /*To Get Result Searching of Each City of each Tab*/
    @FXML
    private void enter_button_clicked(ActionEvent event) throws IOException, NullPointerException, ParseException {
        /**
         *
         * @throws IOException
         */
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/untitled2.fxml"));

            //Pane root2 = (Pane) loader.load();
            Parent root2 = (Parent) loader.load();
            Untitled2Controller controller = loader.<Untitled2Controller>getController();
            System.out.println("here");
            System.out.println(location_name.getText());

            controller.cityY = location_name.getText().toLowerCase();
            controller.refresh1.fire();
            System.out.println("here 222222");

            Scene scene1 = new Scene(root2);

            Scene2Controller.getInstance().mytab.getSelectionModel().getSelectedItem().setContent(root2);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("City Not Found");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
            hoise = true;
            location_name.selectAll();
            //Platform.runLater(() -> location_name.requestFocus());
            return;
        }

    }

    /*About Myself and My Course_Teacher*/
    @FXML
    private void about_button_clicked(ActionEvent event) throws IOException {

        Stage currentstage = new Stage(); //(Stage) enter_button.getScene().getWindow();

        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/FXML/Scene4.fxml"));

        Scene scene4 = new Scene(root2);

        currentstage.setScene(scene4);
        currentstage.setTitle("About Me");
        currentstage.show();
    }
    private static CustomScene1Controller instance;

    public CustomScene1Controller() {
        instance = this;
    }
// static method to get instance of view

    public static CustomScene1Controller getInstance() {
        return instance;
    }

}
