package studyAndPractice.graph.java;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    int v=9;
    Graph g = new Graph(v);

    g.addEdge(0,1,4);
    g.addEdge(0,7,8);
    g.addEdge(1,2,8);
    g.addEdge(1,7,11);
    g.addEdge(2,3,7);
    g.addEdge(2,8,2);
    g.addEdge(2,5,2);
    g.addEdge(2,5,4);
    g.addEdge(3,4,9);
    g.addEdge(3,5,14);
    g.addEdge(4,5,10);
    g.addEdge(5,6, 2);
    g.addEdge(6,7,1);
    g.addEdge(6,8,6);
    g.addEdge(7,8,7);

    g.shortestPath(0);
  }
}

class Graph {
  private int data;
  /**
   * int[vertex, weight] = destinations;
   * - it use for implement the destination.
   * - it is consisted by a vertex and weight
   */ 
  private List<int[]>[] adj; 

  Graph(int data){
    this.data = data;
    this.adj = new ArrayList[data];
    for(int i=0;i<data;i++){
      adj[i] = new ArrayList<>();
    }
  }
  // 
  void addEdge(int u, int v, int w){
    adj[u].add(new int[] {v,w});
    adj[v].add(new int[] {u,w});
  }

  // src means is that start node of the path
  // dist means is the destination of the path
  void shortestPath(int src){
    PriorityQueue<QueueObject> pq = new PriorityQueue<>();
    int[] dist = new int[this.data];
    Arrays.fill(dist, Integer.MAX_VALUE); // fill the one row of the array
    pq.add(new QueueObject(src,0)); // making start point

    dist[src] = 0;

    while(!pq.isEmpty()){
      int u = pq.poll().vertex;
      /**
       * Searching for the shortter path with Breath First Search(BFS) alghrithm
       * 
       *  */ 
      for(int[] neighbor : adj[u]){
        int v = neighbor[0]; 
        int weight = neighbor[1];
        /**
         * Compare the shortter path between the current vertex and neighbor 
         * to figure out the shortter path
         * If find the shortter path it swap with previous destination
         *  */ 
        if(dist[v] > dist[u] + weight){
          dist[v] = dist[u] + weight;
          // add a QueueObject for loop the graph continually.
          // to go one more step???
          pq.add(new QueueObject(v,dist[v]));
        }
      }
    }

    for(int i=0;i<this.data;i++){
      System.out.println(i+"\t\t"+dist[i]);
    }
  }
}

class QueueObject implements Comparable<QueueObject>{
  int weight;
  int vertex;

  QueueObject(int v, int w){
    this.vertex = v;
    this.weight = w;
  }

  @Override
  public int compareTo(QueueObject obj){
    return Integer.compare(this.weight, obj.weight);
  }
}