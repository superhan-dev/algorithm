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
