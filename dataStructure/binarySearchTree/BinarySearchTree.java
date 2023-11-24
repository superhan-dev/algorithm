package dataStructure.binarySearchTree;

public class BinarySearchTree {

  private Node root;

  public Node getRoot() {
    return root;
  }

  public Node findNode(int key) {
    Node focuseNode = root;

    while (focuseNode.getKey() != key) {
      if (key < focuseNode.getKey()) {
        focuseNode = focuseNode.getLeftNode();
      } else {
        focuseNode = focuseNode.getRightNode();
      }

      if (focuseNode == null) {
        return null;
      }
    }

    return focuseNode;
  }

  public void inOrderTraverse(Node focuseNode) {
    if (focuseNode != null) {
      inOrderTraverse(focuseNode.getLeftNode());
      System.out.println(focuseNode);
      inOrderTraverse(focuseNode.getRightNode());
    }
  }

  public void preOrderTraverse(Node focuseNode) {
    if (focuseNode != null) {
      System.out.println(focuseNode);
      preOrderTraverse(focuseNode.getLeftNode());
      preOrderTraverse(focuseNode.getRightNode());
    }
  }

  public void postOrderTraverse(Node focuseNode) {
    if (focuseNode != null) {
      postOrderTraverse(focuseNode.getLeftNode());
      postOrderTraverse(focuseNode.getRightNode());
      System.out.println(focuseNode);
    }
  }

  public void addNode(Node node) {
    Node newNode = node;
    if (root == null) {
      root = newNode;
    } else {
      Node focuseNode = root;
      Node parentNode;

      while (true) {
        parentNode = focuseNode;

        if (newNode.getKey() < focuseNode.getKey()) {
          focuseNode = focuseNode.getLeftNode();

          if (focuseNode == null) {
            parentNode.setLeftNode(newNode);
            return;
          }
        } else {
          focuseNode = focuseNode.getRightNode();

          if (focuseNode == null) {
            parentNode.setRightNode(newNode);
            return;
          }
        }
      }
    }
  }
}
