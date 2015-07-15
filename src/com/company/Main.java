package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        final int start = (int) ((Math.random() * 10) + 1);
        final int start2 = (int) ((Math.random() * 10) + 1);
        //final int start = 1000000000;
        //final int start2 = 1000000000;
        int[] a = new int[start];
        int[] b = new int[start2];

        for (int i = 0; i < a.length; ++i) {
            a[i] = (int) ((Math.random() * 10) + 1);
        }
        for (int i = 0; i < b.length; ++i) {
            b[i] = (int) ((Math.random() * 10) + 1);
        }

        int[] c = new int[a.length + b.length];
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println();
        mergesort(a);
        mergesort(b);
        merge(c, a, b);
        c = removeduplicate(c);
        System.out.println(Arrays.toString(c));
        final long duration = System.nanoTime() - startTime;
        System.out.println("Time: " + duration / 1000000 + " millisecond.");
    }

    private static int[] removeduplicate(int[] c) {
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

    static void mergesort(int[] a) {
        if (a.length > 1) {
            int[] u = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] v = Arrays.copyOfRange(a, a.length / 2, a.length);
            mergesort(u);
            mergesort(v);
            merge(a, u, v);
        }
    }

    static void merge(int[] a, int[] u, int[] v) {
        int i, j, k;
        i = j = k = 0;
        while (i < u.length + v.length) {
            if (j < u.length && k < v.length) {
                if (u[j] < v[k]) {
                    a[i++] = u[j++];
                } else {
                    a[i++] = v[k++];
                }
            } else {
                if (j >= u.length) {
                    while (k < v.length) {
                        a[i++] = v[k++];
                    }
                }
                if (k >= v.length) {
                    while (j < u.length) {
                        a[i++] = u[j++];
                    }
                }
            }
        }
    }
}

