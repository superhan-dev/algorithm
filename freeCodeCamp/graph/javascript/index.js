// const graph = {
//   i: ["j", "k"],
//   j: ["i"],
//   k: ["i", "m", "l"],
//   m: ["k"],
//   l: ["k"],
//   o: ["n"],
//   n: ["o"],
// };

const edges = [
  ["i", "j"],
  ["k", "i"],
  ["m", "k"],
  ["k", "l"],
  ["o", "n"],
];

const undirectionalPath = (edges, vertexA, vertexB) => {
  const g = buildGraph(edges);

  const visited = new Set();

  const answer = dfs(g, vertexA, vertexB, visited);
  console.log(answer);
};

const buildGraph = (edges) => {
  const graph = {};

  for (const [start, end] of edges) {
    if (!(start in graph)) graph[start] = [];
    if (!(end in graph)) graph[end] = [];

    graph[start].push(end);
    graph[end].push(start);
  }

  return graph;
};

const dfs = (graph, source, destination, visited) => {
  if (source === destination) return true;

  if (visited.has(source)) return false;
  visited.add(source);

  for (const neighbor of graph[source]) {
    if (dfs(graph, neighbor, destination, visited)) {
      return true;
    }
  }

  return false;
};

undirectionalPath(edges, "j", "m");
