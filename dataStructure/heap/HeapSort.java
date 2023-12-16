// https://www.geeksforgeeks.org/heap-sort/

package dataStructure.heap;

public class HeapSort {

  public void sort(int[] arr){
    int n = arr.length;

    for(int i=n / 2 -1; i>=0;i--){
      heapify(arr, n,i);
    }

    for(int i=n-1;i>0;i--){
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr,i,0);
    }
  }
  
  public static void main(String[] args) {
    
  }
}
