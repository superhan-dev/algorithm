# The max path sum algorithm

the max path sum is looking for the biggest number in paths.

## consideration

- It needs to check the area of grid
- Recursive call to find the paths
  - In recursive call the reading code spot is different.
- Memoization
  - To increse the time complexity, highly recommand using memorization.
  - The positions of row and column will be the key of path.
    - It will implimented by List<Integer>
- Return the value of a vertices.

# algorithm complexity

## brote force complexity

Time: O(2 power of (r+c))
Space: O(r + c)

## memoization complexity

Time: O(r*c)
Space: O(r*c)

# The code

```java

import java.util.*;

import java.util.*;
class Main {
  public static void main(String[] args){
    List<List<Integer>> grid = new ArrayList<>();
    grid.add(List.of(1,3,5));
    grid.add(List.of(1,13,15));
    grid.add(List.of(7,2,4));

    System.out.println(maxPathSumWithMemoization(0,0,grid,new HashMap<>()));
  }

  public static int maxPathSum(int r, int c, List<List<Integer>> grid){
    if(r == grid.size() || c == grid.get(0).size()){
      return 0;
    }

    if(r == grid.size() -1 && c == grid.get(0).size() -1){
      return grid.get(r).get(c);
    }

    return grid.get(r).get(c) + Math.max(
      maxPathSum(r+1,c,grid),
      maxPathSum(r,c+1,grid)
    );
  }

  public static int maxPathSumWithMemoization(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>,Integer> memo){
    if(r == grid.size() || c == grid.get(0).size()){
      return 0;
    }

    List<Integer> pos = List.of(r,c);

    if(memo.containsKey(pos)){
      return memo.get(pos);
    }

    if(r == grid.size() -1 && c == grid.get(0).size() -1){
      return grid.get(r).get(c);
    }

    int result = grid.get(r).get(c) + Math.max(
      maxPathSumWithMemoization(r+1,c,grid,memo),
      maxPathSumWithMemoization(r,c+1,grid,memo)
    );
    memo.put(pos,result);
    return result;
  }
}

```
