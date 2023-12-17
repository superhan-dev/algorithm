# Linked List Practice

```Java
/**
  *
  *  public class Node<V> {
  *    V data;
  *    Node<V> next;
  *    Node<V> prev;
  *
  *    Node(){}
  *    Node(V data){
  *      this.data = data;
  *      next = null;
  *      prev = null;
  *    }
  *  }
  *
  */

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    LinkedList ls = new LinkedList();
    ls.head = new Node<Integer>();

    ls.preppend(0);
    ls.append(2);
    ls.append(3);
    ls.append(4);

    ls.insert(5,1);
    ls.traverseLinkedList();
  }
}


class LinkedList {
  Node<Integer> head;

  public LinkedList(){}

  public void preppend(int data){
    Node<Integer> newNode = new Node<Integer>(data);
    newNode.next = this.head.next;
    this.head = newNode;
  }

  public void append(int data){
    Node<Integer> currentNode = head;
    Node<Integer> newNode = new Node<Integer>(data);
    while(currentNode != null){
      if(currentNode.next == null){
        currentNode.next = newNode;
        break;
      }
      currentNode = currentNode.next;
    }
  }

  public void insert(int data, int index){
    Node<Integer> newNode = new Node<>(data);
    if(this.head == null){
      this.head = newNode;
    }

    int count = 0;
    Node<Integer> currentNode = this.head;
    while(currentNode != null){
      if(count == index){
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        break;
      }
      currentNode = currentNode.next;
      count++;
    }
  }

  public void traverseLinkedList(){
    Node<Integer> currentNode = this.head;
    while(currentNode != null){
      if(currentNode.next == null){
        System.out.print(currentNode.data);
        System.out.println();
      } else {
        System.out.print(currentNode.data+" -> ");
      }
      currentNode = currentNode.next;
    }
  }
}

```
