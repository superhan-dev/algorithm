package temp.graph;

import java.util.*;

public class GraphPractice<T> {

  private Map<T, List<T>> adjacencyVerties = new HashMap<>();

  GraphPractice() {
  }

  public Map<T, List<T>> getAdjencyVertiex() {
    return adjacencyVerties;
  }

  public void addVertex(T source) {
    adjacencyVerties.get(source);
  }

  public void addEdge(T source, T destination, boolean isBidirectional) {
    if (adjacencyVerties.get(source) == null) {
      adjacencyVerties.put(source, new LinkedList<>());
    }

    if (adjacencyVerties.get(destination) == null) {
      adjacencyVerties.put(destination, new LinkedList<>());
    }

    adjacencyVerties.get(source).add(destination);

    if (isBidirectional) {
      adjacencyVerties.get(destination).add(source);
    }
  }

}
