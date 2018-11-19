/* A10.java - Driver code for this assignment
 *
 *  @version CS 321 - Fall 2018 - A10
 *
 *  @author Andrew Wrege
 *
 *  @author Blake Bostwick
 *
 */

import java.util.*;
import java.io.*;
import javafx.util.Pair;

class A10 {

    static int size;        // number of edges on one side of the square
    static int minTurns;    // minimum required number of turns in the solution
    static int turnPenalty; // penalty for each extra turn over the minimum

    /* define your static variables below (NO instance variables allowed) */
    static int[] edgeArray;
    static int solutionVal;
    static String solutionPath;
    static HashMap<String, Pair<String, Integer>> solutions = new HashMap<String, Pair<String, Integer>>();

    /* load problem definition from the given file into applicable static
     * variables.
     * This method does not send anything to the console. It must catch applicable
     * exceptions and output meaningful error messages.
     */
    static void loadProblem(String fileName) {

        /* To be completed */
        try{
            File file = new File(fileName);
            Scanner in = new Scanner(file);

            minTurns = in.nextInt();
            turnPenalty = in.nextInt();
            size = in.nextInt();

            edgeArray = new int[2*(size*(size+1))];
            for(int i = 0; in.hasNextInt(); i++){
                edgeArray[i] = in.nextInt();
            }    

        }catch(FileNotFoundException ex){
            System.out.println("Your file could not be found: " + ex);
        }
    }// loadProblem method

    /* solve the problem (previously defined using the loadProblem method) using
     * dynamic programming. Both the optimal value and an optimal solution must
     * be computed and stored in/retrievable from static variables, using the
     * following two methods.
     * This method does not send anything to the console.
     */
    static void solveProblem() {
        int hEdge = 0;
        int vEdge = (edgeArray.length / 2);
        Pair<String, Integer> leftPair = recursive(0, 1, 0, 'L', hEdge + size, vEdge + size + 1);
        Pair<String, Integer> rightPair = recursive(0, 0, 1, 'R', hEdge + 1, vEdge + 1);

        int leftVal = leftPair.getValue() + edgeArray[vEdge];
        int rightVal = rightPair.getValue() + edgeArray[hEdge];

        if (leftVal > rightVal) {
            solutionPath = 'L' + (String)leftPair.getKey();
            solutionVal = leftVal;
        }
        else {
            solutionPath = 'R' + (String)rightPair.getKey();
            solutionVal = rightVal;
        }

    }// solveProblem method
    /* return the value of an optimal solution obtained with the solveProblem
     * method.
     * This method does not send anything to the console.
     * You can assume that I will always call this method right before calling
     * the getOptimalSolution method below.
     */
    static int getOptimalValue() {

        return solutionVal;
    }// getOptimalValue method

    /* return an optimal solution (e.g., "LRRLLLRR") obtained with the
     * solveProblem method.
     * This method does not send anything to the console.
     * You can assume that I will always call getOptimalValue right before calling
     * this method.
     */
    static String getOptimalSolution() {

        return solutionPath;
    }// getOptimalValue method

    /* Implement any helper method(s) that you need (if any) below
     * All methods in this class MUST be static.
     */
    static Pair<String, Integer> recursive(int numTurns, int numLeft, int numRight, char direction, int hEdge, int vEdge) {
        if (numLeft == size && numRight == size) {
            return new Pair<String, Integer>("", numTurns < minTurns ? Integer.MIN_VALUE : 0 );
        }
        Pair<String, Integer> leftPair;
        Pair<String, Integer> rightPair;
        if (direction == 'L') {
            if (numLeft!= size) {
                if (solutions.containsKey(numTurns + " " + 'L' + " "  + (vEdge + size + 1))) {
                    leftPair = solutions.get(numTurns + " " + 'L' + " "  + (vEdge + size + 1));
                }
                else {
                    leftPair = recursive(numTurns, numLeft + 1, numRight, 'L', hEdge + size, vEdge + size + 1);
                }
            }
            else {
                 leftPair = new Pair<String, Integer>("", Integer.MIN_VALUE);
            }
            if (numRight != size) {
                if (solutions.containsKey((numTurns + 1) + " " + 'R' + " "  + (hEdge + 1))) {
                    rightPair = solutions.get((numTurns + 1) + " " + 'R' + " "  + (hEdge + 1));
                }
                else {
                    rightPair = recursive(numTurns + 1, numLeft, numRight + 1, 'R', hEdge + 1, vEdge + 1);
                }
            }
            else {
                 rightPair = new Pair<String, Integer>("", Integer.MIN_VALUE);
            }
        }
        else {
            if (numLeft!= size) {
                if (solutions.containsKey((numTurns + 1) + " " + 'L' + " "  + (vEdge + size + 1))) {
                    leftPair = solutions.get((numTurns + 1) + " " + 'L' + " "  + (vEdge + size + 1));
                }
                else {
                    leftPair = recursive(numTurns + 1, numLeft + 1, numRight, 'L', hEdge + size, vEdge + size + 1);
                }
            }
            else {
                 leftPair = new Pair<String, Integer>("", Integer.MIN_VALUE);
            }
            if (numRight != size) {
                if (solutions.containsKey(numTurns + " " + 'R' + " "  + (hEdge + 1))) {
                    rightPair = solutions.get(numTurns + " " + 'R' + " "  + (hEdge + 1));
                }
                else {
                    rightPair = recursive(numTurns, numLeft, numRight + 1, 'R', hEdge + 1, vEdge + 1);
                }
            }
            else {
                 rightPair = new Pair<String, Integer>("", Integer.MIN_VALUE);
            }
        }
        int leftVal= Integer.MIN_VALUE;
        int rightVal = Integer.MIN_VALUE;
        if ((int)leftPair.getValue() != Integer.MIN_VALUE) {
            leftVal = (int) leftPair.getValue() + edgeArray[vEdge] - ((direction == 'L' || numTurns < minTurns) ? 0 : turnPenalty);
        }
        if ((int)rightPair.getValue() != Integer.MIN_VALUE) {
            rightVal = (int) rightPair.getValue() + edgeArray[hEdge] - ((direction == 'R' || numTurns < minTurns) ? 0 : turnPenalty);
        }

        if (leftVal > rightVal ) {//(int)leftPair.getValue() > (int)rightPair.getValue()) {
            solutions.put(direction + " " + numTurns + " " + vEdge, new Pair<String, Integer>( 'L' + (String)leftPair.getKey(), leftVal) );
            return new Pair<String, Integer>( 'L' + (String)leftPair.getKey(), leftVal);
        }
        else {
            solutions.put(direction + " " + numTurns + " " + hEdge, new Pair<String, Integer>('R' + (String)rightPair.getKey(), rightVal));
            return new Pair<String, Integer>('R' + (String)rightPair.getKey(), rightVal);
        }
    }

    /* Do not modify this method in your submission
     */
    public static void main(String[] args) {

        String fileName = args[0];

        loadProblem(fileName);
        solveProblem();
        int val = getOptimalValue();
        System.out.println( getOptimalSolution() + " " + val );
    }// main method

}// A10 class
