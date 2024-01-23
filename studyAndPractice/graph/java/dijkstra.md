# Dijkstra with out the Graph Object

The searching can be implemented by without Graph.
And It is little bit more abstical than the implentation with objects(Graph,Vertex, and Edge).

But It has same principle.

# Code

## the implementation

```Java
class Graph {
  int data;
  // the int[] is the edges
  List<int[]>[] adj;

  Graph(int data){
    this.data = data;
    this adj = new ArrayList[data];
    for(int i=0;i<data;i++){
      adj[i] = new ArrayList<>();
    }
  }

  void addEdge(int u, int v, int w){
    adj[u].add(new int[] {v,w});
    adj[v].add(new int[] {u,w});
  }

  void shortestPath(int source){
    PriorityQueue<QueueObject> pq = new PriorityQueue<>();
    int[] distance = new int[this.data];
    Arrays.fill(distance, Integer.MAX_VALUE);
    pq.add(new QueueObject(source,0));

    distance[source] = 0;

    while(!pq.isEmpty()){
      int u = pq.poll().vertex; // the index of a vertex

      /**
       * Loop through the neighbor edges
       */
      for(int[] neighborEdge : adj[u]){
        int v = neighborEdge[0]; // the vertex
        int weight = neighborEdge[1];

        // Check that if it is shorter or not.
        boolean isShorter = distance[v] > distance[u] + weight;
         /**
         *  If the neighbor's distance are shorter than current distance,
         *  swap with current destination.
         *  And add the shorter vapllue into the queue to go to
         */
        if(isShorter) {
          distance[v] = distance[u] + weight;
          pq.add(new QueueObject(v,dist[v]));
        }
      }
    }

    // print the shorttest value.
    for(int i=0;i<this.data;i++){
      System.out.println(i+"\t\t"+dist[i]);
    }
  }
}

class QueueObject implements Comparable<QueueObject> {
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

```

## Usage of the implementation

```Java

public class Main {
  public static void main(String[] args) {
    int v=9;
    Graph g = new Graph(v);

    g.addEdge(0,1,4); g.addEdge(0,7,8);
    g.addEdge(1,2,8); g.addEdge(1,7,11);
    g.addEdge(2,3,7); g.addEdge(2,8,2); g.addEdge(2,5,2); g.addEdge(2,5,4);
    g.addEdge(3,4,9); g.addEdge(3,5,14);
    g.addEdge(4,5,10);
    g.addEdge(5,6, 2);
    g.addEdge(6,7,1); g.addEdge(6,8,6);
    g.addEdge(7,8,7);

    g.shortestPath(0);
  }
}

```
