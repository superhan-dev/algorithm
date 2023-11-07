package temp.graph;

import java.util.*;

public class Graph<T> {

  private Map<T, List<T>> adjacencyVerties = new HashMap<>();

  Graph() {
  }

  Graph(Map<T, List<T>> adjacencyVerties) {
    this.adjacencyVerties = adjacencyVerties;
  }

  public void addVertex(T source) {
    adjacencyVerties.put(source, new LinkedList<T>());
  }

  public void removeVertex(String label) {
    Vertex vertex = new Vertex(label);
    adjacencyVerties.values().stream().forEach(element -> element.remove(vertex));
    adjacencyVerties.remove(vertex);
  }

  public void addEdge(T source, T destination, boolean isBidirectional) {
    if (!adjacencyVerties.containsKey(source))
      addVertex(source);
    if (!adjacencyVerties.containsKey(destination))
      addVertex(destination);

    adjacencyVerties.get(source).add(destination);
    if (isBidirectional) {
      adjacencyVerties.get(destination).add(source);
    }
  }

  public void getVertexCount() {
    System.out.println("The graph has " + adjacencyVerties.size() + " vertex");
  }

  public void getEdgesCount(boolean isBidirection) {
    int count = 0;
    for (T v : adjacencyVerties.keySet()) {
      count += adjacencyVerties.get(v).size();
    }

    if (isBidirection) {
      count = count / 2;
    }

    System.out.println("The graph has " + count + " edges.");
  }

  public void hasVertex(T source) {
    if (adjacencyVerties.containsKey(source)) {
      System.out.println("The graph contains " + source + " as a vertex.");
    }
  }

  public void hasEdge(T source, T destination) {
    if (adjacencyVerties.get(source).contains(destination)) {
      System.out.println("The graph has an edge between " + source + " and " + destination);
    } else {
      System.out.println("The graph has no edge between " + source + " and " + destination);
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (T vertex : adjacencyVerties.keySet()) {
      builder.append(vertex.toString() + ": ");
      for (T w : adjacencyVerties.get(vertex)) {
        builder.append(w.toString() + " ");
      }
      builder.append("\n");
    }

    return builder.toString();
  }

  // public void removeEdge(String label1, String label2) {
  // Vertex vertex1 = new Vertex(label1);
  // Vertex vertex2 = new Vertex(label2);

  // List<Vertex> edgeVertex1 = adjacencyVerties.get(vertex1);
  // List<Vertex> edgeVertex2 = adjacencyVerties.get(vertex2);
  // if (edgeVertex1 != null) {
  // edgeVertex1.remove(vertex2);
  // }
  // if (edgeVertex2 != null) {
  // edgeVertex2.remove(vertex1);
  // }
  // }

}
