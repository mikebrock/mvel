package org.mvel.units;

import org.mvel.DataConversion;
import org.mvel.Unit;


public class Inch extends UnitBase {
    public Inch() {
    }

    public Inch(double value) {
        this.value = value;
    }

    public Object convertFrom(Object in) {
        if (in instanceof Number) {
            return new Inch(DataConversion.convert(in, Double.class));
        }
        return Units.convert(in.getClass(), Inch.class, ((Unit) in).getValue(), Units.MATRIX_LENGTH);
    }

    public boolean canConvertFrom(Class cls) {
  //      return Number.class.isAssignableFrom(cls) || Units.MEASUREMENTS_LENGTH.contains(cls);
        return false;
    }

}
