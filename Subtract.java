package codepath;


import java.util.Stack;

/**
 * Given a singly linked list, modify the value of first half nodes such that :
 *
 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 * and so on …
 *
 * Example:
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 *
 * You should return 4 -> 2 -> 3 -> 4 -> 5
 *
 */
public class Subtract {

  public static void main(String[] args){

    Subtract sub = new Subtract();

    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    ListNode result = sub.subtract(n1);
    System.out.print("Test");
  }

  public ListNode subtract(ListNode a) {
    ListNode current = a;
    ListNode resultList = null;
    ListNode first = null;

    Stack stack = new Stack();
    int listSize = 0;

    // traverse given single linked list and enter items onto stack as read
    while(current != null){
      stack.push(current);
      current = current.next;
      listSize++;
    }

    if(listSize == 1){
      return a;
    }

    // traverse half of given linked list
    for (int i = 0; i < (listSize / 2); i++) {
      ListNode top = (ListNode) stack.pop();
      int val = top.val - a.val;

      if(resultList == null){
        resultList = new ListNode(val);
        first = resultList;
      }else{
        resultList.next = new ListNode(val);
        resultList = resultList.next;
      }

      a = a.next;
    }

    // traverse remaining half of the given list
    while (a != null){
      resultList.next = new ListNode(a.val);
      resultList = resultList.next;
      a = a.next;
    }

    return first;
  }

}

class ListNode {
  public int val;
  public ListNode next;
  ListNode(int x) { val = x; next = null; }
}


