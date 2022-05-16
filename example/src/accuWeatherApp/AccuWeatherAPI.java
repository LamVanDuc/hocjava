package accuWeatherApp;

import com.google.gson.Gson;
import java.lang.StringBuilder;
import java.io.*;
import java.net.URL;


public class AccuWeatherAPI {
    private String key;
    private String cytiName;
    Gson gson = new Gson();


    public AccuWeatherAPI(String key, String name) {
        this.key = key;
        this.cytiName = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCytiName() {
        return cytiName;
    }

    public void setCytiName(String cytiName) {
        this.cytiName = cytiName;
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
        String link = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/353412?apikey="+getKey()+"&q="+ getCytiName()+"&language=vi-vn&metric=true";
        return link;
    }

    public static void main(String[] args)throws IOException {
        String cityName = "Hanoi";
        String key ="mYVFIGE0wNVGG2CllOFAZVJFtFD3oCTm";
        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI(key , cityName);
        System.out.println(accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getDate()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getDay().getIcon()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getDay().getIconPhrase()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getDay().getPrecipitationIntensity()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getDay().getPrecipitationType()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getNight().getIconPhrase()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getNight().getIcon()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getNight().getPrecipitationIntensity()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getNight().getPrecipitationType()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getEpochDate()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getTemperature().getMaximum().getUnit()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getTemperature().getMaximum().getUnitType()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getTemperature().getMaximum().getValue()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getTemperature().getMinimum().getUnit()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getTemperature().getMinimum().getValue()+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getSources().get(0)+"\n"+
                accuWeatherAPI.getAccuWeatherData().getDailyForecasts().get(0).getTemperature().getMinimum().getUnitType());
    }
}
