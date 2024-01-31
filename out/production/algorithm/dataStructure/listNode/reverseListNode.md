# Reverse ListNode

```java
public class ListNode {
  int val;
  int next;
  public ListNode(){}
  public ListNode(int val){ this.val = val;}
  public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseListNode {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode result = reverseListNode(head);
    printNode(result);

  }

  public static ListNode reverseListNode(ListNode head){
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;

    while(current != null){
      next = current.next;
      current.next = prev;
      prev = current;

      current = next;
    }

    return prev;
  }

  public ststic printNode(ListNode node){
    while(node != null){
      System.out.println(node.val);
      node = node.next;
    }
  }
}


```
