package a8;/* Sort.java - Three versions of quicksort
 *
 *  @version CS 321 - Fall 2018 - A8
 *
 *  @author 1st Andrew Wrege
 *
 *  @author 2nd Blake Bostwick
 *
 *  @author 3rd John Otto
 *
 */

import java.util.Arrays;

class Sort {

    /* implements the version of quicksort that uses the partition1 method below
     * (EXACTLY as defined in slide set #15); returns its run time in seconds
     */
    static double algo1(int[] a) {

        long start = System.currentTimeMillis();
        algo1Helper(a, 0, a.length - 1);
        long end = System.currentTimeMillis();

        double timeToSort = (end - start) / 1000.0;

        return timeToSort;
    }// algo1 method

    /* helper method for algo1. This is the top-level method for sorting
     * a given subrange [p..r] of the input array a
     */
    static void algo1Helper(int[] a, int p, int r) {

        if (p < r) {
            int q = partition1(a, p, r);
            algo1Helper(a, p, q - 1);
            algo1Helper(a, q + 1, r);
        }
    }// algo1Helper method

    /* this is the partition method used by algo1 EXACTLY as given on slide 15-5
     * However, you must perform the swaps inline, without a method call.
     */
    static int partition1(int[] a, int p, int r) {

        int i = p - 1;
        int temp;
        for (int j = p; j < r; j++) {
            if (a[j] <= a[r]) {
                i++;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
            temp = a[r];
            a[r] = a[i + 1];
            a[i + 1] = temp;
        }

        return i + 1;
    }// partition1 method

    /* implements the version of quicksort that uses the partition2 method below
     * (EXACTLY as defined in assignment 7); returns its run time in seconds
     */
    static double algo2(int[] a) {

        long start = System.currentTimeMillis();
        algo2Helper(a, 0, a.length - 1);
        long end = System.currentTimeMillis();

        double timeToSort = (end - start) / 1000.0;

        return timeToSort;
    }// algo2 method

    /* helper method for algo2. This is the top-level method for sorting
     * a given subrange [p..r] of the input array a
     */
    static void algo2Helper(int[] a, int p, int r) {

        if (p < r) {
            int q = partition2(a, p, r);
            algo2Helper(a, p, q - 1);
            algo2Helper(a, q + 1, r);
        }

    }// algo2Helper method

    /* this is the partition method used by algo2 EXACTLY as given in A7
     * However, you must perform the swap inline, without a method call.
     */
    static int partition2(int[] a, int p, int r) {

        int x = a[p], i = p - 1, j = r + 1;
        while (i < j) {

            do {
                j = j - 1;
            }
            while (a[j] > x);

            do {
                i = i + 1;
            }
            while (a[i] < x);

            if (i < j) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        return j;
    }// partition2 method

    /* calls the built-in JDK8 version of quicksort implemented in Arrays.sort
     * returns its run time in seconds
     */
    static double algo3(int[] a) {

        long start = System.currentTimeMillis();
        Arrays.sort(a);
        long end = System.currentTimeMillis();

        double timeToSort = (end - start) / 1000.0;

        return timeToSort;
    }// algo3 method

}// Sort class
