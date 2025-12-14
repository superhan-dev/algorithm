const fs = require("fs");
function main() {
  let input = fs.readFileSync(0, "utf-8").trimEnd().split("\n");

  const [n, m] = input[0].split(" ").map(Number);
  const metrics = Array.from({ length: n }, () => []);

  for (let i = 1; i <= n; i++) {
    const row = input[i].split("");
    metrics[i - 1] = row;
  }

  const dist = Array.from({ length: n }, () =>
    Array.from({ length: m }, () => -1)
  );

  const dy = [-1, 1, 0, 0];
  const dx = [0, 0, -1, 1];

  const queue = [[0, 0]];
  dist[0][0] = 1;

  let head = 0;
  while (head < queue.length) {
    const [y, x] = queue[head++];

    for (let d = 0; d < 4; d++) {
      let ny = y + dy[d];
      let nx = x + dx[d];
      let isInRange =
        ny >= 0 &&
        ny < n &&
        nx >= 0 &&
        nx < m &&
        metrics[ny][nx] === "1" &&
        dist[ny][nx] === -1;

      if (isInRange) {
        dist[ny][nx] = dist[y][x] + 1;
        queue.push([ny, nx]);
      }
    }
  }
  console.log(dist[n - 1][m - 1]);
}

main();