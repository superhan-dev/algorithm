# The binary search

the binary search can implimented with while loop, and It's a truditional way.
But in java, it also implimented by Collections.binary search.

## The truditional way

```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] arr = {1,3,4,12,15,34,36,42,51,64,66,70,88,89,94,100}; // 16개
    System.out.println(binarySearch(arr, 51));
  }

  public static int binarySearch(int[] arr, int target){
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
      int mid = (start+end) / 2;

      if(arr[mid] < target){
        start = mid + 1;
      } else if(arr[mid] > target){
        end = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}
```

## The java collections way

```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] arr = {1,3,4,12,15,34,36,42,51,64,66,70,88,89,94,100}; // 16개
    System.out.println(binarySearch(arr, 51));
  }

  public static int binarySearch(int[] arr, int target){
    LinkedList<Integer> list = new LinkedList<>();
    for(int i : arr){
      list.add(i);
    }

    Collections.sort(list);
    int answer = Collections.binarySearch(list, target);

    return answer;
  }
}

```
