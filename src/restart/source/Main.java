package restart.source;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Mergesort mergesort = new Mergesort();
        int[] a = randomarray();

        System.out.println(Arrays.toString(a) + "\n");                      // Print arrays for clarity
        mergesort.divide(a);
        a = mergesort.cleanup(a);                                           // Remove 0s that were set by merge
        System.out.println(Arrays.toString(a));                             // Final value of array a
    }

    static int[] randomarray() {
        int[] a = new int[(int) ((Math.random() * 10) + 1)];                // Set up array size by the random value

        for (int i = 0; i < a.length; ++i) {                                // Give the first array random values
            a[i] = (int) ((Math.random() * 10) + 1);
        }
        return a;
    }
}

