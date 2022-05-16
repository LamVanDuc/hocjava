package accuWeatherApp_12h;

import accuWeatherApp.Day;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws IOException, ParseException, SQLException, ClassNotFoundException {
        String key = "Yrynt3uWVuidn1xY9ltR5ZAZwo0K1BqA";
        String cityName  = "Hà nội";
//        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI(key,cityName);
//
//        System.out.println("==================================================");
//        for (int i = 0; i <accuWeatherAPI.getWeatherData().size() ; i++){
//            System.out.println(accuWeatherAPI.getWeatherData().get(i).toString());
//
//        }



//        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI(key,cityName);
//        accuWeatherAPI.getDataAccuWeatherInSQLServer();

        System.out.println(Application.converTime("2022-05-14T16:00:00+07:00"));

    }

    public static String converTime(String inputTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null ;
        date = simpleDateFormat.parse(inputTime);
        SimpleDateFormat outFomat = new SimpleDateFormat("HH:mm:ss'T'yyyy-MM-dd");
        String goal = outFomat.format(date);
        return goal;
    }

}
