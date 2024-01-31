# Code

## QueueObject in code

```Java
class QueueObject implements Compareable<QueueObject> {
   public Vertex<String> vertex;
   public int priority;

   public QueueObject(Vertex<String> v, int p){
      this.vertex = v;
      this.priority = p;
   }

   @Override
   public int compareTo(QueueObject o){
      return Integer.compare(this.priority, o.priority);
   }
}

```

## Compareable<T>

The Compareable<T> interface has a compareTo(T v) method.

The compareTo method will be return an integer value for comparing a value. And It use an integer for the comparing in usual.

It helps to set up the priority of a PriorityQueue.

```Java
public interface Compareable<T> {
   int compareTo(T ver1);
}

public class CompareableTest implements Compareable<Integer> {
   private int data;

   public CompareableTest(int data){
      this.data = data;
   }

   @Override
   public int compareTo(int newData){
      // in Java
      return Integer.compare(this.dat, newData);

      // in truditional
      if(this.data == newData){
         return 0;
      } else if(this.data > newData){
         return 1;
      } else {
         return -1;
      }
   }

}

```

## the Priority Queue with the QueueObject

```Java
import java.util.*;

class Main {
   public static void main(String[] args){
      PriorityQueue<QueueObject> queue = new PriorityQueue<>();
      Vertex<String> firstVertex = new Vertex<>("a");
      Vertex<String> secondVertex = new Vertex<>("b");

      // Insert a value in queue.
      queue.offer(new QueueObject(firstVertex,3));
      // Insert the second value but it has a smaller priority
      // So, it will be the one order before than the first vertex.
      queue.offer(new QueueObject(firstVertex,0));

   }
}


```
