package dataStructure.completeBinaryTree;

public class Tree {
  Node root;

  public Node insertLevelOrder(int[] arr, int i){
    Node root = null;
    if(i < arr.length){
      root = new Node(arr[i]);

      root.left = insertLevelOrder(arr, 2 * i + 1);
      root.right = insertLevelOrder(arr, 2 * i + 2);
    }

    return root;
  }

  public void inOrder(Node root){
    if(root != null){
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }

  public static void main(String[] args) {
    Tree t = new Tree();

    int[] arr = {1,2,3,4,5,6,6,6,6};
    t.root = t.insertLevelOrder(arr, 0);
    t.inOrder(t.root);
    System.out.println();
  }
}
