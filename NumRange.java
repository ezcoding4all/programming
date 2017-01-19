package codepath;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * NUMRANGE
 *
 * Given an array of non negative integers A, and a range (B, C),
 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
 *
 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 * where 0 <= i <= j < size(A)
 *
 * Example:
 * Input:
 *  A : [10, 5, 1, 0, 2]
 *  (B, C) : (6, 8)
 *
 * Output: 3
 *
 */
public class NumRange {


  public static void main(String args[])
  {
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.addAll(Arrays.asList(10, 5, 1, 0, 2));
    int b = 6, c = 8;

    NumRange nr = new NumRange();
    int cnt  = nr.numRange(a, b, c);


    System.out.println("Continuous subsequence count: "+ cnt);
  }

  public int numRange(ArrayList<Integer> a, int b, int c) {
    // b is LOW and c is HIGH
    int cnt=0, sum=0;

    for(int i=0; i < a.size(); i++){
      // for every new sequence set sum = 0
      sum = 0;

      for(int j=i; j < a.size(); j++){
        // if array element is greater than c then ignore it and move to next element
        if(a.get(j) > c){
          break;
        }

        // read array element and add to sum
        sum = sum + a.get(j);

        // if sum is within given range then increase result count by 1
        if(sum >= b && sum <= c){
          cnt = cnt  + 1;
        }
      }
    }
    return cnt;
  }

}
