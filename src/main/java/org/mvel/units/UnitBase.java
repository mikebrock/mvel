package org.mvel.units;

import org.mvel.Unit;

public abstract class UnitBase implements Unit {
    protected double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
