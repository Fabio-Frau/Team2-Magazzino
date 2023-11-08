package Utility;

import java.math.BigDecimal;
import java.util.Arrays;

public class Range {
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
}
