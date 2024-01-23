package freeCodeCamp.graph.java;
import java.util.ArrayList;

public class Vertex<V> {
  private V data;
  private ArrayList<Edge<V>> edges;

  public Vertex(V data){
    this.data = data;
    this.edges = new ArrayList<>();
  }

  public void addEdge(Vertex<V> endVertex, Integer weight){
    this.edges.add(new Edge<V>(this, endVertex, weight));
  }

  public void removeEdge(Vertex<V> endVertex){
    // Question: why remove only end edges?
    this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
  }

  public V getData(){
    return this.data;
  }

  public ArrayList<Edge<V>> getEdges(){
    return this.edges;
  }

  public void print(boolean showWeight){
    String message = "";

    if(this.edges.size() == 0){
      System.out.println(this.data + "-->");
      return;
    }

    for(int i=0;i<this.edges.size();i++){
      if(i==0){
        message += this.edges.get(i).getStart().data + "-->";
      }

      message += this.getEdges().get(i).getEnd().data;

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
