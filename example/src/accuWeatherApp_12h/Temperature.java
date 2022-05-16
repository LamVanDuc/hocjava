package accuWeatherApp_12h;

import accuWeatherApp.Maximum;
import accuWeatherApp.Minimum;

public class Temperature {
    private float Value;
    private char Unit;
    private long UnitType;

    public Temperature(float value, char unit, long unitType) {
        Value = value;
        Unit = unit;
        UnitType = unitType;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }

    public char getUnit() {
        return Unit;
    }

    public void setUnit(char unit) {
        Unit = unit;
    }

    public long getUnitType() {
        return UnitType;
    }

    public void setUnitType(long unitType) {
        UnitType = unitType;
    }

    @Override
    public String toString(){
        return "Temperature : { "+getValue() + getUnit() + getUnitType() +" }" ;
    }
}
