# The Logic

The shortest path is the logic for a count of the start to the end nodes.
It also should avoid the cycle between the nodes.

The BFS will be more effient. the effeciency decieded depends on the case.
So, It also can be implemented with DFS.

# The Code

```Javascript
const edges = [
  ["w", "x"],
  ["x", "y"],
  ["z", "y"],
  ["z", "v"],
  ["w", "v"],
];

// the failed case
// const edges = [
//   ["a", "c"],
//   ["a", "b"],
//   ["c", "b"],
//   ["c", "d"],
//   ["b", "d"],
//   ["e", "d"],
//   ["g", "f"],
// ];

const shortestPath = (edges, start, end) => {
  const graph = buildGraph(edges);
  const visited = new Set([start]);

  return exploreShortestPath(graph, start, end, visited);
}

const buildGraph = (edges) => {
  const graph = {};

  for(const [start,end] of edges){
    if(!(start in graph)) graph[start] = [];
    if(!(end in graph)) graph[end] = [];

    graph[start].push(end);
    graph[end].push(start);
  }

  return graph;
}

const exploreShortestPath = (graph, start, end, visited) => {
  const queue = [[start,0]];

  while(queue.length > 0) {
    const [current, distance] = queue.shift();

    if(current === end) return distance;

    for(const neighbor of graph[current]){
      if(!visited.has(neighbor)){
        visited.add(neighbor);
        queue.push([neighbor,distance + 1]);
      }
    }
  }

  return -1;
}

shortestPath(edges, 'w','z');
// the case that can reach from start to end.
// shortestPath(edges, "b", "g");

```
