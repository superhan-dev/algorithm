package temp.binarySearchTree;

public class Main {
  public static void main(String[] args) {

    Node node1 = new Node(3, "3");
    Node node2 = new Node(2, "2");
    Node node3 = new Node(5, "5");
    Node node4 = new Node(1, "1");
    Node node5 = new Node(7, "7");
    Node node6 = new Node(4, "4");

    BinarySearchTree binarySearchTree = new BinarySearchTree();

    binarySearchTree.addNode(node1);
    binarySearchTree.addNode(node2);
    binarySearchTree.addNode(node3);
    binarySearchTree.addNode(node4);
    binarySearchTree.addNode(node5);
    binarySearchTree.addNode(node6);

    System.out.println("the root is : " + binarySearchTree.getRoot().getKey());
    System.out.println("inOrderTraverse : ");
    binarySearchTree.inOrderTraverse(binarySearchTree.getRoot());

    System.out.println("preOrderTraverse : ");
    binarySearchTree.preOrderTraverse(binarySearchTree.getRoot());

    System.out.println("postOrderTraverse : ");
    binarySearchTree.postOrderTraverse(binarySearchTree.getRoot());

    Node findedNode = binarySearchTree.findNode(7);

    System.out.println(findedNode.getName());
  }
}