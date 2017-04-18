/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MAHIR HASAN
 */
public class WeatherApp extends Application {

    public static Map<String, Integer> myMap = new HashMap<String, Integer>();
    public int m21 = 0;
    
    /*Start With a page for a input of a city_name*/
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Scene1.fxml"));
        INIT_MAO();
        Scene scene = new Scene(root);
        stage.setTitle("Weather APP");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        
        stage.setResizable(false);
        stage.show();
        String City_Name;
    }
    
    /**To Map the City_Name to it's ID_Number
     Reading a file City_Name and City_ID*/
    public void INIT_MAO() throws IOException{
        
        URL file = new URL(getClass().getResource("/FXML/country_code.txt").toString());
        URLConnection yc = file.openConnection();
        System.out.println("file = " + file.getPath());
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = null, city;
            int id;
            while ((inputLine = in.readLine()) != null) {
                String[] alada= inputLine.split(" ");
                city = alada[0];
                id = Integer.parseInt(alada[1]);
                myMap.put(city, id);
                //System.out.println(city + " -> " + id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static WeatherApp instance;

    public WeatherApp() {
        instance = this;
    }
// static method to get instance of view

    public static WeatherApp getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
