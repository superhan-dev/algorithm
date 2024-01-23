# code

```Java
import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java
/**
 * Read Question
 * vertex is a number
 *
 * Question
 * - when use the priority queue
 *  - why use the priority queue?
      - If the gragh has weight of edges, the priority queue is required.
        But in this question, the graph has not weight for every each edges.
        So, just use a queue.
 * - how can I get the counter of edges?
 *  - set up the max count of the edges.
 *    - when we meet the max count, during iterating the edges add a count.
 *    - when we meet the bigger count than max count, change the max count and count again fron 1.
 */
public class Main{
  public static void main(String[] args){

    int[][] edges = {
      {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
    };
    int n = 6;

    solution(n, edges);
  }
  // dijkstra
  public static int solution(int n, int[][] edges){
    // init graph
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // graph edge
    for(int i=0;i <= n;i++) graph.add(new ArrayList<>());

    /**
     * Init edges
     * It is bidirectional.
     * Every each node has the {start, end} value, and we need to connect each other.
     *
     * The result that after loop all through this loop.
     * 0: {}
     * 1: {3,2}
     * 2: {3,1,4,5}
     * 3: {6,4,2,1}
     * 4: {3,2}
     * 5: {2}
     * 6: {3}
     * */
    for(int[] i: edges){
      int start = i[0]; // start means the source vertex
      int end = i[1]; // end means the destination vertex
      graph.get(start).add(end);
      graph.get(end).add(start);
    }

    // We need to visit all edges for once.
    // Why n + 1?
    boolean[] visit = new boolean[n+1];

    int answer = bfs(graph, n, visit);
    System.out.println(answer);

    return answer;

  }

  public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visit){
    int answer = 0;

    /**
     * Generate the queue
     * this Queue dose not need to be a priority queue,
     * because the priority of visiting is not important for this question.
     * */
    Queue<int[]> queue = new LinkedList<>();

    // the question wants to start from the vertex 1
    int startVertex = 1;
    // add the first vertex. the vertex has the value of {vertex, depth}
    queue.add(new int[] {startVertex,0});
    // visit true for the first value
    visit[startVertex] = true;
    // set maxDepth counter
    int maxDepth = 0;
    // loop through the queue
    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      int vertex = current[0];
      int depth = current[1];

      /**
       * Compare the depth with the maxDepth.
       *
       * If the depth is bigger than the maxDepth,
       * change the maxDepth to current depth, and set the answer with 1.
       *
       * Bcause we need to find the count of depth,
       * therefore we don't need to keep the smaller value.
       *  */
      if(maxDepth == depth){
        answer++;
      } else if(maxDepth < depth){
        maxDepth = depth;
        answer = 1;
      }

      // this loop helps visiting all the neighbor edges for the current vertex.
      for(int i=0;i<graph.get(vertex).size();i++){
        // get the neighbor value graph.get(v).get(i) will be the neighbor
        int neighbor = graph.get(vertex).get(i);

        /**
         * We need to visit all the neighbor vertex for just once.
         * So, check the value of visiting a vertex.
         *  */
        if(!visit[neighbor]){
          /**
           * as soon as visiting the value,
           * add the vertex to go forward one more depth
           *  */
          queue.add(new int[]{neighbor, depth + 1});
          // add the index of the neighbor vertex f
          visit[neighbor] = true;
        }
      }
    }

    return answer;
  }
}
```
