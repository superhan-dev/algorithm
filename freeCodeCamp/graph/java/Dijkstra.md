# Principle of Dijkstra

## Based on BFS

The Dijkstra algorithm is based on BFS.

## The Priority Queue in Java

Dijkstra always use the heap or priority queue.
And The priotiry queue in Java needs an element which is implemented by the Compareable<?> Interface.

In Dijkstra algorithm, we will implement a QueueObject, the Object will have a vertex value, priority integer value and it will implements the Compareable interface.

## Consist with

- Distances Hash Map
- Unvisited List
- Priority Queue
  - QueueObject

# The Loagic

1. get a Graph, and a starting vertex with parameters
   1. parameters
      1. isWeight
      2. isDirectional
2. initialze the distances HashMap, previous HashMap, Priority Queue,
3. loop through the vertices of the graph, and initialize distances and previous vertex of all vertices
4. put the starting vertex into the distances HashMap
5. loop through the queue
   1. take out the current vertex from queue
   2. loop through the edges for the current vertex
      1. calculate the alternative distances
      2. get neighbor's data
      3. if alternative is smaller than neighbor's distance
         1. put the HashMap value(neighbor: alternative).
         2. add the QueueObject of neighbor??

# Questions

- ## What is the previous HashMap for?
- What if it has a cycle?
  - It has a problem.
    - To fix this problem, We need to use a HashSet.

# Code

## Implementation

```Java

class Dijkstra {
   public statis HashMap[] dijkstra(Graph<String> g, Vertex<String> staringVertex){
      HaspMap<String, Integer> distances = new HashMap<>();
      HashMap<String, Vertex<String>> previous = new HashMap<>();

      PriorityQueue<QueueObject> queue = new PriorityQueue<>();

      queue.offer(new QueueObject(startingVertex,0));

      for(Vertex<String> v: g.getVertices()){
         if(v != startingVertex){
            distances.put(v.getData(), Integer.MAX_VALUE);
         }
         previous.put(v.getData(), new Vertex<String>("Null"));
      }

      distances.put(startingVertex.getData(), 0);

      while(!queue.isEmpty()){
         Vertex<String> current = queue.poll().vertex;

         for(Edge<String> e: current.getEdges()){
            Integer alternative = distances.get(current.getData()) + e.getWeight();

            String neighbor = e.getEnd().getData();

            if(alternative < distances.get(neighbor)){
               distances.put(neighbor, alternative);
               previous.put(neighbor, current);

               queue.offer(new QueueObject(e.getEnd(), distances.get(neighbor)));
            }
         }
      }

      return new HashMap[] {distances, previous};
   }


  public static void searchShortestPath(Graph<String> g, Vertex<String> startingVertex, Vertex<String> targetVertex) {
      HaspMap[] dijkstraHashMaps = dijkstra(g,startingVertex);

      HashMap<String, Integer> distances = dijkstraHashMaps[0];
      HashMap<String, Vertex<String>> previous = dijkstraHashMap[1];

      Integer distance = (Integer) distances.get(targetVertex.getData());
      System.out.print("The Shortest Distance between" +startingVertex.getData());
      System.out.println(distance);

      ArrayList<Vertex<String>> path = new ArrayList<>();

      Vertex<String> v = targetVertex;
      while(v.getData() != "Null"){
         path.add(0,v);
         v = (Vertex<String>) previous.get(v.getData());
      }

      System.out.print("Shortest Path: ");
      for(int i=0;i<path.size();i++){
         if(i != path.size() - 1){
            System.out.print(path.getData() + "--> ");
         } else {
            System.out.println(path.getData());
         }
      }
  }
}

class Graph<V> {
   private boolean isWeight
   private boolean isDirectional
   private List<Vertex<V>> vertcies;

   Graph(boolean isWeight, boolean isDirectional){
      this.isWeight = isWeight;
      this.isDirectional = isDirectional;
      this.vertices = new LinkedList<Vertex<V>>();
   }

   public LinkedList<Vertex<V>> getVertices(){
      return vertices;
   }

   public Vertex<V> addVertex(V data){
      Vertex<V> newVertex = new Vertex<>(data);
      vertices.add(newVertex);
      return newVertex;
   }

   public void removeVertex(Vertex<V> vertex){
      return vertices.remove(vertex);
   }

   public void addEdge(Vertex<V> start, Vertex<V> end, Integer weight){
      if(!this.isWeight){
         weight = null;
      }

      start.addEdge(end, weight);

      if(!isDirectional){
        end.addEdge(start, weight);
      }
   }

   public void print(){
      for(Vertex<V> v: vertices){
         v.print(isWeight);
      }
   }
}

class Vertex<V> {
   private Integer data;
   private List<Edge<V>> edges;

   Vertex(V data){
      this.data = data;
      edges = new LinkedList<Edge<V>>();
   }

   public void addEdge(Vertex<V> end, Integer weight){
      edges.add(new Edge<V>(this, end, weight));
   }

   public void removeEdge(Vertex<V> end){
      edges.removeIf(edge -> edge.getEnd().equals(end));
   }

   public V getData() {
      return data;
   }

   public List<Edge<V>> getEdges(){
      return edges;
   }

   public void print(boolean showWeight){
      String message = "";

      for(int i=0; i < edges.size(); i++){
         if(i==0){
            message += edges.get(i).getStart().getData() + " --> ";
         }

         message += edges.get(i).getEnd().getData();

         if(showWeight){
            message += " (" + edges.get(i).getWeight() + ") ";
         }

         if(i != edges.size() -1){
            message += ", "
         }
      }

      System.out.println(message);
   }
}

class Edge<V>{
   private Vertex<V> start;
   private Vertex<V> end;
   private Integer weight;

   Edge(Vertex<V> start, Vertex<end>, Integer weight){
      this.start = start;
      this.end = end;
      this.weight = weight;
   }

   public Veretx<V> getStart(){
      return start;
   }

   public Vertex<V> getEnd(){
      return end;
   }

   public Integer getWeight(){
      return weight;
   }


}

```

## Usage

```Java

import java.util.*;

public class Main{
  public static void main(String[] args){
    Graph<String> testGraph = new Graph<String>(true, false);

    Vertex<String> a = testGraph.addVertex("A");
    Vertex<String> b = testGraph.addVertex("B");
    Vertex<String> c = testGraph.addVertex("C");
    Vertex<String> d = testGraph.addVertex("D");
    Vertex<String> e = testGraph.addVertex("E");
    Vertex<String> f = testGraph.addVertex("F");
    Vertex<String> g = testGraph.addVertex("G");

    testGraph.addEdge(a,c,100);
    testGraph.addEdge(a,b,3);
    testGraph.addEdge(a,d,4);
    testGraph.addEdge(d,c,3);
    testGraph.addEdge(d,e,8);
    testGraph.addEdge(e, f, 10);
    // testGraph.addEdge(e,b,-2);
    testGraph.addEdge(b,g,9);
    // testGraph.addEdge(e,g,-50);

    HashMap[] result = Dijkstra.dijkstra(testGraph, a);

    // Dijkstra.dijkstraResultPrinter(result);
    Dijkstra.shortestPathBetween(testGraph, a,g);

  }
}


```
