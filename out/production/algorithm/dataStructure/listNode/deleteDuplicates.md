# [LeetCode] deleteDuplicates

```java package temp.listNode;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    ListNode head = null;
    ListNode current = null;

    int[] arr = {1,1,2,3,3};

    for(int i = 0;i < arr.length; i++){
      ListNode newNode = new ListNode(arr[i]);

      if(head == null){
        head = newNode;
        current = head;
      } else {
        current.next = newNode;
        current = newNode;
      }
    }

    ListNode curr = deleteDuplicates(head);
    while(curr != null){
      System.out.print( curr.val + " ");
      curr = curr.next;
    }
    System.out.println();
  }

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;// start from head
    while(current != null) {
      // check next value
      ListNode next = current.next;
      if(next != null && next.val == current.val){
        // change pointer (delete value as change pointer)
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }

    return head;
  }
}
```
