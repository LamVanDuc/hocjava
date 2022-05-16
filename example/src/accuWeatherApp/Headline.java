package accuWeatherApp;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Headline {
    private String EffectiveDate;
    private String EffectiveEpochDate;
    private int Severity;
    private String Text;
    private String Category;
    private String EndDate;
    private  int EndEpochDate;

    public Headline(String effectiveDate, String effectiveEpochDate, int severity, String text, String category, String endDate, int endEpochDate) {
        EffectiveDate = effectiveDate;
        EffectiveEpochDate = effectiveEpochDate;
        Severity = severity;
        Text = text;
        Category = category;
        EndDate = endDate;
        EndEpochDate = endEpochDate;
    }
}
