package accuWeatherApp;

public class Temperature {
    private Minimum Minimum;
    private Maximum Maximum;

    public Temperature(accuWeatherApp.Minimum minimum, accuWeatherApp.Maximum maximum) {
        Minimum = minimum;
        Maximum = maximum;
    }

    public accuWeatherApp.Minimum getMinimum() {
        return Minimum;
    }

    public void setMinimum(accuWeatherApp.Minimum minimum) {
        Minimum = minimum;
    }

    public accuWeatherApp.Maximum getMaximum() {
        return Maximum;
    }

    public void setMaximum(accuWeatherApp.Maximum maximum) {
        Maximum = maximum;
    }
}
