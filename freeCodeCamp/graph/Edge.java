package freeCodeCamp.graph;


public class Edge<V> {
  private Vertex<V> start;
  private Vertex<V> end;
  private Integer weight;

  public Edge(Vertex<V> start, Vertex<V> end, Integer weight){
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  public Vertex<V> getStart(){
    return this.start;
  };

  public Vertex<V> getEnd(){
    return this.end;
  }

  public Integer getWeight(){
    return this.weight;
  }

}
