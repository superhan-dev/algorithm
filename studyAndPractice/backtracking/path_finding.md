# The input
The given array consisted with 0 or 1.
the number 1 means that is path, 0 means the opposite.

find a path from the start to the end.
It can be solved with the DFS logic with graph.

```text
{ 1 , 0 , 0 , 0 }
{ 1 , 1 , 0 , 0 }
{ 0 , 1 , 0 , 0 }
{ 0 , 1 , 1 , 1 }
```

# The output
The output should be like the text.

```text
{ {0,0},{1,0},{1,1},{2,1},{3,1},{3,2},{3,3} }
```


# Idea
- traversal with nested for loop.
    - row, col
## Function and the params
- the function name
  - solveMaze(Maze,position,N)

## Parameters
- Maze
  - a matrix array for the maze
- position 
  - a int array -> [row,col] 
- N
  - the number of the length of rows and cols 

# code
```java
import java.util.*;
public class Main {
    public static void main(String[] args){
        int[][] maze = {
                { 1 , 0 , 0 , 0 },
                { 1 , 1 , 0 , 0 },
                { 0 , 1 , 0 , 0 },
                { 0 , 1 , 1 , 1 },
        };

        int[] position = {0,0};
        int n = maze.length;

        List<int[]> answer = solveMaze(maze,position,n);
        assert answer != null;
        for(int[] row: answer){
            System.out.println(Arrays.toString(row));
        }


    }

    public static List<int[]> solveMaze(int[][] maze, int[] position, int n){
        int x = position[0];
        int y = position[1];
        
        // the exit condition
        if(x == n-1 && y == n-1){
            List<int[]> last = new ArrayList<>();
            last.add(new int[]{n-1,n-1});
            return last;
        }

        List<int[]> path = new ArrayList<>();
        
        // move down.
        if(x + 1 < n && maze[x+1][y] == 1){
            List<int[]> a = solveMaze(maze,new int[]{x+1,y},n);
            /**
             * If a got a null value from the next down position, 
             * we don't add the position into the path.
             * this is the **backtracking** for this logic.
             */
            if(a!=null){
                path.add(new int[]{x,y});
                path.addAll(a);
                return path;
            }
        }
    
        // move right
        if(y+1 < n && maze[x][y+1] == 1){
            List<int[]> b = solveMaze(maze,new int[]{x,y+1},n);
            /**
             * If a got a null value from the next right position, 
             * we don't add the position into the path.
             * this is the **backtracking** for this logic.
             */
            if(b != null) {
                path.add(new int[]{x,y});
                path.addAll(b);
                return path;
            }
        }
        // If the current value is not valid path,
        // return null to backtrack.
        return null;
    }
}
```
