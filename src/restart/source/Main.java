package restart.source;

import java.util.Arrays;

public class Main {
    private static int[] a = randomarray();
    private static int x = randomnumber();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Mergesort mergesort = new Mergesort();

        System.out.println(Arrays.toString(a) + "\n");                      // Print arrays for clarity
        mergesort.divide(a);                                                // Divide and conquer
        a = mergesort.cleanup(a);                                           // Remove 0s that were set by merge
        Binarysearch binarysearch = new Binarysearch(x, a);
        int b = binarysearch.search(0,a.length);                                    // Binary search the array
        System.out.println("Mergesort: " + Arrays.toString(a) + "\n");                      // Final value of array a
        if (b != -1) {
            System.out.println("Binarysearch: " + x + " was found in the list at position " + (b+1) + ".\n");
        } else {
            System.out.println("Binarysearch: " + x + " was not found in the list.\n");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime + " milliseconds.");
    }

    static int[] randomarray() {
        int[] a = new int[randomnumber()];                // Set up array size by the random value

        for (int i = 0; i < a.length; ++i) {                                // Give the first array random values
            a[i] = randomnumber();
        }
        return a;
    }

    static int randomnumber() {
        return (int) ((Math.random() * 10) + 1);
    }
}

