# Depth First Traversal

DFS is a searching method of the graph.
graph is consisted with verteices and edges which are connected each other by pointers to alocate the address of a vertex.

It needs a stack and visited list elements
In Java, the visited list will be implemented by the LinkedList.

## Why the LinkedList?

The reason of choose the LinkedList is the efficiency of insert and delete. When insert or delete a value into LinkedList, It just swap a pointer of the value. But if use the ArrayList, you need to rerange all value's address.

Also, When searching a vlue in visited vertices list always reference by value.
Therefore, the LinkedList's weekness will be covered. So, using the LinkedList will be a good chice for the DFS.

## Why the recursive call?

In the DFS algorithm, It needs a recursive call after visiting a Vertex, because the recursive call is very useful to implement traversal of the depth. It has the call stack physically pops and calls the function at the same time.
Also, It helps the codes become shorter than writing normal iterating with the loop

# Code

```java

public class Main{
  public static void main(String[] args){
    TestGraph testGraph = new TestGraph();

    LinkedList<Vertex<String>> visitedDFS = new LinkedList<>();

    visitedDFS.add(testGraph.getStartingVertex());

    GraphTraverser.depthFirstSearch(testGraph.getStartingVertex(),visitedDFS);
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
