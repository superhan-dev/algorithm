package teamtreehouse.java;

public class BinarySearch {
  public static void main(String[] args) {
    int[] list = {1,2,3,4,5,6,7,8,9,10};

    System.out.println(iterativeBinarySearch(list, 3));

    // System.out.println(2 + (3 - 2) / 2); // 2
    System.out.println(recursiveBinarySearch(list, 5, 0, list.length -1));
  }

  public static int iterativeBinarySearch(int[] list, int target){
    int first = 0;
    int last = list.length - 1;

    while(first <= last){
      int midpoint = (first + last) / 2; // a pointer of value
      if(list[midpoint] == target){
        return midpoint;
      } else if(list[midpoint] < target){
        first = midpoint + 1; // move forward the pointer.
      } else {
        last = midpoint - 1;
      }
    }
    
    return -1;
  }

  public static int recursiveBinarySearch(int[] list, int target, int start, int end){
    if(start > end) {
      return -1;
    }

    int midpoint = (start + end) / 2;
    if(target < list[midpoint]){
      return recursiveBinarySearch(list, target, start, midpoint - 1);
    } else if(target > list[midpoint]) {
      return recursiveBinarySearch(list, target, midpoint + 1, end);      
    } else {
      return midpoint;
    }
  }
}
