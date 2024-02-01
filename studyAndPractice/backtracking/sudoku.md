# The sudoku problem with backtracking

## The Rule
- all value will be filled by 1,2 or 3.
- each row should have not distinct numbers
- each col should have distinct patterns
- change the number of a cell 
  - check all rows and cols of the board, if the number can use or not.


## The Input
```text
Board = [ [ 0 , 0 , 0 ],
        [ 1 , 0 , 0 ],
        [ 0 , 3 , 1 ] ]
solve( Board , 9 - 3 )


```

## The output
```text
[3, 1, 2]
[1, 2, 3]
[2, 3, 1]

```

## Function
```text
solve(board, emptyNumber);
isDistinct(list);
isValid(board);
```
- solve(board,emptyNum)
  - board
    - sudoku board with numbers, It can be filled or not.
  - emptyNum 
    - it is indicated how many cells filled before start.
- isDistinct(list)
  - list
    - a row value it is a pattern of the board.
    - all value in the list shouldn't be duplicated
- isValid(board)
  - board
    - it has a matrix
      - row should have distinct numbers.
      - col should have distinct patterns.

- recursive conditions
  - base case
    - if the board is valid, return true.
  - loop through the board

## Code
```java
class Main{
    public static void main(String[] args){
        int[][] board = {
            {0,0,0},
            {1,0,0},
            {0,3,1}
        };
        
        if(!solve(board,9-3)){
            return;
        }
        
        for(int[] row : board){
          System.out.println(Arrays.toString(row));    
        }
    }

    public static boolean solve(int[][] board, int emptyCount){
        if(emptyCount == 0) return isValid(board);
        
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                int cell = board[row][col];
                if(cell != 0) continue;
                for(int test=1;test<=3;test++){
                    board[row][col] = test;
                    if(isValid(board) && solve(board,emptyCount-1)){
                        return true;
                    }
                    // backtracking
                    board[row][col] = 0;
                }
          }
        }
        
        return false;              
    }
    
    public static boolean isValid(int[][] board){
        for(int i=0;i<3;i++){
            if(isDistinct(board[i])) return false;
            int[] col = {board[0][i],board[1][i],board[2][i]};
            if(isDistinct(col)) return false;
        }
        
        return true;
    }
    
    public static boolean isDistinct(int[] arr){
        List<Integer> used = new ArrayList<>();
        
        for(int i:arr){
            if(i == 0) continue;
            if(used.contains(i)) return true;
            used.add(i);
        }
        return false;
    }
}


```

