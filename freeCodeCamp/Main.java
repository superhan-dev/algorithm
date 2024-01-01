package freeCodeCamp;

import freeCodeCamp.graph.Graph;
import freeCodeCamp.graph.Vertex;

public class Main {
  public static void main(String[] args) {
    Graph<String> graph = new Graph<>(true,true);

    Vertex<String> vertex1 = graph.addVertex("a");
    Vertex<String> vertex2 = graph.addVertex("b");
    Vertex<String> vertex3 = graph.addVertex("c");

    graph.addEdge(vertex1, vertex2, 3);
    graph.addEdge(vertex2, vertex3, 1);

    graph.print();

  }
}