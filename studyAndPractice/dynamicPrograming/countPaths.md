# The countPaths algorithm

count paths to specific position of a grid

# algorithm complexity

## brute force

- time: O(2 power of (r+c))
- space: O(r \* c)

## memoization

- time: O(r + c)
- space: O(r \* c)

# The code

```java

import java.util.*;

class Main {
  public static void main(String[] args){
    List<List<String>> grid = new ArrayList<>();
    grid.add(List.of("0","1","X"));
    grid.add(List.of("0","1","2"));
    grid.add(List.of("0","1","2"));

    System.out.println("The brute force");
    System.out.println(countPaths(0,0,grid));
    System.out.println("The memoization");
    System.out.println(countPathsWithMemoization(0,0,grid, new HashMap<List<Integer>,Integer>()));
  }

  public static int countPaths(int r, int c, List<List<String>> grid){
    if(grid.size() == r || grid.size(0).size() == c){
      return 0;
    }
    if(grid.get(r).get(c) == "X"){
      return 0;
    }

    if(grid.size() - 1 == r && grid.get(0).size() - 1 == c){
      return 1;
    }

    return countPaths(r+1,c,grid) + countPaths(r,c+1,grid);
  }

  public static int countPathsWithMemoization(int r, int c, List<List<String>> grid, HashMap<List<Integer>,Integer>){
    // If r or c is out of bound of the area, return 0
    if(grid.size() == r || grid.get(0).size() == c){
      return 0;
    }
    if(grid.get(r).get(c) == "X"){
      return 0;
    }

    // If r or c is in the area, return 1
    if(grid.size()-1 == r && grid.get(0).size()-1 == c){
      return 1;
    }

    // if the memo contain the key, return the memoized value
    List<Integer> pos = List.of(r,c);
    if(memo.containsKey(pos)){
      return memo.get(pos);
    }

    int result = countPathsWithMemoization(r+1,c,grid,memo) + countPathsWithMemoization(r,c+1,grid,memo);

    memo.put(pos, result);
    return result;
  }

}

```
