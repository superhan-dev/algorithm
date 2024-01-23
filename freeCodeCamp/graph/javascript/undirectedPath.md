# undirected path

When the path is undirected, it can have a cycle path.
we are going to how to handle the cycle with undirected path problem.

## The visited object

If it's possible to check the visited vertex, we don't need to visit the vertex again.
Why this is important? If we don't care about visiting a vertex, it might going to be in a trap which is infinity loop.

and the visited object is consisted with key : value pair. key means the vertex, and the value means visited or not which is true or false.

# The Graph and chose a strategy to traversal

The graph will be like the under the code.

## Traversal options

We can traverse vertexs with `dfs` or `bfs`.
What method will be more efficient for this problem?

In this question, I used bfs, because it is more efficient.
When we arrived a vertex, we should check the vertex is visited or not. So, that means we need to check the vertices with breath first search.

### My Answer Code

```Javascript
const edges = [
  ["i", "j"],
  ["k", "i"],
  ["m", "k"],
  ["k", "l"],
  ["o", "n"],
];

const undirectionalPath = (edges, vertexA, vertexB) => {
  const g = buildGraph(edges);
  const visited = {};
  for (const [src, dist] of edges) {
    visited[src] = false;
    visited[dist] = false;
  }

  const answer = bfs(g, vertexA, vertexB, visited);
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

const bfs = (graph, source, destination, visited) => {
  const queue = [source];

  while (queue.length > 0) {
    const current = queue.shift();

    if (current === destination) return true;
    for (const neighbor of graph[current]) {
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        queue.push(neighbor);
      }
    }
  }

  return false;
};

undirectionalPath(edges, "j", "m");

```

## dfs is possible

### What I learn new thing?

- use set.
  - If i use the set, there is no reason to set the visited array. also you can check the visited value easilly.

```Javascript
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
```
