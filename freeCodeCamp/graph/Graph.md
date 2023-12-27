# Graph

The Graph is consisted by a group of vertex and group of edges.

## Vertex

vertex is a node which has data for the graph and group of edge.

## Edge

A edge has the pointer of the start vertex and end vertex.
Also It has the weight value for the edge which is representing of the priority.

```java
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

```
