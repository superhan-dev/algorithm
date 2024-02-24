# The Logic

When traversal a grid, the reclusive function will be very helpful.
while the reclusive the important thing is the exit condition of the function.
otherwise, we can not avoid the infinity loop.

## The exit condition of the reclusive function

- size of rows, and cols of the grid
- If the current position is the "L" or other condition
- If the current is visited.
  - Use the visited set or map to figure out whether the current node has been visited or not.

## Use the `nested for loop` to find a position

For the grid, usually realize a position with row, col.
It is similar to a coordinate system. The first location of the grid will be `(0,0)`.
Therefore, we need to use the `nested for loop`.

## Visited Set to memorization

The memorization can boost our algorithm To be more effective.
The `visited set` memorizes the visited path with `0,0` format.
It will help the function to avoid visiting the same position.

# Code

```Javascript
const grid = [
  ["W", "L", "W", "L", "W"],
  ["L", "L", "W", "L", "W"],
  ["W", "L", "W", "W", "W"],
  ["W", "W", "L", "L", "W"],
  ["W", "W", "L", "L", "W"],
  ["W", "W", "L", "W", "W"],
];

const minimumIsLand = (grid) => {
  const visited = new Set();
  let minSize = Infinity;

  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      let size = exploreSize(grid, row, col, visited);
      if (minSize > size) {
        minSize = size;
      }
    }
  }

  return minSize;
};

const exploreSize = (grid, row, col, visited) => {
  const pos = row + "," + col;

  if (visited.has(pos)) return 0;

  const isInRow = 0 <= row && row < grid.length;
  const isInCol = 0 <= col && col < grid[0].length;

  if (!isInRow || !isInCol) return 0;

  if (grid[row][col] === "W") return 0;

  visited.add(pos);

  let size = 1;
  size += exploreSize(grid, row + 1, col, visited);
  size += exploreSize(grid, row - 1, col, visited);
  size += exploreSize(grid, row, col + 1, visited);
  size += exploreSize(grid, row, col - 1, visited);

  return size;
};

minimumIsLand(grid); // 2


```
