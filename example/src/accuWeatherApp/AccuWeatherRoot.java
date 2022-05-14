package accuWeatherApp;

public class AccuWeatherRoot {
    private Headline headline;

    public AccuWeatherRoot(Headline headline) {
        this.headline = headline;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }
}
