package temp;

import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/118669
public class Main{
  public static void main(String[] args){
  
    int N = 5;
    int K = 3;
    int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

    // int N = 6;
    // int K = 4;
    // int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};

    solution(N, road, K);
  }
  // dijkstra
  public static int solution(int N, int[][] road, int K){

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

  public static int dijkstra(List<List<int[]>> graph, int N, int K){
    Queue<int[]> queue = new LinkedList<>();
    int[] distances = new int[N+1];

    Arrays.fill(distances,Integer.MAX_VALUE);
    int start = 1;
    queue.offer(new int[]{1,0});
    distances[start] = 0; 

    while(!queue.isEmpty()){
      int[] current = queue.poll();
      int currentVertex = current[0];
      int currentWeight = current[1];
      
      if(currentWeight > distances[currentVertex]) continue;

      for(int i=0;i<graph.get(currentVertex).size();i++){
        int[] neighbor = graph.get(currentVertex).get(i);
        int neighborVertex = neighbor[0];
        int neighborWeight = neighbor[1];

        int dis = distances[currentVertex] + neighborWeight;
     
        if(distances[neighborVertex] > dis){
          distances[neighborVertex] = dis;
          queue.offer(new int[]{neighborVertex,neighborWeight});
        }
      }
    }

    int count = 0;
    for(int dist: distances){
      if(dist <= K) count++;
    }

    return count;
  }

}
