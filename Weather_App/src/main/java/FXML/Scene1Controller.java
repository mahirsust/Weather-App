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
public class Scene1Controller implements Initializable {

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
    static String cityY;
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
    
    /*To Get the Direction of Wind*/
    public String dir(int i){
        String ss = new String();
        double d = WD1[i];
        if(WD1[i]>=348.75 && WD1[i]<11.25){
                ss+=Double.toString(d);
                ss+="° N";
            }
            else if(WD1[i]>=11.25 && WD1[i]<33.75){
                ss+=Double.toString(d);
                ss+="° NNE";
            }
            else if(WD1[i]>=33.75 && WD1[i]<56.25){
                ss+=Double.toString(d);
                ss+="° NE";
            }
            else if(WD1[i]>=56.25 && WD1[i]<78.75){
                ss+=Double.toString(d);
                ss+="° ENE";
            }
            else if(WD1[i]>=78.75 && WD1[i]<101.25){
                ss+=Double.toString(d);
                ss+="° E";
            }
            else if(WD1[i]>=101.25 && WD1[i]<123.75){
                ss+=Double.toString(d);
                ss+="° ESE";
            }
            else if(WD1[i]>=123.75 && WD1[i]<146.25){
                ss+=Double.toString(d);
                ss+="° SE";
            }
            else if(WD1[i]>=146.25 && WD1[i]<168.75){
                ss+=Double.toString(d);
                ss+="° SSE";
            }
            else if(WD1[i]>=168.75 && WD1[i]<191.25){
                ss+=Double.toString(d);
                ss+="° S";
            }
            else if(WD1[i]>=191.25 && WD1[i]<213.75){
                ss+=Double.toString(d);
                ss+="° SSW";
            }
            else if(WD1[i]>=213.75 && WD1[i]<236.25){
                ss+=Double.toString(d);
                ss+="° SW";
            }
            else if(WD1[i]>=236.25 && WD1[i]<258.75){
                ss+=Double.toString(d);
                ss+="° WSW";
            }
            else if(WD1[i]>=258.75 && WD1[i]<281.25){
                ss+=Double.toString(d);
                ss+="° W";
            }
            else if(WD1[i]>=281.25 && WD1[i]<303.75){
                ss+=Double.toString(d);
                ss+="° WNW";
            }
            else if(WD1[i]>=303.75 && WD1[i]<326.25){
                ss+=Double.toString(d);
                ss+="° NW";
            }
            else if(WD1[i]>=326.25 && WD1[i]<348.75){
                ss+=Double.toString(d);
                ss+="° NNW";
            }
        return ss;
    }
    
    /*Call the OpenWeatherMap API
        Get the Json Data Of Corresponding City
        Search by City_ID
    */
    public void PARSER() throws IOException, ParseException {

        String default1 = "http://api.openweathermap.org/data/2.5/forecast/daily?id=";
        String default2 = "&units=metric&cnt=7&APPID=a19e9f99d3ad3e8fe4a0c84367193dda";

        int cityID;
        String City_Name = location_name.getText().toLowerCase();
        try{
            cityID = weather.app.WeatherApp.myMap.get(City_Name);
        } 
        catch (NullPointerException e) {
            
            System.out.println("city -> " + City_Name);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("City Not Found");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
            hoise = true;
            return;
        }
        List = "";
        URL Open_Weather = new URL(default1 + cityID + default2);
        URLConnection yc = Open_Weather.openConnection();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()))) {
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                List += inputLine;
                //System.out.println(inputLine);
            }
        } catch (IOException e) {
            hoise = true;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("NO INTERNET CONNECTION");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

        current_date = new Date();
        System.out.println(List);
        JSONObject tt44 = new JSONObject(List);
        //System.out.println(List);
        /*Put all type of Data from JSON
            to show Weather_Update
        */ 
        try {
            JSONObject pp = tt44.getJSONObject("city");
            cityY = pp.getString("name");//System.out.println("   -> " + cityID);
            countryY = pp.getString("country");
            JSONArray ar = tt44.getJSONArray("list");
            tempP[0] = ar.getJSONObject(0).getJSONObject("temp").getDouble("day");
            temp_max[0] = ar.getJSONObject(0).getJSONObject("temp").getDouble("max");
            temp_min[0] = ar.getJSONObject(0).getJSONObject("temp").getDouble("min"); 
            press[0] = ar.getJSONObject(0).getDouble("pressure");
            hum[0] = ar.getJSONObject(0).getDouble("humidity");
            des1[0] = ar.getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
            weather_icon[0] = ar.getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("icon");
            clouds[0] = ar.getJSONObject(0).getDouble("clouds");
            WS[0] = ar.getJSONObject(0).getDouble("speed");
            WD1[0] = ar.getJSONObject(0).getDouble("deg");
//            System.out.println("WD   "  + WD12);
            WD[0] = dir(0);
            int ii;
            for ( ii = 1; ii <= 6; ii++) {
                pp = tt44.getJSONObject("city");
                cityY = pp.getString("name");
                countryY = pp.getString("country");
                ar = tt44.getJSONArray("list");
                tempP[ii] = ar.getJSONObject(ii).getJSONObject("temp").getDouble("day");
                temp_max[ii] = ar.getJSONObject(ii).getJSONObject("temp").getDouble("max");
                temp_min[ii] = ar.getJSONObject(ii).getJSONObject("temp").getDouble("min"); 
                press[ii] = ar.getJSONObject(ii).getDouble("pressure");
                hum[ii] = ar.getJSONObject(ii).getDouble("humidity");
                des1[ii] = ar.getJSONObject(ii).getJSONArray("weather").getJSONObject(0).getString("description");
                weather_icon[ii] = ar.getJSONObject(ii).getJSONArray("weather").getJSONObject(0).getString("icon");
                clouds[ii] = ar.getJSONObject(ii).getDouble("clouds");
                WS[ii] = ar.getJSONObject(ii).getDouble("speed");
                WD1[ii] = ar.getJSONObject(ii).getDouble("deg");
                WD[ii] = dir(ii);
            }
        } catch (JSONException e) {
            System.out.println("JSON e somossha");
        }
    }

    /*Enter_button_clicked search a weather update of a city by their City_ID*/
    @FXML
    private void enter_button_clicked(ActionEvent event) throws IOException, NullPointerException, ParseException {
        /**
         *
         * @throws IOException
         */
        PARSER();
        weather.app.WeatherApp.getInstance().m21++;
        if (hoise == true) {
            hoise = false;
            weather.app.WeatherApp.getInstance().m21--;
            //location_name.setText("");
            location_name.selectAll();
            //Platform.runLater(() -> location_name.requestFocus());
        } else {
            hoise = false;
            if(weather.app.WeatherApp.getInstance().m21==1){
            try {
//                System.out.println("   -> " + weather.app.WeatherApp.getInstance().m21);
                Stage currentstage = (Stage) enter_button.getScene().getWindow();

                Parent root1 = FXMLLoader.load(getClass().getResource("/FXML/Scene2.fxml"));

                Scene scene1 = new Scene(root1);
                currentstage.setScene(scene1);
                currentstage.setTitle("Weather Update");
//                Scene2Controller.getInstance().mytab.getSelectionModel().getSelectedItem().setContent(root1);
                currentstage.show();
            } catch (NullPointerException e) {
                System.out.println("paisi");
            }
            }
            else if(weather.app.WeatherApp.getInstance().m21>=2){
                try {
//                    System.out.println("  mm -> " + weather.app.WeatherApp.getInstance().m21);
                    Stage currentstage;
                    currentstage = (Stage) enter_button.getScene().getWindow();
               Parent root1 = FXMLLoader.load(getClass().getResource("/FXML/Reset2.fxml"));

                Scene scene1 = new Scene(root1);
                Scene2Controller.getInstance().mytab.getSelectionModel().getSelectedItem().setContent(root1);
//                currentstage.setScene(scene1);
                currentstage.setTitle("Weather Update");
                currentstage.show();
            } catch (NullPointerException e) {
                System.out.println("paisi2");
            }
            }
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
    private static Scene1Controller instance;

    public Scene1Controller() {
        instance = this;
    }
// static method to get instance of view

    public static Scene1Controller getInstance() {
        return instance;
    }

}
