package freeCodeCamp.graph.java;

import java.util.ArrayList;

public class Graph<V> {
  private ArrayList<Vertex<V>> vertices;
  private boolean isWeighted;
  private boolean isDirected;

  public Graph(boolean isWeighted, boolean isDirected){
    this.vertices = new ArrayList<Vertex<V>>();
    this.isWeighted = isWeighted;
    this.isDirected = isDirected;
  }

  public ArrayList<Vertex<V>> getVertices() {
    return this.vertices;
  };

  public Vertex<V> addVertex(V data){
    Vertex<V> vertex = new Vertex<V>(data); 
    vertices.add(vertex);

    return vertex;
  }

  public void removeEdge(Vertex<V> vertex1, Vertex<V> vertex2){
    vertex1.removeEdge(vertex2);
    if(!this.isDirected){
      vertex2.removeEdge(vertex1);
    }
  }

  public void removeVertex(Vertex<V> vertex){
    this.vertices.remove(vertex);
  }

  public void addEdge(Vertex<V> vertex1, Vertex<V> vertex2, Integer weight){
    if(!this.isWeighted){
      weight = null;
    }
    vertex1.addEdge(vertex2, weight);
    if(!this.isDirected){
      vertex2.addEdge(vertex1, weight);
    }
  }

  public boolean isWeighted(){
    return this.isWeighted;
  }

  public boolean isDirected(){
    return this.isDirected;
  }

  public Vertex<V> getVertexByValue(V data){
    for(Vertex<V>  v:this.vertices){
      if(v.getData().equals(data)){
        return v;
      }
    }
    return null;
  }

  public void print(){
    for(Vertex<V> v: this.vertices){
      v.print(true);
    }
  }
}
