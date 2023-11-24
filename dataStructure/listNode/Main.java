package dataStructure.listNode;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    ListNode head = null;

    int[] arr = {3,2,0,-4,6};    
    // int[] arr = {1,2};


    head = new ListNode(arr[0]);
    head.next = new ListNode(arr[1]);
    head.next.next = new ListNode(arr[2]);
    // head.next.next = head;
    head.next.next.next = new ListNode(arr[3]);    
    head.next.next.next.next = new ListNode(arr[4]);

    head.next.next.next.next.next = head.next.next;
    ListNode answer = detectCycle(head);
    if(answer == null){
      System.out.println("no cycle");
    }

    for(int i=0;i<arr.length;i++){
      if(answer.val == arr[i]){
        System.out.println("tail connects to node index " + i);
      }
    }
  }

  public static ListNode detectCycle(ListNode head) {
    ListNode answer = null;// start from head
    
    if(head == null || head.next == null){
      return answer;
    }
    ListNode slow = head;
    ListNode fast = head;
    while(head != null) {
      // check next value  
      slow = slow.next;
      fast = fast.next.next;
    
      if(slow == fast){
        slow = head; // compare the value from first
        while(slow != fast){
          slow = slow.next; // 3 // 2
          fast = fast.next; // -4 // 2
        }
        return slow;
      }
    }

    return answer;
  }
}