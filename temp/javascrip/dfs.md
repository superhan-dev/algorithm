# DFS

DFS는 깊이 우선탐색으로 그래프 리스트를 탐색하는 문제가 주로 나온다.
그래프 리스트는 다음과 같이 생긴 자료구조이다. 이러한 구조를 탐색하기 위해서 재귀 함수가 사용된다.

노드당 한번씩만 방문할 수 있게 visited 를 사용하며 visited는 set을 사용하는 것이 중복을 방지하기에 좋은 방법일 수 있다.

## Graph List

```javascript
const graph = {
  1: [2, 3, 5],
  2: [3, 4],
  3: [4, 5],
  4: [1, 2],
  5: [2],
};
// or
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
```

## code

```javascript
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
```
