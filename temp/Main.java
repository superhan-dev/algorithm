package temp;

import java.util.*;
import java.util.Queue;

public class Main{
  public static void main(String[] args){
    TestGraph testGraph = new TestGraph();
    
    LinkedList<Vertex<String>> visitedDFS = new LinkedList<>();    
    LinkedList<Vertex<String>> visitedBFS = new LinkedList<>();

    visitedDFS.add(testGraph.getStartingVertex());   
    visitedBFS.add(testGraph.getStartingVertex());


    GraphTraverser.depthFirstSearch(testGraph.getStartingVertex(),visitedDFS);
    System.out.println();
    GraphTraverser.breathFirstSearch(testGraph.getStartingVertex(), visitedBFS);

  }
}

class Graph<V>{
  private boolean isWeight;
  private boolean isDirectional;
 
  private ArrayList<Vertex<V>> vertices;

  Graph(boolean isWeight, boolean isDirectional){
    this.isWeight = isWeight;
    this.isDirectional = isDirectional;
    this.vertices = new ArrayList<Vertex<V>>();
  }

  public ArrayList<Vertex<V>> getVertices() {
    return this.vertices;
  }

  public Vertex<V> addVertex(V data){
    Vertex<V> newVertex = new Vertex<V>(data);
  
    vertices.add(newVertex);
    return newVertex;
  }

  public void removeVertex(Vertex<V> vertex){
    this.vertices.remove(vertex);
  }

  public Vertex<V> getVertexByValue(V value) {
    for(Vertex<V> v: this.vertices){
      if(v.getData() == value){
        return v;
      }
    }

    return null;
  }

  public void addEdge(Vertex<V> start, Vertex<V> end, Integer weight){
    if(!this.isWeight){
      weight = null;
    }

    start.addEdge(end,weight);
    if(!this.isDirectional){
      end.addEdge(start,weight);
    }
  }

  public void print(){
    for(Vertex<V> v: this.vertices){
      v.print(isWeight);
    }
  }
 
}

class Edge<V>{
  private Vertex<V> start;
  private Vertex<V> end;
  private Integer weight;
  
  Edge(Vertex<V> start, Vertex<V> end, Integer weight){
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  public Vertex<V> getStart(){
    return this.start;
  }
  public Vertex<V> getEnd(){
    return this.end;
  }
  public Integer getWeight(){
    return this.weight;
  }
}


class Vertex<V> {
  private V data;
  private ArrayList<Edge<V>> edges;
  
  Vertex(V data){
    this.data = data;
    edges = new ArrayList<Edge<V>>();
  }

  public V getData() {
    return data;
  }

  public ArrayList<Edge<V>> getEdges(){
    return this.edges;
  }

  public void addEdge(Vertex<V> endVertex, Integer weight){
    this.edges.add(new Edge<V>(this, endVertex, weight));
  }

  public void removeEdge(Vertex<V> endVertex){
    this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
  }

   public void print(boolean showWeight){
    String message = "";

    if(this.edges.size() == 0){
      System.out.println(this.data + " -->");
      return;   
    }

    for(int i=0;i<this.edges.size();i++){
      if(i==0){
        message += this.edges.get(i).getStart().data + " --> ";
      } 
      message += this.edges.get(i).getEnd().data;

      if(showWeight){
        message += " (" + this.edges.get(i).getWeight() + ") ";
      }

      if(i != this.edges.size() - 1){
        message += ", ";
      }
    }

    System.out.println(message);
  }
}

class GraphTraverser {
  public static void depthFirstSearch(Vertex<String> start, LinkedList<Vertex<String>> visited){
    System.out.println(start.getData());

    for(Edge<String> edge:start.getEdges()){
      Vertex<String> neighborEdge = edge.getEnd();
      if(!visited.contains(neighborEdge)){
        visited.add(neighborEdge);

        depthFirstSearch(neighborEdge, visited);
      }
    }
  }

  public static void breathFirstSearch(Vertex<String> start, LinkedList<Vertex<String>> visited){
    Queue<Vertex<String>> visitedQueue = new LinkedList<Vertex<String>>();
    visitedQueue.offer(start);

    while(!visitedQueue.isEmpty()){
      Vertex<String> current = visitedQueue.poll();
      System.out.println(current.getData());

      for(Edge<String> e: current.getEdges()){
         Vertex<String> neighbor = e.getEnd();
        if(!visited.contains(neighbor)){
          visited.add(neighbor);
          visitedQueue.offer(neighbor);
        }    
      }
    }
  }
}

class TestGraph{
  private Graph<String> testGraph;

  public TestGraph(){
    this.testGraph = new Graph<String>(false, true);

    Vertex<String> startNode = testGraph.addVertex("v0.0.0");
    Vertex<String> v1 = testGraph.addVertex("v1.0.0");
    Vertex<String> v2 = testGraph.addVertex("v2.0.0");

    Vertex<String> v11 = testGraph.addVertex("v1.1.0");
    Vertex<String> v12 = testGraph.addVertex("v1.2.0");
    Vertex<String> v21 = testGraph.addVertex("v2.1.0");

    Vertex<String> v111 = testGraph.addVertex("v1.1.1");
    Vertex<String> v112 = testGraph.addVertex("v1.1.2");
    Vertex<String> v121 = testGraph.addVertex("v1.2.1");
    Vertex<String> v211 = testGraph.addVertex("v2.1.1");

    this.testGraph.addEdge(startNode,v1,null);
    this.testGraph.addEdge(startNode,v2, null);

    this.testGraph.addEdge(v1,v11, null);
    this.testGraph.addEdge(v2,v12, null);
    this.testGraph.addEdge(v2,v21, null);

    this.testGraph.addEdge(v11,v111, null);
    this.testGraph.addEdge(v11,v112, null);
    this.testGraph.addEdge(v12,v121,null);

    this.testGraph.addEdge(v21,v211,null);

    // cycle
    this.testGraph.addEdge(v211, v2, null);
  }

  public Vertex<String> getStartingVertex(){
    return this.testGraph.getVertices().get(0);
  }

  public Graph<String> getGraph(){
    return this.testGraph;
  } 
}
