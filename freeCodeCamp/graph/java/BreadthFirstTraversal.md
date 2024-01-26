# Breadth First Traversal

the BFS

## Why using a Queue with while loop?

The while loop is very useful for conditional loop.
In BFS, We need to stop the loop when the Queue has got empty.

If you use while loop with Queue, you could easily stop the loop. Just empty Queue, it is the only way to stop the while loop.

# Code

```java

public class Main{
  public static void main(String[] args){
    TestGraph testGraph = new TestGraph();

    LinkedList<Vertex<String>> visitedBFS = new LinkedList<>();

    visitedBFS.add(testGraph.getStartingVertex());

    GraphTraverser.breathFirstSearch(testGraph.getStartingVertex(), visitedBFS);
  }
}

class GraphTraverser {
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

```

# Graph codes

write Graph code set for practice

```java

class Graph<V>{
  LinkedList<Vertex<V>> vertices;
  boolean isWeight;
  boolean isDiractional;

  public Graph(boolean isWeight, boolean isDirectional){
    this.vertices = new LinkedList<>();
    this.isWeight = isWeight;
    this.isDirectional = isDirectional;
  }

  public Vertex<V> addVertex(V data) {
    Vertex<V> newVertex = new Vertex<V>(data);
    vertices.add(newVertex);

    return newVertex;
  }

  public void addEdge(Vertex<V>  startVertex, Vertex<V> endVertex, Integer weight){
    if(!isWeight){
      weight = null;
    }
    startVertex.addEdge(endVertex,weight);

    if(!isDirectional) {
      endVertex.addEdge(startVertex,weight);
    }
  }

}

class Vertex<V> {
  V data;
  LinkedList<Edge> edges;

  public Vertex(V data){
    this.data = data;
    this.edges = new LinkedList<Edge<V>>();
  }

  public void addEdge(Vertex<V> endVertex, Integer weight){
    this.edges.add(new Vertex<V>(this), endVertex, weight);
  }

}

class Edge<V>{
  Vertex<V> start;
  Vertex<V> end;
  Integer weight;

  public Edge(Vertex<V> startVertex, Vertex<V> endVertex, Integer weight){
    this.start = startVertex;
    this.end = endVertex;
    this.weight = weight;
  }
}

```
