const graph = {
  A: ["B", "C"],
  B: ["A", "D"],
  C: ["A", "G", "H", "I"],
  D: ["B", "E", "F"],
  E: ["D"],
  F: ["D"],
  G: ["C"],
  H: ["C"],
  I: ["C", "J"],
  J: ["I"],
};

// const graph = {
//   1: [2, 3, 5],
//   2: [3, 4],
//   3: [4, 5],
//   4: [1, 2],
//   5: [2],
// };

const visited = new Set();
const dfs = (graph, node, visited) => {
  if (visited.has(node)) {
    return;
  }
  visited.add(node);

  console.log(node);

  graph[node].forEach((edge) => {
    if (!visited[node]) {
      dfs(graph, edge, visited);
    }
  });
};

dfs(graph, "A", visited);

console.log(visited);
