package freeCodeCamp.graph.java;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    int n = 5;
    int[][] edges = {{2,3},{3,5},{1,3},{1,5},{3,4}};

    LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

    for(int i=0;i<=n;i++) graph.add(new LinkedList<>());

    for(int[] edge : edges){
      int start = edge[0];
      int end = edge[1];

      graph.get(start).add(end);
      graph.get(end).add(start); // for bidirectional
    }

    boolean[] visited = new boolean[n+1];
    visited[1] = true;
    dfs(graph,1,visited);

 
  }

  public static void dfs(LinkedList<LinkedList<Integer>> graph,int vertex, boolean[] visited){
    System.out.println(vertex);

    for(int neighbor : graph.get(vertex)){
      if(!visited[neighbor]){
        visited[neighbor] = true;
        dfs(graph, neighbor, visited);
      }
    }
  
  }
}