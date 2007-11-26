package org.mvel.units;

import org.mvel.DataConversion;
import org.mvel.Unit;

public class Byte extends UnitBase {

    public Byte() {
    }

    public Byte(double value) {
        this.value = value;
    }

    public Object convertFrom(Object in) {
        if (in instanceof Number) {
            return new Byte(DataConversion.convert(in, Double.class));
        }
        return Units.convert(in.getClass(), Byte.class, ((Unit) in).getValue(), Units.MATRIX_COMPUTING_DATA);
    }

    public boolean canConvertFrom(Class cls) {
     //   return Number.class.isAssignableFrom(cls) || Units.MEASUREMENTS_COMPUTING_DATA.contains(cls);
        return false;
    }

    public String toString() {
        return String.valueOf(value) + "bytes";
    }
}
