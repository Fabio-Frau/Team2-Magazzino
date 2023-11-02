package Utility;

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
}
