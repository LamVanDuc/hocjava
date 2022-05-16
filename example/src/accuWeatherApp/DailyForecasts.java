package accuWeatherApp;

import java.util.List;

public class DailyForecasts {
    private String Date;
    private int EpochDate;
    private Temperature Temperature;
    private Day Day;
    private Night Night;
    private List<String> Sources;

    public DailyForecasts(String date, int epochDate, accuWeatherApp.Temperature temperature, accuWeatherApp.Day day, accuWeatherApp.Night night, List<String> sources) {
        Date = date;
        EpochDate = epochDate;
        Temperature = temperature;
        Day = day;
        Night = night;
        Sources = sources;
    }

    public List<String> getSources() {
        return Sources;
    }

    public void setSources(List<String> sources) {
        Sources = sources;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getEpochDate() {
        return EpochDate;
    }

    public void setEpochDate(int epochDate) {
        EpochDate = epochDate;
    }

    public accuWeatherApp.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(accuWeatherApp.Temperature temperature) {
        Temperature = temperature;
    }

    public accuWeatherApp.Day getDay() {
        return Day;
    }

    public void setDay(accuWeatherApp.Day day) {
        Day = day;
    }

    public accuWeatherApp.Night getNight() {
        return Night;
    }

    public void setNight(accuWeatherApp.Night night) {
        Night = night;
    }
}
