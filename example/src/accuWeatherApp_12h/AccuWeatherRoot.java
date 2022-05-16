package accuWeatherApp_12h;

public class AccuWeatherRoot {
    private String DateTime;
    private int EpochDateTime;
    private long WeatherIcon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;
    private boolean IsDaylight;
    private Temperature Temperature;
    private long PrecipitationProbability;

    public AccuWeatherRoot(String dateTime, int epochDateTime, long weatherIcon, String iconPhrase, boolean hasPrecipitation, String precipitationType, String precipitationIntensity, boolean isDaylight, Temperature temperature, long precipitationProbability) {
        DateTime = dateTime;
        EpochDateTime = epochDateTime;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
        PrecipitationType = precipitationType;
        PrecipitationIntensity = precipitationIntensity;
        IsDaylight = isDaylight;
        Temperature = temperature;
        PrecipitationProbability = precipitationProbability;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getEpochDateTime() {
        return EpochDateTime;
    }

    public void setEpochDateTime(int epochDateTime) {
        EpochDateTime = epochDateTime;
    }

    public long getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(long weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
    }

    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    public void setPrecipitationIntensity(String precipitationIntensity) {
        PrecipitationIntensity = precipitationIntensity;
    }

    public boolean isDaylight() {
        return IsDaylight;
    }

    public void setDaylight(boolean daylight) {
        IsDaylight = daylight;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        Temperature = temperature;
    }

    public long getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(long precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
    }

    @Override
    public String toString(){
        return "\n---------------------- Date time : "+getDateTime()+"------------------------------------"+
                "\nEpochDateTime : "+getEpochDateTime()+
                "\nIconPherase : "+getIconPhrase()+
                "\nPrecipitationIntensity : " + getPrecipitationIntensity()+
                "\nPrecipitationType : "+getPrecipitationType()+
                "\nPrecipitationProbability : "+getPrecipitationProbability()+
                "\nWeatherIcon : "+getWeatherIcon()+
                "\n"+getTemperature().toString()+
                "\nHasPrecipitation : "+isHasPrecipitation()+
                "\nIsDayLight : "+isDaylight();
    }
}
