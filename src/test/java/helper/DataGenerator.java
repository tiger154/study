package helper;

import java.util.Arrays;
import java.util.Random;

public class DataGenerator {


    public static int[] randomRangedInts(int min, int max) {
        int [] arr = new Random()
                    .ints(max * 10, min, max+1)
                    .distinct()
                    .limit(max)
                    .toArray();
        return arr;
    }
}
