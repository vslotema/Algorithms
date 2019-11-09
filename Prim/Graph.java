import java.util.*;
public class Graph{

  private List<Edge>[] adjacent;

  public Graph(int s){
    adjacent = new ArrayList[s];
    for(int i = 0; i < s; i++){
      adjacent[i] = new ArrayList<Edge>();
    }
  }

  public void add(Edge e){
    adjacent[e.V1()].add(e);
    adjacent[e.V2()].add(e);
  }

  public List<Edge> get(int v){
    return adjacent[v];
  }

  public int getSize(){
    return adjacent.length;
  }


}
