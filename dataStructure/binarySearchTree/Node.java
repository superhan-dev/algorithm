package dataStructure.binarySearchTree;

public class Node {

  private int key;
  private String name;
  private Node leftNode;
  private Node rightNode;

  public Node(int key, String name) {
    this.key = key;
    this.name = name;
  }

  public int getKey() {
    return key;
  }

  public String getName() {
    return name;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLeftNode(Node leftNode) {
    this.leftNode = leftNode;
  }

  public void setRightNode(Node rightNode) {
    this.rightNode = rightNode;
  }

  @Override
  public String toString() {
    return name + " has a key " + key;
  }
}
