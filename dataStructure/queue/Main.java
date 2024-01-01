package dataStructure.queue;

import java.util.*;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<String>();
    queue.offer("Hello");

    // String v = queue.peek();
    String v = queue.poll();
    System.out.println(v);

    int s = queue.size();
    System.out.println(s);

    String poped = queue.peek();
    System.out.println(poped);

    
  }
}
