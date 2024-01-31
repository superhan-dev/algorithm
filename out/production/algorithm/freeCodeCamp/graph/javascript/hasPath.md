# Loagic

If a vertex has a path to go, return true
otherwise, It will return a false.

there are one graph and two parameters(src, dst) will be given.

and the algorithm will return true, if it can reach the dst value from the src value.

It can be implemented by dfs, also bfs.

# DFS Code

```Javascript
const graph = {
  f: ["g", "i"],
  g: ["h"],
  i: ["k"],
  j: ["i"],
  h: [],
  k: [],
};

const hasPathForDfs = (graph, src, dst) => {
  // if a source have same value with distnation, always return true.
  if (src === dst) return true;

  for (vertex of graph[src]) {
    if (hasPath(graph, vertex, dst)) {
      return true;
    }
  }
  return false;
};

const hasPathForBfs = (graph, src, dst) => {
  // if a source have same value with distnation, always return true.
  const queue = [src];

  while (queue.length > 0) {
    const current = queue.shift();

    if (current === dst) return true;
    for (let neighbor of graph[current]) {
      queue.push(neighbor);
    }
  }

  return false;
};

console.log(hasPathForDfs(graph, "f", "k"));
console.log(hasPathForBfs(graph, "f", "k"));

```

# Link

https://www.youtube.com/watch?v=tWVWeAqZ0WU&t=1567s
