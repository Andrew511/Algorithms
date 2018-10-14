/*  A6.java - Driver code
*
*  @version CS 321 - Fall 2018 - A6
*
**/

import java.util.Random;

class A6 {

  static int minN = 32;      // smallest size of the matrix in our test suite
  static int maxN = 8192;     // largest size of the matrix in our test suite

  /* return an n x n matrix whose elements are randomly selected from the set
    {'A','C','G','T'} with 'T' being (much) more likely than the other
    The given seed is used to vary the matrix in our tests while making the
    tests repeatable.
  */
  static char[][] getRandomMatrix(int n, int seed) {
    Random rand  = new Random(seed);
    char[][] mat = new char[n][n];
    int index;
    for(int r=0; r<n; r++) {
      for(int c=0; c<n; c++) {
        index = rand.nextInt(20);
        if      (index <= 10) { mat[r][c] = 'T'; }
        else if (index <= 13) { mat[r][c] = 'A'; }
        else if (index <= 16) { mat[r][c] = 'C'; }
        else                  { mat[r][c] = 'G'; }
      }
    }
    return mat;
  }// getRandomMatrix method

  /* send the contents of the given matrix of size n x n to the console.
    This method is not really necessary for this assignment but may be
    useful for debugging purposes.
  */
  static void printMatrix(char[][] mat, int n) {
    for(int r=0; r<n; r++) {
      for(int c=0; c<n; c++) {
        System.out.format("%c",mat[r][c]);
      }
      System.out.println();
    }
  }// printMatrix method

  /* run one set of tests comparing two SLIT algorithms (defined in
    SLIT.java) on a given random matrix whose contents are determined by
    the seed value provided on the command line.
  */
  public static void main(String[] args) {

    if (args.length != 1) {
      System.out.println("Usage:\n\tjava A6 <seed>");
      System.exit(0);
    }

    int seed = Integer.parseInt(args[0]);

    // create a single matrix for all tests in this suite
    System.out.println("Populating the matrix...");
    char[][] m = getRandomMatrix(maxN,seed);
    System.out.println("Done\nseed = " + args[0] + "\nmaxN = " + maxN);

    // run the test suite for each power of 2 in [minN..maxN]
    for(int n=minN; n<=maxN; n *= 2) {

      // brute-force algorithm

      long start = System.nanoTime();
      int slit = SLIT.algorithm1(m,n);
      long end = System.nanoTime();
      System.out.format("%6d,%8.3f,%4d,",n,(end-start)/1e9,slit);

      // faster algorithm

      start = System.nanoTime();
      slit = SLIT.algorithm2(m,n);
      end = System.nanoTime();
      System.out.format("%8d,%7.3f\n",slit,(end-start)/1e9);

    }// loop on n
  }// main method
}// A6 class
