package temp;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import temp.binarySearchTree.BinarySearchTree;
import temp.binarySearchTree.Node;

public class Main {
  public static void main(String[] args) {
    int[] nums = { 3, 3 };
    int target = 6;

    Map<Integer, Integer> map = new HashMap<>();

    int[] answer = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        answer[0] = map.get(target - nums[i]);
        answer[1] = i;
      }

      map.put(nums[i], i);
    }

    System.out.println(Arrays.toString(answer));
  }
}