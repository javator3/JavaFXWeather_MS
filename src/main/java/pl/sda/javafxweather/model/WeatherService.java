package pl.sda.javafxweather.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherService {
    private String url;
    private String apiKey;

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Weather getCityWeather(String city){


        String finalUrl= this.url+"?key="+this.apiKey+"&q=" + city;


        Weather weather = null;
        try {
            URL jsonURL = new URL(finalUrl);
            ObjectMapper objectMapper = new ObjectMapper();
            weather = objectMapper.readValue(jsonURL,Weather.class);
            System.out.println(" Temperature in: " + city + " = " + weather.getCurrent().getTemp_c() + "C");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(" There is no " + city + " in our database (www.apixu.com) ");

        }
      return weather;
    }



}
