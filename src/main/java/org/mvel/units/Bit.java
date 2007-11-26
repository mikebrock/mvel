package org.mvel.units;

import org.mvel.Unit;
import org.mvel.DataConversion;

public class Bit extends UnitBase {
    public Bit() {
    }

    public Bit(double value) {
        this.value = value;
    }

    public Object convertFrom(Object in) {
        if (in instanceof Number) {
            return new Bit(DataConversion.convert(in, Double.class));
        }
        return Units.convert(in.getClass(), Bit.class, ((Unit) in).getValue(), Units.MATRIX_COMPUTING_DATA);
    }

    public boolean canConvertFrom(Class cls) {
    //    return Number.class.isAssignableFrom(cls) || Units.MEASUREMENTS_COMPUTING_DATA.contains(cls);
        return false;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
