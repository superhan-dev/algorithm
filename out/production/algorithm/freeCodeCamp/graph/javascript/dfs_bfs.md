# Graph Code

```Javascript

const graph = {
  a: ["b", "c"],
  b: ["d"],
  c: ["e"],
  d: ["f"],
  e: [],
  f: [],
};


```

# DFS's Code

```Javascript

const depthFirstSearch = (graph, source) => {
  console.log(soruce);

  for (edge of graph[source]) {
    depthFirstSearch(graph, edge);
  }
}

depthFirstSearch(garph, 'a');

```

# BFS Code

```Javascript

const breathFirstSearch = (graph,source) => {
  const queue = [source];

  while(queue.length > 0){
    const current = queue.shift();

    console.log(current);
    for(const neighbor of graph[current]) {
      queue.push(neighbor);
    }
  }
}

depthFirstSearch(breathFirstSearch, 'a');


```
