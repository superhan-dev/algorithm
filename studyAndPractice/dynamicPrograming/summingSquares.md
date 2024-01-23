# The summing squares algorithm

# algorithm complexity

## brote force complexity

Time: O(sqrt(n) power of n)
Space: O(n)

## memoization complexity

Time: O(n\*sqrt(n))
Space: O(n)

# The code

```java

import java.util.*;

class Main {
  public static void main(String[] args){
    List<Integer> nums = new ArrayList<>();
    nums.add(2);
    nums.add(4);
    nums.add(5);
    nums.add(12);
    nums.add(7);

    System.out.println(nonAdjacentSum(nums, 0));

  }

  public static int nonAdjacentSum(List<Integer> nums, int i){
    if(i >= nums.size()){
      return 0;
    }

    return Math.max(
      nums.get(i) + nonAdjacentSum(nums, i+2),
      nonAdjacentSum(nums, i+1)
    );
  }

  public static int nonAdjacentSumWithMemoization(List<Integer> nums, int i, HashMap<Integer, Integer> memo){
    if(i >= nums.size()){
      return 0;
    }

    if(memo.containsKey(i)){
      return memo.get(i);
    }

    int result = Math.max(
      memo.get(i) + nonAdjacentSumWithMemoization(nums, i+2, memo),
      nonAdjacentSumWithMemoization(nums, i+1, memo)
    );

    memo.put(i, result);

    return result;
  }
}

```
