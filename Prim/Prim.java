import java.util.*;
import java.io.*;

public class Prim{

  private static Edge[] edgeTo;
  private static int count; //number of vertices connected
  private static boolean[] marked;
  private static MinPQ pq;
  private static Graph G;

  public Prim(int v,int e,Graph g){
    edgeTo = new Edge[v];
    marked = new boolean[v];
    pq = new MinPQ(e);
    count = v;
    G = g;
  }


  private static void visit(int v){

    int w = v;
    long sum = 0;
    while(count-- > 1){
      marked[w] = true;
      List<Edge> adj = G.get(w);
      addToEdgeToAndPQ(adj,w);
      Edge e = findSmallestEdge();
      sum += e.getWeight();
      w = findNextVisit(e);
    }
    System.out.println(sum);
  }

  public static int findNextVisit(Edge e){
    int w = e.V2();
    if(marked[w]){
      w = e.other(w);
    }
   return w;
  }

  public static Edge findSmallestEdge(){
    Edge e = pq.deleteMin();
    while(marked[e.V1()] && marked[e.V2()]){
      e = pq.deleteMin();
    }
    return e;
  }


  private static void addToEdgeToAndPQ(List<Edge> list, int v){
    for(Edge e:list){
      int w = e.other(v);
      if(!marked[w]){
      if(edgeTo[w] == null || e.getWeight() < edgeTo[w].getWeight()){
          edgeTo[w] = e;
          pq.insert(e);
      }
    }
  }
  }

  public static void main(String[] args)throws IOException{

    Reader.init(System.in);
    int v = Reader.nextInt();
    int e = Reader.nextInt();
    Graph G = new Graph(v);

    for(int i = 0; i<e; i++){
    Edge E = new Edge(Reader.nextInt(),Reader.nextInt(),Reader.nextInt());
    G.add(E);
    }
    new Prim(v,e,G);

    visit(0);

  }
}
