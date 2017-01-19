package codepath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Kth Smallest Element in the Array
 *
 * Find the kth smallest element in an unsorted array of non-negative integers.
 *
 * NOTE
 * You are not allowed to modify the array ( The array is read only ).
 * Try to do it using constant extra space.
 *
 * Example:
 *
 *  Input:
 *    A : [2 1 4 3 2]
 *    k : 3
 *
 *  Output: 2
 *
 */
public class KthSmallest {

  public static void main(String[] args){

    KthSmallest ks = new KthSmallest();

    List<Integer> a = Arrays.asList(2, 1, 4, 3, 2);

    int result = ks.kthsmallest(a, 3);

    System.out.println(result);

  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int kthsmallest(final List<Integer> a, int k) {

    int temp = k;

    List<Integer> minList = new ArrayList<Integer>();

    while(temp > 0){
      int minIndex = 0;

      while (minList.contains(minIndex)){
        minIndex++;
      }

      for(int i=0; i < (a.size()-1); i++){
        if(minList.contains(i)){
          continue;
        }

        int j = i + 1;
        while (minList.contains(j)){
          j++;
        }

        if(j >= a.size()){
          continue;
        }

        if(a.get(minIndex) > a.get(j)){
          minIndex = j;
        }
      }
      minList.add(minIndex);
      temp --;
    }

    return a.get(minList.get(k-1));
  }
}
