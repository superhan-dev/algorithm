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

  let count = 0;
  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      explore(grid, row, col, visited) && count++;
    }
  }

  console.log(count);
  return count;
};

const explore = (grid, row, col, visited) => {
  let pos = row + "," + col;

  if (visited.has(pos)) return false;
  visited.add(pos);

  const isInRow = 0 <= row && row < grid.length;
  const isInCol = 0 <= col && col < grid[0].length;

  if (!isInRow || !isInCol) return false;

  if (grid[row][col] === "W") return false;

  explore(grid, row - 1, col, visited); // up
  explore(grid, row + 1, col, visited); // down
  explore(grid, row, col - 1, visited); // right
  explore(grid, row, col + 1, visited); // left

  return true;
};

isLandCount(grid);
