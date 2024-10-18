# BFS

너비 우선 탐색은 깊이를 하나 들어갈때 마다 인접한 노드들을 방문 배열 큐에 넣어 인접한 노드 먼저 탐색할 수 있도록 하는 탐색 방법이다.
인접 노드는 포인터를 통해 가지고 있기도 하고 매트리스를 던저주어 논리적 그래프를 탐색하는 문제가 나오기도 한다.

## 구현 방법

그래프 행렬 구현 방법

1. visited 배열을 만든다.
   1.1. 모든 방문 배열을 false로 채워 매트리스와 같은 모양을 만든다.
2. directionX,Y 선언
   인접 행렬을 탐색하기 위해 x,y 값을 한번씩 이동하면서 방향을 변경해야한다.
   x = [0,1,0,-1]; y = [1,0,-1,0] 을 선언하고 각 index를 기준으로
   [0] = 상, [1] = 좌, [2] = 하, [3] = 우가 되며 4방향을 이동해야하기 때문에 for문을 4번 반복하면 된다.
   현재 위치(x,y)를 기준으로 index에 따라 위에서 설명한 방향으로 이동한다.
   2.1. 탐색 위치는 0(최소값) 보다는 크고 n과 m(최대값) 보다는 작도록 설정해야한다.
3. bfs 시작 - 행렬 길이만큼 m,n을 선언하고 첫번째 위치부터 탐색을 시작한다.
   3.1. queue를 선언하여 현재 위치를 배열로 갖는 값으로 넣는다.
   3.2. while 문을 보통 사용하며 queue가 비어있지 않는다면 순환하면서 4방향을 탐색한다.
   3.2.1. queue에 담긴 vertex 좌표를 꺼낸다.
   3.2.2. 방향이 담긴 배열은 상, 좌, 하, 우 4방향으로 움직인다. 각 방향이 담길 ny,nx 값을 선언한다.
   3.3.3. 위치의 값이 1이고 방문하지 않은 노드라면 visited[ny][nx]를 true로 설정하고 해당 위치를 visited에 넣는다.

## code

```javascript
let map = [
  [1, 1, 0, 1, 1],
  [0, 1, 1, 0, 0],
  [0, 0, 0, 0, 0],
  [1, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
];

const m = map.length;
const n = map[0].length;

// Array fill을 사용하여 문제가 생겨서 이중 포문으로 초기 visited를 만들었다.
// const visited = Array(n).fill(Array(m).fill(false));
// 다음과 같이 Array from을 사용하게되면 배열을 생성할 때 유용하게 사용할 수 있다.
// 하지만 이중 for문이 보다 더 직관적으로 느껴진다.
// const visited = Array.from({ length: n }, () => Array(m).fill(false));
const visited = [];
for (let i = 0; i < map.length; i++) {
  visited.push([]);
  for (let j = 0; j < map[i].length; j++) {
    visited[i].push(false);
  }
}

const directionX = [0, 1, 0, -1]; // 상 좌 하 우
const directionY = [1, 0, -1, 0];

const bfs = (y, x) => {
  visited[y][x] = true;

  const queue = [[y, x]];

  while (queue.length > 0) {
    const [currentY, currentX] = queue.shift();

    for (let d = 0; d < 4; d++) {
      const newY = directionY[d] + currentY;
      const newX = directionX[d] + currentX;
      if (newY > 0 && newY <= m && newX > 0 && newX <= n) {
        if (map[newY][newX] === 1 && !visited[newY][newX]) {
          visited[newY][newX] = true;
          queue.push([newY, newX]);
        }
      }
    }
  }
};

for (let y = 0; y < m; y++) {
  for (let x = 0; x < n; x++) {
    bfs(y, x);
  }
}
```
