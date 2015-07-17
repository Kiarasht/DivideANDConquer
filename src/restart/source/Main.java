package restart.source;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();                           // Start run time
        final int start = (int) ((Math.random() * 10) + 1);                 // Random array, 1 to 10
        final int start2 = (int) ((Math.random() * 10) + 1);                // Random array, 1 to 10

        int[] a = new int[start];                                           // Set up array by the random value
        int[] b = new int[start2];                                          // Create another one

        for (int i = 0; i < a.length; ++i) {                                // Give the first array random values
            a[i] = (int) ((Math.random() * 10) + 1);
        }
        for (int i = 0; i < b.length; ++i) {                                // Give the second array random values
            b[i] = (int) ((Math.random() * 10) + 1);
        }

        int[] c = new int[a.length + b.length];                             // Merge sorted array maximum size given

        System.out.println(Arrays.toString(a));                             // Print arrays for clarity
        System.out.println(Arrays.toString(b));
        System.out.println();
        mergesort(a);                                                       // Sort the first array
        mergesort(b);                                                       // Sort the second one
        merge(c, a, b);                                                     // Merge both arrays in c
        c = removeduplicate(c);                                             // Remove any duplicates
        System.out.println(Arrays.toString(c));                             // Final value of array c
        final long duration = System.nanoTime() - startTime;                // Final run time if calculated and printed
        System.out.println("Time: " + duration / 1000000 + " millisecond.");
    }

    private static int[] removeduplicate(int[] c) {                         // Removes duplicates from passed in arrays
        int[] temp = new int[c.length];
        int loop = 1;
        temp[0] = c[0];
        for (int i = 0; i < c.length; ++i) {
            if (temp[loop - 1] != c[i]) {
                temp[loop++] = c[i];
            }
        }
        int[] temp2 = new int[loop];
        System.arraycopy(temp, 0, temp2, 0, loop);
        return temp2;
    }

    static void mergesort(int[] a) {                                        // Divided a given array
        if (a.length > 1) {                                                 // Recursively calls itself till size of 1
            int[] u = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] v = Arrays.copyOfRange(a, a.length / 2, a.length);
            mergesort(u);
            mergesort(v);
            merge(a, u, v);                                                 // Starts ordering them
        }
    }

    static void merge(int[] a, int[] u, int[] v) {
        int i, j, k;
        i = j = k = 0;
        while (i < u.length + v.length) {                                   // If a array has space
            if (j < u.length && k < v.length) {                             // And both array have elements left
                if (u[j] < v[k]) {                                          // First array has the smaller element
                    a[i++] = u[j++];
                } else {                                                    // Second array has the smaller element
                    a[i++] = v[k++];
                }
            } else {                                                        // One of the arrays is exhausted
                if (j >= u.length) {                                        // Array u is exhausted
                    while (k < v.length) {                                  // Copy remaining v elements
                        a[i++] = v[k++];
                    }
                }
                if (k >= v.length) {                                        // Array v is exhausted
                    while (j < u.length) {                                  // Copy remaining u elements
                        a[i++] = u[j++];
                    }
                }
            }
        }
    }
}

