package A6;/* SLIT.java - Two solutions to the SLIT problem
*
*  @version CS 321 - Fall 2018 - A6
*
*  @author Andrew Wrege
*
*  @author Blake Bostwick
*
*  @bug The brute-force algorithm [does/does not] work fully. [delete one]
*
*  @bug The faster algorithm  [does/does not] work fully. [delete one]
*
*/

class SLIT {

  /* given a matrix and a slit window, return T - R where:
      + the slit window is a sub-matrix of the input matrix defined by:
      - the row index r of its top-left corner
      - the column index c of its top-left corner
      - its width (i.e., number of columns)
      - a height of 2 rows (always)
      + T is the number of occurrences of 'T' in the slit window
      + R is the number of occurrences of the rest of the bases (i.e., 'A',
      'C', and 'G') in the slit window

      For example, if the input matrix is:

      TTTACTCT     and r = 5 then T = 1 and the method returns -6
      CTTTTTGG         c = 3      R = 7
      AGTTATCT         w = 4
      TAATTTTT
      TTTCCTCT
      GTTCAGTA
      TTTCACGG
      TGCTTTTT
  */
  static int count(char[][] mat, int r, int c, int w) {
      int countT = 0;
      for (int i = 0; i <= 1; i++) {
          for (int j = 0; j < w; j++) {
              if (mat[r + i][c + j] == 'T') {
                  countT++;
              }
          }
      }

    return countT;
  }// count method

  /* your implementation of the brute-force algorithm whose pseudocode is
     given in the handout
  */
  static int algorithm1(char[][] mat, int n) {

    int slit = 0;
    for (int row = 0; row < n-2; row++){
        for (int col = 0; col < n-1; col++) {
            for (int w = 1; w < n-col; w++) {
                slit = Math.max(slit, count(mat,row,col,w));
            }
        }
    }

    return slit;
  }// algorithm1 method

  /* your implementation of the second algorithm, which you must design
  */
  static int algorithm2(char[][] m,int n) {

    return mergeCount(m, 0, n/2, n, 0, n);
  }// algorithm2 method

  /* implement your helper method(s) below this point
  */

  static int mergeCount(char[][] mat, int left, int mid, int right, int top, int bot) {
      if (left >= right && top >= bot) {
          return getTDiff(mat, left, top, right - left);
      }
      else if (top - bot ==1) {
          return Math.max(getTDiff(mat, left, top, right-left  ) , Math.max(mergeCount(mat, left, (left + mid)/2, mid, top, bot), mergeCount(mat, mid, (mid+right)/2, right, top, bot) ));
      }
      else if (left - right ==1) {
          return Math.max(getTDiff(mat, left, top, right-left  ) , Math.max(mergeCount(mat, left, mid, right, top, bot/2), mergeCount(mat, left, mid, right, (top+bot)/2, bot) ));
      }
      else {
          int leftMaxT = Math.max(mergeCount(mat, left, (left + mid)/2, mid, top, bot/2), mergeCount(mat, left, (left + mid)/2, mid, (top+bot)/2, bot));
          int rightMaxT = Math.max(mergeCount(mat, mid, (mid+right)/2, right, top, bot/2), mergeCount(mat, mid, (mid+right)/2, right, (top+bot)/2, bot));

          return Math.max(getTDiff(mat, left,top, right-left), Math.max(leftMaxT,rightMaxT));
      }
  }

  static int getTDiff(char[][] mat, int r,int c, int w) {
        return (2 * count(mat, r, c, w)) - (w * 2);
  }

}// SLIT class
