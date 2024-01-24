# largest component

A group of edges will be a component.
and the component was consisted by 4 of vertices. So, the size of the component was 4.

This algorithm will going to find the largest component between the components in a graph.

# The Codes

## Graph

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
```

## with DFS

```Javascript

const largestComponent = (graph) => {
  // The components is possible to have a cycle.
  // To prohebit loop through the infinity loop, use the visited Set.
  const visited = new Set();

  let largestCount = 0;
  for (const node in graph) {
    let count = explore(graph, node, visited);

    if (largestCount < count) {
      largestCount = count;
    }
  }

  // The function dosen't count myself. So, plus 1 for that.
  console.log(largestCount);
};

const explore = (graph, vertex, visited) => {
  if (visited.has(String(vertex))) return 0;

  // To prohibit  an infinity loop the visited value
  visited.add(String(vertex));
  // If it is not a visited value, increse the size of the component.
  let count = 1;

  for (const neighbor of graph[vertex]) {
    count++;
    // keep exploring to the last node with incresing count.
    explore(graph, neighbor, visited, count);
  }

  return count;
};

largestComponent(graph);
```

## with BFS

```javascript
const largestComponent = (graph) => {
  // The components is possible to have a cycle.
  // To prohebit loop through the infinity loop, use the visited Set.
  const visited = new Set();

  const source = Object.keys(graph)[0];
  let largestCount = explore(graph, source, visited);

  console.log(largestCount);
};

const explore = (graph, source, visited) => {
  const queue = [source];

  let largestCount = 0;
  while (queue.length > 0) {
    const current = queue.shift();

    if (visited.has(current)) continue;
    let count = 1;
    for (const neighbor of graph[current]) {
      if (!visited.has(neighbor)) {
        count++;
        visited.add(neighbor);
        queue.push(neighbor);
      }
    }

    if (largestCount < count) {
      largestCount = count;
    }
  }

  return largestCount;
};

largestComponent(graph);
```
