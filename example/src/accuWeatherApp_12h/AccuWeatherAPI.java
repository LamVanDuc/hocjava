package accuWeatherApp_12h;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccuWeatherAPI {


    private String cityName;
    private String key;

    public AccuWeatherAPI( String key ,String cityName) {
        this.cityName = cityName;
        this.key = key;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLink(){
        String link = "http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/353412?apikey="+getKey()+"&q="+getCityName()+"&language=vi-vn&metric=true";
        return link;
    }

    public String getJsonData(String link) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        URL url = new URL(link);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = bufferedReader.readLine())!= null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public List<AccuWeatherRoot> getWeatherData() throws IOException{
        Gson gson  = new Gson();
        List<AccuWeatherRoot> accuWeatherRootList = gson.fromJson(getJsonData(getLink()), new TypeToken<List<AccuWeatherRoot>>(){}.getType());

        return accuWeatherRootList;
    }

    public void updateSQLServer(List<AccuWeatherRoot> accuWeatherRootList) throws SQLException, ClassNotFoundException {
        Connection connection = SQLConnection.getConnectSQLServer();
        int weatherRoot =0;
        int temperature =0;
        for (int i = 0 ; i< accuWeatherRootList.size() ; i++){
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO weatherRoot VALUES(?,?,?,?,?,?,?,?,?)" , Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,accuWeatherRootList.get(i).getDateTime());
        preparedStatement.setInt(2,accuWeatherRootList.get(i).getEpochDateTime());
        preparedStatement.setLong(3,accuWeatherRootList.get(i).getWeatherIcon());
        preparedStatement.setString(4,accuWeatherRootList.get(i).getIconPhrase());
        preparedStatement.setBoolean(5,accuWeatherRootList.get(i).isHasPrecipitation());
        preparedStatement.setString(6,accuWeatherRootList.get(i).getPrecipitationType());
        preparedStatement.setString(7,accuWeatherRootList.get(i).getPrecipitationIntensity());
        preparedStatement.setBoolean(8,accuWeatherRootList.get(i).isDaylight());
        preparedStatement.setLong(9,accuWeatherRootList.get(i).getPrecipitationProbability());
           int  count =preparedStatement.executeUpdate();
           if (count == 1){
               weatherRoot =1;
           }else{
               System.out.println("add weatherRoot false : "+i);
               break;
           }
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int key = rs.next() ? rs.getInt(1) : 0;

            if (key == 0){
                System.out.println("Generated key="+key);
            }else {
                PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO Temperature VALUES (?,?,?,?)");
                preparedStatement2.setFloat(1,accuWeatherRootList.get(i).getTemperature().getValue());
                preparedStatement2.setString(2, String.valueOf(accuWeatherRootList.get(i).getTemperature().getUnit()));
                preparedStatement2.setFloat(3,accuWeatherRootList.get(i).getTemperature().getUnitType());
                preparedStatement2.setInt(4, key);

                int check = preparedStatement2.executeUpdate();

                if (check == 1 ){
                    temperature =1;
                }else {
                    System.out.println("add Temperature false : "+i);
                    break;
                }
            }


        }


        if (weatherRoot ==1 && temperature ==1){
            System.out.println("Add Success ! ");
        }

    }

    public void getDataAccuWeatherInSQLServer()throws SQLException , ClassNotFoundException{
        Connection connection = SQLConnection.getConnectSQLServer();


        PreparedStatement preparedStatement = connection.prepareStatement("Select * From weatherRoot inner join Temperature on Temperature.IDRoot = weatherRoot.IDRoot");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String date = resultSet.getString(2);
            int epochDateTime = resultSet.getInt(3);
            int weatherIcon = resultSet.getInt(4);
            String iconPhrase = resultSet.getString(5);
            boolean hasPreciPitation = resultSet.getBoolean(6);
            String precipitationType = resultSet.getString(7);
            String precipitationIntensity = resultSet.getString(8);
            boolean isDaylight =resultSet.getBoolean(9);
            int precipitationProbability = resultSet.getInt(10);

            double value = resultSet.getDouble(12);
            String unit = resultSet.getString(13);
            int unitType = resultSet.getInt(14);

            System.out.println("\n---------------------- Date time : "+date+"------------------------------------"+
                    "\nEpochDateTime : "+epochDateTime+
                    "\nIconPherase : "+iconPhrase+
                    "\nPrecipitationIntensity : " + precipitationIntensity+
                    "\nPrecipitationType : "+precipitationType+
                    "\nPrecipitationProbability : "+precipitationProbability+
                    "\nWeatherIcon : "+weatherIcon+
                    "\nTemperature : "+
                    "\n\t Value : "+value+
                    "\n\t Unit : "+unit+
                    "\n\t UnitType : " +unitType+
                    "\nHasPrecipitation : "+hasPreciPitation+
                    "\nIsDayLight : "+isDaylight);
        }
    }

}
