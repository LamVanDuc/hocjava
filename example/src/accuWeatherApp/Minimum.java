package accuWeatherApp;

public class Minimum {
    private float Value;
    private char Unit;
    private int UnitType;

    public Minimum(float value, char unit, int unitType) {
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

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        UnitType = unitType;
    }
}
