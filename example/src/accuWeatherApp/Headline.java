package accuWeatherApp;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Headline {
    private String effectiveDate;
    private String text;
    private Date endDate;


    public Headline(String effectiveDate, String text, Date endDate) {
        this.effectiveDate = effectiveDate;
        this.text = text;
        this.endDate = endDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
