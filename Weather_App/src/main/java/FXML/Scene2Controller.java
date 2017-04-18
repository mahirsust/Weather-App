/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import static FXML.Scene1Controller.cityY;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import weather.app.WeatherApp;

public class Scene2Controller implements Initializable {

    public TabPane mytab;
    @FXML
    private AnchorPane anchor_pane;
    @FXML
    private Label t1;
    @FXML
    private Label city;
    @FXML
    private Label country;
    @FXML
    private Label temp1;
    @FXML
    private Label d1;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label c1;
    @FXML
    private Label p1;
    @FXML
    private Label h1;
    @FXML
    private Label w1;
    @FXML
    private Label w2;
    @FXML
    private AnchorPane anchor_pane1;
    @FXML
    private Label city1;
    @FXML
    private Label country1;
    @FXML
    private Label temp11;
    @FXML
    private Label t11;
    @FXML
    private Label d11;
    @FXML
    private Label t21;
    @FXML
    private Label t31;
    @FXML
    private Label c11;
    @FXML
    private Label p11;
    @FXML
    private Label h11;
    @FXML
    private Label w11;
    @FXML
    private Label w21;
    @FXML
    private Label tt;
    @FXML
    private ImageView icon;
    @FXML
    private ImageView icon1;
    private Label city12;
    private Label country12;
    @FXML
    private AnchorPane anchor_pane2;
    @FXML
    private Label city2;
    @FXML
    private Label country2;
    @FXML
    private Label temp12;
    @FXML
    private Label t12;
    @FXML
    private Label d12;
    @FXML
    private Label t22;
    @FXML
    private Label t32;
    @FXML
    private Label c12;
    @FXML
    private Label p12;
    @FXML
    private Label h12;
    @FXML
    private Label w12;
    @FXML
    private Label w22;
    @FXML
    private ImageView icon2;
    @FXML
    private AnchorPane anchor_pane3;
    @FXML
    private Label city3;
    @FXML
    private Label country3;
    @FXML
    private Label temp13;
    @FXML
    private Label t13;
    @FXML
    private Label d13;
    @FXML
    private Label t23;
    @FXML
    private Label t33;
    @FXML
    private Label c13;
    @FXML
    private Label p13;
    @FXML
    private Label h13;
    @FXML
    private Label w13;
    @FXML
    private Label w23;
    @FXML
    private ImageView icon3;
    @FXML
    private AnchorPane anchor_pane4;
    @FXML
    private Label city4;
    @FXML
    private Label country4;
    @FXML
    private Label temp14;
    @FXML
    private Label t14;
    @FXML
    private Label d14;
    @FXML
    private Label t24;
    @FXML
    private Label t34;
    @FXML
    private Label c14;
    @FXML
    private Label p14;
    @FXML
    private Label h14;
    @FXML
    private Label w14;
    @FXML
    private Label w24;
    @FXML
    private ImageView icon4;
    @FXML
    private AnchorPane anchor_pane5;
    @FXML
    private Label city5;
    @FXML
    private Label country5;
    @FXML
    private Label temp15;
    @FXML
    private Label t15;
    @FXML
    private Label d15;
    @FXML
    private Label t25;
    @FXML
    private Label t35;
    @FXML
    private Label c15;
    @FXML
    private Label p15;
    @FXML
    private Label h15;
    @FXML
    private Label w15;
    @FXML
    private Label w25;
    @FXML
    private ImageView icon5;
    @FXML
    private AnchorPane anchor_pane6;
    @FXML
    private Label city6;
    @FXML
    private Label country6;
    @FXML
    private Label temp16;
    @FXML
    private Label t16;
    @FXML
    private Label d16;
    @FXML
    private Label t26;
    @FXML
    private Label t36;
    @FXML
    private Label c16;
    @FXML
    private Label p16;
    @FXML
    private Label h16;
    @FXML
    private Label w16;
    @FXML
    private Label w26;
    @FXML
    private ImageView icon6;
    @FXML
    private Button new_tab_button;
    @FXML
    private Button refresh_button;
    @FXML
    public Button reset_button;
    public int reset_count = 0;
    boolean hoise = false;

    public String List, countryY;
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
    public String s2, s3, s4, s5, s6, s7;
    public int paisi = 0;

    /**
     * Initializes the controller class.
     */
    
    /*To Set all type of Data of 7days of a City from JSON*/
    public void init() throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //nxtDate[i / 2] = ft.parse(test);  
        SimpleDateFormat dateFormatterhour = new SimpleDateFormat("hh:mm a");
        tt.setText(dateFormatterhour.format(new Date()));

        SimpleDateFormat dateFormatterday = new SimpleDateFormat("dd/MM/yyyy");
        String s1 = dateFormatterday.format(new Date());
        String s2, s3, s4, s5, s6, s7;
        t1.setText(dateFormatterday.format(new Date()));
        city.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp1.setText(String.valueOf(Scene1Controller.getInstance().tempP[0]) + "°C");
        t2.setText(String.valueOf(Scene1Controller.getInstance().temp_max[0]) + "°C");
        t3.setText(String.valueOf(Scene1Controller.getInstance().temp_min[0]) + "°C");
        d1.setText(String.valueOf(Scene1Controller.getInstance().des1[0]));
        c1.setText(String.valueOf(Scene1Controller.getInstance().clouds[0]) + "%");
        h1.setText(String.valueOf(Scene1Controller.getInstance().hum[0]) + "%");
        p1.setText(String.valueOf(Scene1Controller.getInstance().press[0]) + "hPa");
        w2.setText(String.valueOf(Scene1Controller.getInstance().WD[0]));
        w1.setText(String.valueOf(Scene1Controller.getInstance().WS[0]) + "m/s");
        icon.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[0]+ ".png"));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        String st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 1 );
        t11.setText(dateFormatterday.format(cal.getTime()));
		
        city1.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country1.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp11.setText(String.valueOf(Scene1Controller.getInstance().tempP[1]) + "°C");
        t21.setText(String.valueOf(Scene1Controller.getInstance().temp_max[1]) + "°C");
        t31.setText(String.valueOf(Scene1Controller.getInstance().temp_min[1]) + "°C");
        d11.setText(String.valueOf(Scene1Controller.getInstance().des1[1]));
        c11.setText(String.valueOf(Scene1Controller.getInstance().clouds[1]) + "%");
        h11.setText(String.valueOf(Scene1Controller.getInstance().hum[1]) + "%");
        p11.setText(String.valueOf(Scene1Controller.getInstance().press[1]) + "hPa");
        w21.setText(String.valueOf(Scene1Controller.getInstance().WD[1]));
        w11.setText(String.valueOf(Scene1Controller.getInstance().WS[1]) + "m/s");
        icon1.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[1]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 2 );
        t12.setText(dateFormatterday.format(cal.getTime()));
        city2.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country2.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp12.setText(String.valueOf(Scene1Controller.getInstance().tempP[2]) + "°C");
        t22.setText(String.valueOf(Scene1Controller.getInstance().temp_max[2]) + "°C");
        t32.setText(String.valueOf(Scene1Controller.getInstance().temp_min[2]) + "°C");
        d12.setText(String.valueOf(Scene1Controller.getInstance().des1[2]));
        c12.setText(String.valueOf(Scene1Controller.getInstance().clouds[2]) + "%");
        h12.setText(String.valueOf(Scene1Controller.getInstance().hum[2]) + "%");
        p12.setText(String.valueOf(Scene1Controller.getInstance().press[2]) + "hPa");
        w22.setText(String.valueOf(Scene1Controller.getInstance().WD[2]));
        w12.setText(String.valueOf(Scene1Controller.getInstance().WS[2]) + "m/s");
        icon2.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[2]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 3 );
        t13.setText(dateFormatterday.format(cal.getTime()));
        city3.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country3.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp13.setText(String.valueOf(Scene1Controller.getInstance().tempP[3]) + "°C");
        t23.setText(String.valueOf(Scene1Controller.getInstance().temp_max[3]) + "°C");
        t33.setText(String.valueOf(Scene1Controller.getInstance().temp_min[3]) + "°C");
        d13.setText(String.valueOf(Scene1Controller.getInstance().des1[3]));
        c13.setText(String.valueOf(Scene1Controller.getInstance().clouds[3]) + "%");
        h13.setText(String.valueOf(Scene1Controller.getInstance().hum[3]) + "%");
        p13.setText(String.valueOf(Scene1Controller.getInstance().press[3]) + "hPa");
        w23.setText(String.valueOf(Scene1Controller.getInstance().WD[3]));
        w13.setText(String.valueOf(Scene1Controller.getInstance().WS[3]) + "m/s");
        icon3.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[3]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 4 );
        t14.setText(dateFormatterday.format(cal.getTime()));
        city4.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country4.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp14.setText(String.valueOf(Scene1Controller.getInstance().tempP[4]) + "°C");
        t24.setText(String.valueOf(Scene1Controller.getInstance().temp_max[4]) + "°C");
        t34.setText(String.valueOf(Scene1Controller.getInstance().temp_min[4]) + "°C");
        d14.setText(String.valueOf(Scene1Controller.getInstance().des1[4]));
        c14.setText(String.valueOf(Scene1Controller.getInstance().clouds[4]) + "%");
        h14.setText(String.valueOf(Scene1Controller.getInstance().hum[4]) + "%");
        p14.setText(String.valueOf(Scene1Controller.getInstance().press[4]) + "hPa");
        w24.setText(String.valueOf(Scene1Controller.getInstance().WD[4]));
        w14.setText(String.valueOf(Scene1Controller.getInstance().WS[4]) + "m/s");
        icon4.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[4]+ ".png"));
       
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 5 );
        t15.setText(dateFormatterday.format(cal.getTime()));
        city5.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country5.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp15.setText(String.valueOf(Scene1Controller.getInstance().tempP[5]) + "°C");
        t25.setText(String.valueOf(Scene1Controller.getInstance().temp_max[5]) + "°C");
        t35.setText(String.valueOf(Scene1Controller.getInstance().temp_min[5]) + "°C");
        d15.setText(String.valueOf(Scene1Controller.getInstance().des1[5]));
        c15.setText(String.valueOf(Scene1Controller.getInstance().clouds[5]) + "%");
        h15.setText(String.valueOf(Scene1Controller.getInstance().hum[5]) + "%");
        p15.setText(String.valueOf(Scene1Controller.getInstance().press[5]) + "hPa");
        w25.setText(String.valueOf(Scene1Controller.getInstance().WD[5]));
        w15.setText(String.valueOf(Scene1Controller.getInstance().WS[5]) + "m/s");
        icon5.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[5]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 6 );
        t16.setText(dateFormatterday.format(cal.getTime()));
        city6.setText(String.valueOf(Scene1Controller.getInstance().cityY));
        country6.setText(String.valueOf(Scene1Controller.getInstance().countryY));
        temp16.setText(String.valueOf(Scene1Controller.getInstance().tempP[6]) + "°C");
        t26.setText(String.valueOf(Scene1Controller.getInstance().temp_max[6]) + "°C");
        t36.setText(String.valueOf(Scene1Controller.getInstance().temp_min[6]) + "°C");
        d16.setText(String.valueOf(Scene1Controller.getInstance().des1[6]));
        c16.setText(String.valueOf(Scene1Controller.getInstance().clouds[6]) + "%");
        h16.setText(String.valueOf(Scene1Controller.getInstance().hum[6]) + "%");
        p16.setText(String.valueOf(Scene1Controller.getInstance().press[6]) + "hPa");
        w26.setText(String.valueOf(Scene1Controller.getInstance().WD[6]));
        w16.setText(String.valueOf(Scene1Controller.getInstance().WS[6]) + "m/s");
        icon6.setImage(new Image("http://openweathermap.org/img/w/" + Scene1Controller.getInstance().weather_icon[6]+ ".png"));
    }
    
    /*To Set all type of Data of 7days of a City from JSON after refresh_button_clicked*/
    public void init2() throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //nxtDate[i / 2] = ft.parse(test);  
        SimpleDateFormat dateFormatterhour = new SimpleDateFormat("hh:mm a");
        tt.setText(dateFormatterhour.format(new Date()));

        SimpleDateFormat dateFormatterday = new SimpleDateFormat("dd/MM/yyyy");
        String s1 = dateFormatterday.format(new Date());
        String s2, s3, s4, s5, s6, s7;
        
        t1.setText(dateFormatterday.format(new Date().after(current_date)));
        city.setText(String.valueOf(cityY));
        country.setText(String.valueOf(countryY));
        temp1.setText(String.valueOf(tempP[0]) + "°C");
        t2.setText(String.valueOf(temp_max[0]) + "°C");
        t3.setText(String.valueOf(temp_min[0]) + "°C");
        d1.setText(String.valueOf(des1[0]));
        c1.setText(String.valueOf(clouds[0]) + "%");
        h1.setText(String.valueOf(hum[0]) + "%");
        p1.setText(String.valueOf(press[0]) + "hPa");
        w2.setText(String.valueOf(WD[0]));
        w1.setText(String.valueOf(WS[0]) + "m/s");
        icon.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[0]+ ".png"));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        String st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 1);
        t11.setText(dateFormatterday.format(cal.getTime()));
        city1.setText(String.valueOf(cityY));
        country1.setText(String.valueOf(countryY));
        temp11.setText(String.valueOf(tempP[1]) + "°C");
        t21.setText(String.valueOf(temp_max[1]) + "°C");
        t31.setText(String.valueOf(temp_min[1]) + "°C");
        d11.setText(String.valueOf(des1[1]));
        c11.setText(String.valueOf(clouds[1]) + "%");
        h11.setText(String.valueOf(hum[1]) + "%");
        p11.setText(String.valueOf(press[1]) + "hPa");
        w21.setText(String.valueOf(WD[1]));
        w11.setText(String.valueOf(WS[1]) + "m/s");
        icon1.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[1]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 2 );
        t12.setText(dateFormatterday.format(cal.getTime()));
        city2.setText(String.valueOf(cityY));
        country2.setText(String.valueOf(countryY));
        temp12.setText(String.valueOf(tempP[2]) + "°C");
        t22.setText(String.valueOf(temp_max[2]) + "°C");
        t32.setText(String.valueOf(temp_min[2]) + "°C");
        d12.setText(String.valueOf(des1[2]));
        c12.setText(String.valueOf(clouds[2]) + "%");
        h12.setText(String.valueOf(hum[2]) + "%");
        p12.setText(String.valueOf(press[2]) + "hPa");
        w22.setText(String.valueOf(WD[2]));
        w12.setText(String.valueOf(WS[2]) + "m/s");
        icon2.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[2]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 3 );
        t13.setText(dateFormatterday.format(cal.getTime()));
        city3.setText(String.valueOf(cityY));
        country3.setText(String.valueOf(countryY));
        temp13.setText(String.valueOf(tempP[3]) + "°C");
        t23.setText(String.valueOf(temp_max[3]) + "°C");
        t33.setText(String.valueOf(temp_min[3]) + "°C");
        d13.setText(String.valueOf(des1[3]));
        c13.setText(String.valueOf(clouds[3]) + "%");
        h13.setText(String.valueOf(hum[3]) + "%");
        p13.setText(String.valueOf(press[3]) + "hPa");
        w23.setText(String.valueOf(WD[3]));
        w13.setText(String.valueOf(WS[3]) + "m/s");
        icon3.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[3]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 4 );
        t14.setText(dateFormatterday.format(cal.getTime()));
        city4.setText(String.valueOf(cityY));
        country4.setText(String.valueOf(countryY));
        temp14.setText(String.valueOf(tempP[4]) + "°C");
        t24.setText(String.valueOf(temp_max[4]) + "°C");
        t34.setText(String.valueOf(temp_min[4]) + "°C");
        d14.setText(String.valueOf(des1[4]));
        c14.setText(String.valueOf(clouds[4]) + "%");
        h14.setText(String.valueOf(hum[4]) + "%");
        p14.setText(String.valueOf(press[4]) + "hPa");
        w24.setText(String.valueOf(WD[4]));
        w14.setText(String.valueOf(WS[4]) + "m/s");
        icon4.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[4]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 5 );
        t15.setText(dateFormatterday.format(cal.getTime()));
        city5.setText(String.valueOf(cityY));
        country5.setText(String.valueOf(countryY));
        temp15.setText(String.valueOf(tempP[5]) + "°C");
        t25.setText(String.valueOf(temp_max[5]) + "°C");
        t35.setText(String.valueOf(temp_min[5]) + "°C");
        d15.setText(String.valueOf(des1[5]));
        c15.setText(String.valueOf(clouds[5]) + "%");
        h15.setText(String.valueOf(hum[5]) + "%");
        p15.setText(String.valueOf(press[5]) + "hPa");
        w25.setText(String.valueOf(WD[5]));
        w15.setText(String.valueOf(WS[5]) + "m/s");
        icon5.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[5]+ ".png"));
        
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        st = ft.format(cal.getTime());
        cal.setTime( dateFormat.parse(st) );
        cal.add( Calendar.DATE, 6 );
        t16.setText(dateFormatterday.format(cal.getTime()));
        city6.setText(String.valueOf(cityY));
        country6.setText(String.valueOf(countryY));
        temp16.setText(String.valueOf(tempP[6]) + "°C");
        t26.setText(String.valueOf(temp_max[6]) + "°C");
        t36.setText(String.valueOf(temp_min[6]) + "°C");
        d16.setText(String.valueOf(des1[6]));
        c16.setText(String.valueOf(clouds[6]) + "%");
        h16.setText(String.valueOf(hum[6]) + "%");
        p16.setText(String.valueOf(press[6]) + "hPa");
        w26.setText(String.valueOf(WD[6]));
        w16.setText(String.valueOf(WS[6]) + "m/s");
        icon6.setImage(new Image("http://openweathermap.org/img/w/" + weather_icon[6]+ ".png"));
    }

    /*To Get the Direction of Wind*/
    public String dir(int i) {
        String ss = new String();
        double d = WD1[i];
        if (WD1[i] >= 348.75 && WD1[i] < 11.25) {
            ss += Double.toString(d);
            ss += "° N";
        } else if (WD1[i] >= 11.25 && WD1[i] < 33.75) {
            ss += Double.toString(d);
            ss += "° NNE";
        } else if (WD1[i] >= 33.75 && WD1[i] < 56.25) {
            ss += Double.toString(d);
            ss += "° NE";
        } else if (WD1[i] >= 56.25 && WD1[i] < 78.75) {
            ss += Double.toString(d);
            ss += "° ENE";
        } else if (WD1[i] >= 78.75 && WD1[i] < 101.25) {
            ss += Double.toString(d);
            ss += "° E";
        } else if (WD1[i] >= 101.25 && WD1[i] < 123.75) {
            ss += Double.toString(d);
            ss += "° ESE";
        } else if (WD1[i] >= 123.75 && WD1[i] < 146.25) {
            ss += Double.toString(d);
            ss += "° SE";
        } else if (WD1[i] >= 146.25 && WD1[i] < 168.75) {
            ss += Double.toString(d);
            ss += "° SSE";
        } else if (WD1[i] >= 168.75 && WD1[i] < 191.25) {
            ss += Double.toString(d);
            ss += "° S";
        } else if (WD1[i] >= 191.25 && WD1[i] < 213.75) {
            ss += Double.toString(d);
            ss += "° SSW";
        } else if (WD1[i] >= 213.75 && WD1[i] < 236.25) {
            ss += Double.toString(d);
            ss += "° SW";
        } else if (WD1[i] >= 236.25 && WD1[i] < 258.75) {
            ss += Double.toString(d);
            ss += "° WSW";
        } else if (WD1[i] >= 258.75 && WD1[i] < 281.25) {
            ss += Double.toString(d);
            ss += "° W";
        } else if (WD1[i] >= 281.25 && WD1[i] < 303.75) {
            ss += Double.toString(d);
            ss += "° WNW";
        } else if (WD1[i] >= 303.75 && WD1[i] < 326.25) {
            ss += Double.toString(d);
            ss += "° NW";
        } else if (WD1[i] >= 326.25 && WD1[i] < 348.75) {
            ss += Double.toString(d);
            ss += "° NNW";
        }
        return ss;
    }
    
    /*Call the OpenWeatherMap API
        Get the Json Data Of Corresponding City
        Search by City_ID
    */
    public void parser2() throws IOException, ParseException {
        String default1 = "http://api.openweathermap.org/data/2.5/forecast/daily?id=";
        String default2 = "&units=metric&cnt=7&APPID=a19e9f99d3ad3e8fe4a0c84367193dda";
        int cityID;
        String s21 = Scene1Controller.getInstance().cityY.toLowerCase();
        cityID = weather.app.WeatherApp.myMap.get(s21);
        System.out.println("  paisi   -> " + cityID);
        List = "";
        hoise = false;
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("NO INTERNET CONNECTION");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

        current_date = new Date();
        JSONObject tt = new JSONObject(List);

        try {
            JSONObject pp = tt.getJSONObject("city");
            s2 = pp.getString("name");
            countryY = pp.getString("country");
            JSONArray ar = tt.getJSONArray("list");
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
            WD[0] = dir(0);
            int ii;
            for (ii = 1; ii <= 6; ii++) {
                pp = tt.getJSONObject("city");
                s2 = pp.getString("name");
                countryY = pp.getString("country");
                ar = tt.getJSONArray("list");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (paisi == 0) {
            try {
                init();
            } catch (ParseException ex) {
                Logger.getLogger(Scene2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*To Create Multiple_Tab*/
    @FXML
    private void new_tab_button_clicked(ActionEvent event) throws IOException {
        //Platform.runLater(() -> location_name.requestFocus());
        Tab temp = new Tab("New City");
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/FXML/CustomScene1.fxml"));

        Scene scene4 = new Scene(root2);
        temp.setContent(root2);
        //temp.getContent().
        mytab.getTabs().add(temp);
        mytab.setTabMinWidth(50);
//        mytab.getSelectionModel().selectLast();
    }

    /*To Reset the Name of The Default City*/
    @FXML
    private void reset_button_clicked(ActionEvent event) throws IOException {
        reset_count++;
        weather.app.WeatherApp.getInstance().m21++;
        System.out.println("   -> " + weather.app.WeatherApp.getInstance().m21);
        Parent root2 = FXMLLoader.load(getClass().getResource("/FXML/Scene1.fxml"));

        Scene scene2 = new Scene(root2);
        Scene2Controller.getInstance().mytab.getSelectionModel().getSelectedItem().setContent(root2);
    }
    
    /*To Recall The Open_Weather_Map API to get Real Data in Time*/
    @FXML
    private void refresh_button_clicked(ActionEvent event) throws IOException, ParseException {
        reset_count++;
        weather.app.WeatherApp.getInstance().m21++;
        paisi++;
        parser2();
        if (hoise == true) {
            hoise = false;
        } else if (paisi >= 1) {
            init();
        }
    }

    private static Scene2Controller instance;

    public Scene2Controller() {
        instance = this;
    }
// static method to get instance of view

    public static Scene2Controller getInstance() {
        return instance;
    }

}
