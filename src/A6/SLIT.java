 /* SLIT.java - Two solutions to the SLIT problem
*
*  @version CS 321 - Fall 2018 - A6
*
*  @author Andrew Wrege
*
*  @author Blake Bostwick
*
*  @bug The brute-force algorithm [does] work fully.
*
*  @bug The faster algorithm  [does] work fully.
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
              else {
                  countT--;
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

    return mergeCount(m, 0, n-2, 0, n-1);
  }// algorithm2 method

  /* implement your helper method(s) below this point
  */

  static int mergeCount(char[][] mat, int left, int right, int top, int bot) {
      if ( right - left <= 1 && bot - top <= 1) {
          return count(mat, top, left, right - left);
        }
       int mid = (left+right)/2;
      if (bot - top > 1) {
            return Math.max(mergeCount(mat, left, right, top, (top+bot)/2),
                            mergeCount(mat, left, right, (top+bot)/2, bot)); 
        }
        else {
            int maxL = mergeCount(mat, left, mid, top, bot);
            int maxR = mergeCount(mat, mid + 1,right,top,bot);
            
            int maxSumL = 0;
            int sum = 0;
            for (int i = mid; i >= left; i--) {
                sum += count(mat,top,i,1); //only want the single pair
                if (sum > maxSumL) {
                    maxSumL = sum;
                }
            }
            
            int maxSumR = 0;
            sum = 0;
            for (int i = mid + 1; i <= right; i++) {
                sum += count(mat,top,i,1);
                if (sum > maxSumR) {
                    maxSumR = sum;
                }
            }

            return Math.max(Math.max(
                                maxL,
                                maxR),
                            (maxSumL + maxSumR));
        }
  }

}// SLIT class
