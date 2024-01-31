# how to add ListNode in Linked List?

## the algorithm from GFG

- the GFG's code let me know this code. But the linked list in the code store the value as stack way(LIFO). But I want to store the value sequentially.

```java
class SingleLinkedLsit<V> {
  Node<V> head;

  SingleLinkedLsit(){}

  void addNode(V data){
    Node<V> newNode = new Node<V>(data);

    newNode.next = head;
    head = newNode;
  }
}
```

- This code was that I wanted to implement(store the value sequentially).

```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
      Node<Integer> node1 = new Node<>(1);
      Node<Integer> node2 = new Node<>(2);
      Node<Integer> node3 = new Node<>(3);
      Node<Integer> node4 = new Node<>(4);
      Node<Integer> node5 = new Node<>(5);

      SingleLinkedLsit<Integer> list = new SingleLinkedLsit<>();

      list.addNode(node1.data);
      list.addNode(node2.data);
      list.addNode(node3.data);
      list.addNode(node4.data);
      list.addNode(node5.data);

      while(list.head != null){
        System.out.println(list.head.data);
        list.head = list.head.next;
      }
  }
}

class SingleLinkedLsit<V> {
  Node<V> head;

  SingleLinkedLsit(){}

  void addNode(V data){
    Node<V> newNode = new Node<V>(data);

    Node<V> last = head; // the pointer.

    // put the value on the head of the Node.
    if(head == null){
      newNode.next = head;
      head = newNode;
      return;
    }
    // move the pointer to end of Node.
    while(last.next != null){
      last = last.next;
    }
    last.next = newNode; // Insert the value at the end.
  }
}
```

# Conclusion

- Spent so much time to figured it out. I need to practice more about manipulating the pointer in Linked List.
