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
