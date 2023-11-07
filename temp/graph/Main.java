package temp.graph;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addEdge(0, 1, true);
    graph.addEdge(0, 4, true);
    graph.addEdge(1, 2, true);
    graph.addEdge(1, 3, true);
    graph.addEdge(1, 4, true);
    graph.addEdge(2, 3, true);
    graph.addEdge(3, 4, true);

    System.out.println("Graph:\n"
        + graph.toString());

    // Gives the no of vertices in the graph.
    graph.getVertexCount();

    // Gives the no of edges in the graph.
    graph.getEdgesCount(true);

    // Tells whether the edge is present or not.
    graph.hasEdge(3, 4);

    // Tells whether vertex is present or not
    graph.hasVertex(5);
  }
}