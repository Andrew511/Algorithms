package a8;/* A8.java - Driver code for this assignment
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

import java.util.Random;
import java.util.Arrays;

class A8 {

    static final int MIN_N = (int) Math.pow(2, 10);  /* minimum array size */
    static final int MAX_N = (int) Math.pow(2, 30);  /* maximum array size */

    /* Perform the three experiments for part 3; the first argument must be used
     * in the call to Rand.shuffleArray() and the second argument must be used
     * to select the algorithm to test.
     *
     * For part 3, each experiment must run the selected algorithm once for all
     * input sizes ranging from MIN_N to MAX_N. For each run, your code must
     * output the size of the input array and the running time in seconds, in
     * a format that makes it easy to paste the output into Excel. Ideally,
     * we would perform several runs for each input size and average the running
     * time. However, to save you time, we'll limit ourselves to one run per size.
     *
     * For each run:
     *  1. Create an array of the given size (with Utils.createSortedArray).
     *  2. Shuffle the array fully (to create a random input).
     *  3. Run the selected algorithm on this input.
     *  4. Send the output to the console (not to a file).
     *  5. Double the array size (in preparation for the next run).
     *
     * Each experiment will stop when the JVM runs out of memory (but do use the
     * command-line arguments described in the main method below in order to
     * override the small default values used by the JVM) or when one single run
     * (for a given input size) takes more than 5 minutes.
     *
     */
    static void part3(int seed, int algo_num) {
        int array_size = MIN_N;


        while (array_size <= MAX_N) {
            int[] array = Utils.createSortedArray(array_size);
            Rand.shuffleArray(array, seed, array_size);
            double timeToRun = 0.0;

            if (algo_num == 1) {
                timeToRun =  Sort.algo1(array);
            } else if (algo_num == 2) {
                timeToRun =  Sort.algo2(array);
            } else if (algo_num == 3) {
                timeToRun =  Sort.algo3(array);
            } else {
                System.out.println("Algorithm " + algo_num + "does not exist");
                break; // if invalid algorithm, don't keep iterating
            }

            System.out.println(array_size + ": " + timeToRun);
            if (timeToRun > (60 * 5)) {
                break; //if a single run takes more than 5 minutes, break out of loop
            }
            array_size = array_size * 2;
        }

    }// part3 method

    /* Perform the three experiments for part 4; the argument must be used
     * to select the algorithm to test.
     *
     * For part 4, each experiment must run the selected algorithm once for all
     * input sizes ranging from MIN_N to MAX_N. For each run, your code must
     * output the size of the input array and the running time in seconds, in
     * a format that makes it easy to paste the output into Excel. Ideally,
     * we would perform several runs for each input size and average the running
     * time. However, to save you time, we'll limit ourselves to one run per size.
     *
     * For each run:
     *  1. Create an array of the given size (with Utils.createSortedArray).
     *  2. Run the selected algorithm on this input.
     *  3. Send the output to the console (not to a file).
     *  4. Double the array size (in preparation for the next run).
     *
     * Each experiment will stop when the JVM runs out of memory (but do use the
     * command-line arguments described in the main method below in order to
     * override the small default values used by the JVM) or when one single run
     * (for a given input size) takes more than 5 minutes.
     *
     */
    static void part4(int algo_num) {

        int array_size = MIN_N;


        while (array_size <= MAX_N) {
            int[] array = Utils.createSortedArray(array_size);
            double timeToRun = 0.0;

            if (algo_num == 1) {
                timeToRun =  Sort.algo1(array);
            } else if (algo_num == 2) {
                timeToRun =  Sort.algo2(array);
            } else if (algo_num == 3) {
                timeToRun =  Sort.algo3(array);
            } else {
                System.out.println("Algorithm " + algo_num + "does not exist");
                break; // if invalid algorithm, don't keep iterating
            }

            System.out.println(array_size + ": " + timeToRun);
            if (timeToRun > (60 * 5)) {
                break; //if a single run takes more than 5 minutes, break out of loop
            }
            array_size = array_size * 2;
        }

    }// part4 method

    /* Perform the three experiments for part 5; the argument must be used
     * to select the algorithm to test.
     *
     * For part 5, each experiment must run the selected algorithm once for all
     * input sizes ranging from MIN_N to MAX_N. For each run, your code must
     * output the size of the input array and the running time in seconds, in
     * a format that makes it easy to paste the output into Excel. Ideally,
     * we would perform several runs for each input size and average the running
     * time. However, to save you time, we'll limit ourselves to one run per size.
     *
     * For each run:
     *  1. Create an array of the given size (with Utils.createReverseSortedArray).
     *  2. Run the selected algorithm on this input.
     *  3. Send the output to the console (not to a file).
     *  4. Double the array size (in preparation for the next run).
     *
     * Each experiment will stop when the JVM runs out of memory (but do use the
     * command-line arguments described in the main method below in order to
     * override the small default values used by the JVM) or when one single run
     * (for a given input size) takes more than 5 minutes.
     *
     */
    static void part5(int algo_num) {

        int array_size = MIN_N;


        while (array_size <= MAX_N) {
            int[] array = Utils.createReverseSortedArray(array_size);
            double timeToRun = 0.0;

            if (algo_num == 1) {
                timeToRun =  Sort.algo1(array);
            } else if (algo_num == 2) {
                timeToRun =  Sort.algo2(array);
            } else if (algo_num == 3) {
                timeToRun =  Sort.algo3(array);
            } else {
                System.out.println("Algorithm " + algo_num + "does not exist");
                break; // if invalid algorithm, don't keep iterating
            }

            System.out.println(array_size + ": " + timeToRun);
            if (timeToRun > (60 * 5)) {
                break; //if a single run takes more than 5 minutes, break out of loop
            }
            array_size = array_size * 2;
        }

    }// part5 method

    /* Perform the three experiments for part 6; the argument must be used
     * to select the algorithm to test.
     *
     * For part 6, each experiment must run the selected algorithm once for all
     * input sizes ranging from MIN_N to MAX_N. For each run, your code must
     * output the size of the input array and the running time in seconds, in
     * a format that makes it easy to paste the output into Excel. Ideally,
     * we would perform several runs for each input size and average the running
     * time. However, to save you time, we'll limit ourselves to one run per size.
     *
     * For each run:
     *  1. Create an array of the given size (w/ Utils.createEqualElementsArray).
     *  2. Run the selected algorithm on this input.
     *  3. Send the output to the console (not to a file).
     *  4. Double the array size (in preparation for the next run).
     *
     * Each experiment will stop when the JVM runs out of memory (but do use the
     * command-line arguments described in the main method below in order to
     * override the small default values used by the JVM) or when one single run
     * (for a given input size) takes more than 5 minutes.
     *
     */
    static void part6(int algo_num) {

        int array_size = MIN_N;

        while (array_size <= MAX_N) {
            int[] array = Utils.createEqualElementsArray(array_size);
            double timeToRun = 0.0;

            if (algo_num == 1) {
                timeToRun =  Sort.algo1(array);
            } else if (algo_num == 2) {
                timeToRun =  Sort.algo2(array);
            } else if (algo_num == 3) {
                timeToRun =  Sort.algo3(array);
            } else {
                System.out.println("Algorithm " + algo_num + "does not exist");
                break; // if invalid algorithm, don't keep iterating
            }

            System.out.println(array_size + ": " + timeToRun);
            if (timeToRun > (60 * 5)) {
                break; //if a single run takes more than 5 minutes, break out of loop
            }
            array_size = array_size * 2;
        }

    }// part6 method

    /* Perform the three experiments for part 7; the first argument must be used
     * in each call Rand.shuffleArray(); the second argument must be used
     * to select the algorithm to test.
     *
     * For part 7, each experiment must run the selected algorithm once for all
     * values of n ranging from 0 to 5000. For each run, your code must
     * run on a sorted array of size 2^20 with increasing amount of randomness.
     * You must output the value of n and the running time in seconds, in
     * a format that makes it easy to paste the output into Excel. Ideally,
     * we would perform several runs for each input size and average the running
     * time. However, to save you time, we'll limit ourselves to one run per size.
     *
     * For each run:
     *  1. Create an array of size 2^20 (with Utils.createSortedArray).
     *  2. Shuffle the array using the current value of n.
     *  3. Run the selected algorithm on THIS input.
     *  4. Send the output to the console (not to a file).
     *  5. Increment the value of n by 100 (in preparation for the next run).
     *
     * Each experiment will run to completion.
     *
     */
    static void part7(int seed, int algo_num) {

        int array_size = (int) Math.pow(2, 20);

        for (int n = 0; n <= 5000; n += 100) {
            int[] array = Utils.createSortedArray(array_size);
            Rand.shuffleArray(array, seed, n);
            double timeToRun = 0.0;

            if (algo_num == 1) {
                timeToRun =  Sort.algo1(array);
            } else if (algo_num == 2) {
                timeToRun =  Sort.algo2(array);
            } else if (algo_num == 3) {
                timeToRun =  Sort.algo3(array);
            } else {
                System.out.println("Algorithm " + algo_num + "does not exist");
                break; // if invalid algorithm, don't keep iterating
            }

            System.out.println(n + ": " + timeToRun);
        }

    }// part7 method

    /*********************************/
    /* There is no coding for part 7 */

    /*********************************/

    /* Create and return the shortest possible array of integers that causes
     * Arrays.sort(int[]) to (partly) execute a one-pivot quicksort algorithm.
     */
    static int[] part9() {
        /*
            below length 48, (length <= 47) DualPivotQuicksort uses insertion sort for speed
            as such, the array must be at least 48 elements long to use dual pivot quicksort.

            Dual pivot quicksort pulls it's left pivot from a[0], and it's right pivot from
            the end of the array, if the left pivot is greater than the right pivot, the two
            pivots are swapped.

            In order to degrade this into a single pivot quicksort, we make the left pivot
            and right pivot equal, as such they function as a single pivot as all other elements
            are either strictly greater, or less than or equal to the two pivots, which results
            in the algorithm functioning as a single pivot quicksort.
         */
        int[] a = new int[48];
        a[0] = 2; //left pivot is picked from a[0]
        a[a.length - 1] = 2; //right pivot is picked from last element of the array
        for (int i = 1; i < a.length - 1; i++) { //first & last element are already set to pivots, fill inbetween
            if (i % 2 == 1) {
                a[i] = 1; //less than pivot
            } else {
                a[i] = 3; //greater than pivot
            }
        }

        return a;
    }// part9 method

    /* Do not modify this method
     */
    public static void main(String[] args) {

    /* usage:  java -Xms2000m -Xss2000m A8 <experiment_identifier>
       Note: the two -X command-line options are there to specify the amount
             of memory that the JVM should allocate to the heap and stack
    */

        if (args[0].equals("p3a1")) {
            part3(0, 1);
        }
        if (args[0].equals("p3a2")) {
            part3(0, 2);
        }
        if (args[0].equals("p3a3")) {
            part3(0, 3);
        }

        if (args[0].equals("p4a1")) {
            part4(1);
        }
        if (args[0].equals("p4a2")) {
            part4(2);
        }
        if (args[0].equals("p4a3")) {
            part4(3);
        }

        if (args[0].equals("p5a1")) {
            part5(1);
        }
        if (args[0].equals("p5a2")) {
            part5(2);
        }
        if (args[0].equals("p5a3")) {
            part5(3);
        }

        if (args[0].equals("p6a1")) {
            part6(1);
        }
        if (args[0].equals("p6a2")) {
            part6(2);
        }
        if (args[0].equals("p6a3")) {
            part6(3);
        }

        if (args[0].equals("p7a1")) {
            part7(0, 1);
        }
        if (args[0].equals("p7a2")) {
            part7(0, 2);
        }
        if (args[0].equals("p7a3")) {
            part7(0, 3);
        }

        if (args[0].equals("p9")) {
            part9();
        }

    }// main method

}// A8 class
