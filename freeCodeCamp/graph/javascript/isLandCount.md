# The loagic

The question need to implement explring grid and find lands.
It has requied understanding dfs and recursion.

## how implement the recursion algorithm.

I found the most important things in recursion algorithm that is set conditional exits to finish the function.
other wise I'm going to be trapped in infinity loop.

# Code

```Javascript
const grid = [
  ["W", "L", "W", "W", "W"],
  ["W", "L", "W", "W", "W"],
  ["W", "W", "W", "L", "W"],
  ["W", "W", "L", "L", "W"],
  ["L", "W", "W", "L", "L"],
  ["L", "L", "W", "W", "W"],
];

const isLandCount = (grid) => {
  const visited = new Set();
  const count = 0;

  for(let row=0; row < grid.length; row++){
    for(let col=0; col<grid[0].length; col++){
      explore(grid,row,col,visited) && count++;
    }
  }

  return count;
}

const explore = (grid,row,col,visited) => {
  let pos = row + ',' + col;

  // Cheking If It already been visited
  if(visited.has(pos)) return false;

  const isInRow = 0 <= row && row < grid.length;
  const isInCol = 0 <= col && col < grid[0].length;

  // Checking if It is in the boundary
  if(!isInRow || !isInCol) return false;
  // Checking if It is not in water
  if(grid[row][col] === 'W') return false;

  // put the pos into visited after conditional check
  visited.add(pos);

  // explore the grid with dfs
  explore(grid,row+1,col,visited);
  explore(grid,row-1,col,visited);
  explore(grid,row,col+1,visited);
  explore(grid,row,col-1,visited);

  return true;
}

isLandCount(grid);

```
