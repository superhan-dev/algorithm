# Required skill
- Recursive
- The Recursive Backtracking 
- DFS traversal

# Learn new things
- The Recursive Backtracking

# Code 

```Java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    /**
     * Input: graph = [[1,2],[3],[3],[]]
     * Output: [[0,1,3],[0,2,3]]
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<List<Integer>> answer = new ArrayList<>();
        return dfs(graph,0,new ArrayList<>(List.of(0)), answer);
    }

    public static List<List<Integer>> dfs(int[][] graph, int vertex, List<Integer> path, List<List<Integer>> answer){
        // The exit condition
        if(vertex == graph.length-1){
            answer.add(new ArrayList<>(path));
            return answer;
        }

        for(int v:graph[vertex]){
            path.add(v);
            answer = dfs(graph,v,path,answer);
            // The backtracking point.
            path.remove(path.size()-1);
        }
        return answer;
    }
}
```