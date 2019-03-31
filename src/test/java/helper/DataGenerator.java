package helper;

import java.util.Random;

public class DataGenerator {

    /**
     * Make sure it return max limit array
     * @param min
     * @param max
     * @return
     */
    public static int[] randomRangedInts(int min, int max) {
        int [] arr;
        do {
           arr = DataGenerator.randomRangedIntsNotGuaranteeLenth(min, max);
        } while (arr.length < max);
        return arr;
    }

    /**
     * Base random ranged number generator, but not guarantee to make max limit array
     * @param min
     * @param max
     * @return
     */
    private static int[] randomRangedIntsNotGuaranteeLenth(int min, int max) {
        return new Random()
                .ints(max * 10, min, max+1)
                .distinct()
                .limit(max)
                .toArray();
    }
}
