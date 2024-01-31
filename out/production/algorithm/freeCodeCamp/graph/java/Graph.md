# Graph

The Graph is consisted by a group of vertex and group of edges.

## The attributes of Graph

- vertices
  - Graph has a LinkedList of Vertex. The reason of chice a LinkedList is a Graph need to keep add and reomove vertex in an algorithm and LinkedList has adventage of adding and removing data.
- isWeight
  - This is a flag of a weighted Graph. If it is true, the Edges of the Graph has a weight. It allocate a priority of the path.
- isDirectional
  - If It is true, all edges are allocated each other.

## The methods of Graph

- addVertex
  - The Graph has a responsibility of adding a vertex in the vertices list.
- removeVertex
  - The Graph has a responsibility of removing a vertex fromt the vertieces list.

# Vertex

vertex is a node which has data for the graph and group of edge.

## The attributes of Vertex

- edges
  - the attribute is consisted with a LinkedList
- data
  - The type of Vertex could be stated but I usually implemente the type of Vertex with Generic syntex of Java.

## The methods of Vertex

- getData
- addEdge
  - The vertex object has responsibility of adding an Edge for edges attribute. the starting vertex will be this(instance) and set end vertex for the starting vertex with weight value.
- removeEdge
  - The vertex object has responsibility of removing an edge from edges list.

# Edge

A edge has the pointer of the start vertex and end vertex.
Also It has the weight value for the edge which is representing of the priority.

## The attributes of Edge

- start
  - it is a vertex object which is starting point of this edge
- end
  - it is a vertex object which is ending point of this edge vertex
- weight
  - it allocate priority to compare importance of path of edge.

## The methods of Edge

- getWeight
- getStart
- getEnd

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
