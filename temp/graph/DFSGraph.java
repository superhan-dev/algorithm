package temp.graph;

import java.util.*;

public class DFSGraph {

  private int v;
  private LinkedList<Integer> adj[];

  @SuppressWarnings("unchecked")
  DFSGraph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  void search(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");

    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n]) {
        search(n, visited);
      }
    }
  }

  void DFS(int v) {
    boolean[] visited = new boolean[this.v];

    search(v, visited);
  }

  public static void main(String[] args) {
    DFSGraph dfsGraph = new DFSGraph(4);

    dfsGraph.addEdge(0, 1);
    dfsGraph.addEdge(1, 2);
    dfsGraph.addEdge(1, 3);
    dfsGraph.addEdge(0, 3);

    dfsGraph.addEdge(3, 3);

    System.out.println("Following is Depth First Traversal " +
        "(starting from vertex 2)");

    dfsGraph.DFS(3);

  }
}
