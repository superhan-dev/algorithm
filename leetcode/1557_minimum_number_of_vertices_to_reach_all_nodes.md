# What I have learn
- When traversing a graph, a hashMap can be used for memoize values
  - What values can be memoized with hashMap?
    - When solve the findSmallestSetOfVertices matters, It doesn't need to use graph and dfs or bfs. <br/>
      Sometimes, hashMap can be very useful for the time efficiency. If you use graph with hashmap in this question, 
      use can implement it with O(1)


# Code

```Java
import java.util.*;

class Solution {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<Integer,Integer> incoming = new HashMap<>();
        
        for(List<Integer> edge:edges){
            int source = edge.get(0);
            int destination = edge.get(1);
            incoming.put(destination, source);
        }
        
        for(int i=0;i<n;i++){
            if(!incoming.containsKey(i)) {
                answer.add(incoming.get(i));
            }
        }
        
        return answer;
    }
}

```