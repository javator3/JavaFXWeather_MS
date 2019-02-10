package pl.sda.javafxweather.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import pl.sda.javafxweather.model.WeatherService;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    //@FXML - do powiazania buttonu ze zmienna w javie
    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private TextField realtemperature;

    @FXML
    private TextField sensedtemperature;

    @FXML
    private Hyperlink hyperlink;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            city.setText("e.g. New_York");
            search.setText("Find");
    }

    public void setCity(ActionEvent actionEvent) {
        String scity = city.getText();
        System.out.println(scity);

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json","e73bd5fd85ca4d8881d90312191002");
        try {
            weatherService.getCityWeather(scity);
            float t = weatherService.getCityWeather(scity).getCurrent().getTemp_c();
            float s = weatherService.getCityWeather(scity).getCurrent().getFeelslike_c();
            String realtemp = String.valueOf(t);
            String sensedtemp = String.valueOf(s);
            realtemperature.setText(realtemp);
            sensedtemperature.setText(sensedtemp);
        } catch (Exception e) {
            city.setText("no data in the apixu database");
            realtemperature.setText("");
            sensedtemperature.setText("");
            //e.printStackTrace();
        }


    }

    public void runWebBrowser(ActionEvent actionEvent) {

        String s = "https://www.apixu.com/";
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(URI.create(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
