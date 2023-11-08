package Utility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import Prodotti.*;
import org.apache.commons.lang3.Range;

public class RangeUtils {
    public static double[] DoubleRange(){
        double[] range = new double[2];
        for(int i = 0; i < range.length; i++){
            range[i] = Input.readInt();
        }
        Arrays.sort(range);
        return range;
    }

    public static BigDecimal[] DoubleRangeBD(){
        BigDecimal[] range = new BigDecimal[2];
        for(int i = 0; i < range.length; i++){
            range[i] = Input.readBigD();
        }
        Arrays.sort(range);
        return range;
    }
    public static boolean isInRange(BigDecimal value, BigDecimal min, BigDecimal max) {
        Range<BigDecimal> range = Range.between(min, max);
        return range.contains(value);
    }
}
