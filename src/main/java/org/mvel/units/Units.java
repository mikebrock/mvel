package org.mvel.units;

import org.mvel.DataConversion;
import org.mvel.Unit;
import org.mvel.conversion.UnitConversion;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Units {
    public static final Map<String, Class> MEASUREMENTS_ALL;

    public static final Map<Integer, UnitSet> MEASUREMENT_SETS;
    public static final Map<Class, Integer> UNIT_MEMBERSHIP;

    // base byte
    public static final double[][] MATRIX_COMPUTING_DATA = new double[][]{
            {1, 8}
    };

    //base cm
    public static final double[][] MATRIX_LENGTH = new double[][]{
            {1, 0.393700787, 0.01}
    };


    /**
     * Accepts an array of values, with the value at index 0 being used as a baseline
     * to calculate ratios along the x-axis to calculate the ratios along the y-axis
     * of the conversion table.
     *
     * @param baseline
     * @return fully calculated conversino table
     */
    public static double[][] calculateConversionMatrix(double[] baseline) {
        double[][] matrix = new double[baseline.length][baseline.length];

        double baseMeasurement = baseline[0];

        for (int i = 0; i < baseline.length; i++) {
            matrix[i][0] = baseline[i];
        }

        for (int x = 0, y = 1; y < baseline.length; x++) {
            matrix[x][y] = baseline[x] / baseMeasurement;

            if ((x + 1) == baseline.length) {
                y++;
            }
        }

        return matrix;
    }

    static {
        MEASUREMENTS_ALL = new HashMap<String, Class>();
        MEASUREMENT_SETS = new HashMap<Integer, UnitSet>();
        UNIT_MEMBERSHIP = new HashMap<Class, Integer>();


        try {
            for (Class<? extends Unit> cls : MEASUREMENTS_ALL.values()) {
                DataConversion.addConversionHandler(cls, cls.newInstance());

            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



    public static void addMeasurement(int type, String alias, Class unitClass) {

    }



    public static int getTableIndexForClass(Class<? extends Unit> converter) {
        return -1;
    }

    public static double convert(Class from, Class to, double value, double[][] matrix) {
        return value * matrix[getTableIndexForClass(from)][getTableIndexForClass(to)];
    }

    public static class UnitSet {
        private int type;
        private Set<Class> types;
        private Map<Class, Integer> indexPositions;

        public UnitSet() {
        }

        public UnitSet(int type, Set<Class> types, Map<Class, Integer> indexPositions) {
            this.type = type;
            this.types = types;
            this.indexPositions = indexPositions;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Set<Class> getTypes() {
            return types;
        }

        public void setTypes(Set<Class> types) {
            this.types = types;
        }

        public Map<Class, Integer> getIndexPositions() {
            return indexPositions;
        }

        public void setIndexPositions(Map<Class, Integer> indexPositions) {
            this.indexPositions = indexPositions;
        }
    }


}
