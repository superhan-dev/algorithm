package dataStructure.matrix;
// https://www.geeksforgeeks.org/print-matrix-in-zig-zag-fashion/

/**
 * Input: 
    1 2 3
    4 5 6
    7 8 9
   Output: 
    1 2 4 7 5 3 6 8 9
 */

import java.util.*;

public class ZigZagMetrix {
  static final int C = 3;
  public static void zigZagMatrix(int[][] matrix, int n, int m){
    List<Integer> temp = new ArrayList<Integer>();
    int row = 0, col = 0;

    // Boolean variable that will true.
    // If, we need to increment 'row' value,
    // otherwise false if increment 'col' value
    boolean isRowIncrese = false;
    
    // Why using min() for the "mn" rather than using max() or other?
    int mn = Math.min(m,n); // 3

    // Why the "len" start from 1?
    for(int len = 1; len < mn; ++len){ 
      for(int i = 0; i < len; ++i){
        
        // Why is this for? - to stop when you before end of len
        if(i + 1 == len) break;

        // If isRowIncrement value is true, increment row and decrement col
        // Else, decrement row and increment col
        if(isRowIncrese){
          ++row;
          --col;
        } else {
          --row;
          ++col;
        }
      } 

      if(len == mn) break;

      // Update row or col value according
      // to the last increment
      if(isRowIncrese){
        ++row;
        isRowIncrese = false;
      } else {
        ++col;
        isRowIncrese = true;
      }
    }

    if(row == 0){
      if(col == m - 1) ++row;
      else ++col;
    } else {
      if(row == n -1) ++col;
      else ++row;
      isRowIncrese = false;
    }

    for(int i: temp){
      System.out.println(i);
    }
  }


  public static void main(String[] args) {
    int[][] input = { {1,2,3}, 
                      {4,5,6}, 
                      {7,8,9} };

    zigZagMatrix(input, C, C);
  }
}
