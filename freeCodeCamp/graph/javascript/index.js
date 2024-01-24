const graph = {
  0: [8, 1, 5],
  1: [0],
  5: [0, 8],
  8: [0, 5],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2],
};

const largestComponent = (graph) => {
  // The components is possible to have a cycle.
  // To prohebit loop through the infinity loop, use the visited Set.
  const visited = new Set();

  const source = Object.keys(graph)[0];
  let largestCount = explore(graph, source, visited);

  console.log(largestCount + 1);
};

const explore = (graph, source, visited) => {
  const queue = [source];

  let largestCount = 0;
  while (queue.length > 0) {
    const current = queue.shift();

    if (visited.has(current)) continue;
    let count = 0;
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
