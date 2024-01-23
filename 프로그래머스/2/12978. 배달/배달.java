import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new LinkedList<>();
        
        for(int i=0;i<=N;i++) graph.add(new LinkedList<>());
        
        for(int[] edge : road){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            graph.get(start).add(new int[]{end,weight});
            graph.get(end).add(new int[]{start,weight});
        }
        
        int answer = dijkstra(graph,N,K);
        
        return answer;
    }
    
    public static int dijkstra(List<List<int[]>> graph, int N, int K) {
        Queue<int[]> queue = new LinkedList<>();
        
        int[] distances = new int[N+1];
        Arrays.fill(distances,Integer.MAX_VALUE);
        
        int start = 1;
        int selfWeight = 0;
        queue.offer(new int[]{start,selfWeight});
        distances[start] = selfWeight;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentVertex = current[0];
            int currentWeight = current[1];
            
            /**
             * NOTE: this code was the wrong point
             */
            if(currentWeight > distances[currentVertex]) continue;
            
            for(int i=0;i<graph.get(currentVertex).size();i++){
                int neighbor = graph.get(currentVertex).get(i)[0];
                int weight = graph.get(currentVertex).get(i)[1];
                
                int dist = distances[currentVertex] + weight;
                
                if(distances[neighbor] > dist){
                    distances[neighbor] = dist;
                    queue.offer(new int[]{neighbor,weight});
                }
            }
        }
        
        int count = 0;
        for(int distance:distances){
            if(distance <= K) count++;
        }
        
        
        return count;
    }
}