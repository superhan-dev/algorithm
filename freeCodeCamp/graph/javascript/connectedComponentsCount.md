# connected components count

```Javascript
const graph = {
  0: [8, 1, 5],
  1: [0],
  5: [0, 8],
  8: [0, 5],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2],
};

const connectedComponentsCount = (graph) => {
  const visited = new Set();

  const count = 0;
  // When iterating the keys, use "in" for the for loop.
  for (const vertex in graph) {
    explore(graph, vertex, visited) && count++;
  }

  console.log(count);
  return count;
};

/**
 * If the explore function return true, it means the exploring meat the end of vertex from the start.
 * So, in this case, count up.
 *
 * This function use the dfs based. The reson that was taking dfs,
 * we should figure out the possiblity to reaching the last node from the start.
 */
const explore = (graph, vertex, visited) => {
  if (visited.has(String(vertex))) return false;

  visited.add(String(vertex));

  for (const neighbor of graph[vertex]) {
    explore(graph, neighbor, visited);
  }

  return true;
};


```

# What I have learn

- use "in" for to take the keys from an object.
-
