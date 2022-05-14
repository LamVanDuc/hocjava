package accuWeatherApp;

import com.google.gson.Gson;
import java.lang.StringBuilder;
import java.io.*;
import java.net.URL;


public class AccuWeatherAPI {
    private String key;
    private String name;
    Gson gson = new Gson();


    public AccuWeatherAPI(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






    public StringBuilder getJsonAPI(String link) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(link);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = bufferedReader.readLine())!= null){
            stringBuilder.append(line);
        }
        return stringBuilder;

    }

    public AccuWeatherRoot getAccuWeatherData()throws IOException{
       AccuWeatherRoot accuWeather = gson.fromJson(String.valueOf(getJsonAPI(getLink())), AccuWeatherRoot.class);
        return accuWeather;
    }

    public String getLink(){
       // String link = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="+getKey()+"&q="+getName()+"&details=false";
        String link = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&q=h%C3%A0%20n%E1%BB%99i&language=vi-vn&metric=true";
        return link;
    }

    public static void main(String[] args)throws IOException {
        String name = "Hanoi";
        String key ="qy2aSb6zMWhu9qSIFkIKA8Wozcd40c87";
        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI(key , name);
        System.out.println(accuWeatherAPI.getJsonAPI(accuWeatherAPI.getLink()));
        System.out.println(accuWeatherAPI.getAccuWeatherData().getHeadline().getText());

    }
}
