package weatherApp;

import com.google.gson.Gson;

import java.io.*;

import java.net.URL;

public class WeatherAPI {
    private  String keys;
    private String city;
    private String country;
    Gson gson = new Gson();

    public WeatherAPI(String keys, String city, String country) {
        this.keys = keys;
        this.city = city;
        this.country = country;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    // parser API from openweathermap
    public String getJsonAPI(String link) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        //http://api.openweathermap.org....
        URL url = new URL(link);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = bufferedReader.readLine()) !=null){
            stringBuilder.append(line);// đọc từng dòng trong URL rồi ghép lại gán cho stringBuilder.

        }
        return stringBuilder.toString();
    }
    public String getLink(){
        String link = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+keys;
        return link;
    }

    public WeatherRoot getWeatherData() throws IOException {
        WeatherRoot weatherRoot = gson.fromJson(getJsonAPI(getLink()),WeatherRoot.class);
        return weatherRoot;
    }

//    public static void main(String[] args) throws  IOException{
//        String keys = "4db55ee86ec11ec03e6658e1d2b50417";
//        String city = "hanoi";
//
//        WeatherAPI weatherAPI = new WeatherAPI(keys ,city,"vn" );
//
//        System.out.printf("coord :{\n\tlat :%f ,\n\tlon: %f}" +
//                        "\nweather :[{\n\tid: %d , \n\tmain : %s ,\n\tdescription : %s ,\n\ticon : %s\n\t]} \n" +
//                        "base : %s\n" +
//                        "main :{\n\ttemp : %f,\n\tfeels_like : %f ,\n\ttemp_min : %f ,\n\ttemp_max : %f ,\n\tpressure : %d ,\n\thumidity : %d ,\n\tsea_level : %d ,\n\tgrnd_level: %d\n\t}" +
//                        "\nvisibility : %d " +
//                        "\nwind :{\n\tspeed : %f ,\n\tdeg : %d ,\n\tgust : %f\n\t}" +
//                        "\nclouds :{\n\tall : %d\n\t}" +
//                        "\ndt : %d" +
//                        "\nsys:{\n\ttype : %d ,\n\tid : %d ,\n\tcountry : %s ,\n\tsunrise : %d ,\n\tsunset : %d\n\t}" +
//                        "\ntimezone : %d" +
//                        "\nid : %d" +
//                        "\nname: %s" +
//                        "\ncod: %d" +
//                        "\nrain :{\n 1h : %f\n\t}"
//
//                ,weatherAPI.getWeatherData().getCoord().getLat()
//                ,weatherAPI.getWeatherData().getCoord().getLon()
//                ,weatherAPI.getWeatherData().getWeather().get(0).getId()
//                ,weatherAPI.getWeatherData().getWeather().get(0).getMain()
//                ,weatherAPI.getWeatherData().getWeather().get(0).getDescription()
//                ,weatherAPI.getWeatherData().getWeather().get(0).getIcon()
//                ,weatherAPI.getWeatherData().getBase()
//                ,weatherAPI.getWeatherData().getMain().getTemp()
//                ,weatherAPI.getWeatherData().getMain().getFeels_like()
//                ,weatherAPI.getWeatherData().getMain().getTemp_min()
//                ,weatherAPI.getWeatherData().getMain().getTemp_max()
//                ,weatherAPI.getWeatherData().getMain().getPressure()
//                ,weatherAPI.getWeatherData().getMain().getHumidity()
//                ,weatherAPI.getWeatherData().getMain().getSea_level()
//                ,weatherAPI.getWeatherData().getMain().getGrnd_level()
//                ,weatherAPI.getWeatherData().getVisibility()
//                ,weatherAPI.getWeatherData().getWind().getSpeed()
//                ,weatherAPI.getWeatherData().getWind().getDeg()
//                ,weatherAPI.getWeatherData().getWind().getGust()
//                ,weatherAPI.getWeatherData().getClouds().getAll()
//                ,weatherAPI.getWeatherData().getDt()
//                ,weatherAPI.getWeatherData().getSys().getType()
//                ,weatherAPI.getWeatherData().getSys().getId()
//                ,weatherAPI.getWeatherData().getSys().getCountry()
//                ,weatherAPI.getWeatherData().getSys().getSunrise()
//                ,weatherAPI.getWeatherData().getSys().getSunset()
//                ,weatherAPI.getWeatherData().getTimezone()
//                ,weatherAPI.getWeatherData().getId()
//                ,weatherAPI.getWeatherData().getName()
//                ,weatherAPI.getWeatherData().getCod()
//                ,weatherAPI.getWeatherData().getRain().getH1());
//
//    }

}
