package accuWeatherApp;

import java.util.List;

public class AccuWeatherRoot {
    private Headline Headline;
    private List<DailyForecasts> DailyForecasts;

    public AccuWeatherRoot(accuWeatherApp.Headline headline, List<accuWeatherApp.DailyForecasts> dailyForecasts) {
        Headline = headline;
        DailyForecasts = dailyForecasts;
    }

    public accuWeatherApp.Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(accuWeatherApp.Headline headline) {
        Headline = headline;
    }

    public List<accuWeatherApp.DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<accuWeatherApp.DailyForecasts> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
