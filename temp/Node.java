package temp;

 public class Node<V> {
    V data;
    Node<V> next;
    Node<V> prev;

    Node(){}
    Node(V data){
      this.data = data;
      next = null;
      prev = null;
    }
  }