package codepath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 *
 * Example:
 * Input: A = 4.
 *
 * Output:
 *  4 4 4 4 4 4 4
 *  4 3 3 3 3 3 4
 *  4 3 2 2 2 3 4
 *  4 3 2 1 2 3 4
 *  4 3 2 2 2 3 4
 *  4 3 3 3 3 3 4
 *  4 4 4 4 4 4 4
 *
 * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
 *
 * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrint {

  public static void main(String[] args){
    PrettyPrint pp = new PrettyPrint();
    ArrayList<ArrayList<Integer>> result =  pp.prettyPrint(3);


    for(int i=0; i < result.size(); i++){
      System.out.println(Arrays.toString(result.get(i).toArray()));
    }

  }

  public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
    int size = a + a - 1;
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>(size);

    // initialize empty set
    for(int i = 0; i < size; i++)  {
      resultList.add(new ArrayList<Integer>(Collections.nCopies(size, 0)));
    }

    int t = 0; // top row index
    int b = size - 1; // bottom row index (no. of rows - 1)
    int l = 0; // left column index
    int r = size - 1; // right column index (no. of cols - 1)
    int direction = 0; // 0 - right; 1 - bottom; 2 - left; 3 - top

    while(t <= b && l <= r){

      if(direction == 0){ // Go right
        for(int i=l; i <= r; i++){
          resultList.get(t).set(i, a);
        }
        t++; direction = 1;
      } else if (direction == 1){ // Go bottom
        for(int i=t; i <= b; i++){
          resultList.get(i).set(r, a);
        }
        r--; direction = 2;
      } else if (direction == 2){ // Go left
        for(int i = r; i >= l; i--){
          resultList.get(b).set(i, a);
        }
        b--; direction = 3;
      } else if(direction == 3){ // Go top
        for(int i = b; i >= t; i--){
          resultList.get(i).set(l, a);
        }
        l++; direction = 0; a--;
      }
    }


    return resultList;
  }
}


