import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Kruskal{

  private static WeightedQuickUnionUF uf;
  private static MinPQ pq;
  private static long sum;


  public Kruskal(int v,int e){
    uf = new WeightedQuickUnionUF(v);
    pq = new MinPQ(e);
    sum = 0;
  }

  public static void add(int e) throws IOException{
     for(int i = 0; i < e; i++){
      EdgeWeight s = new EdgeWeight(Reader.nextInt(), Reader.nextInt(), Reader.nextInt());
      pq.insert(s);
     }
  }

  public static void calcMST(){
   while(uf.count() > 1){
     EdgeWeight min = pq.deleteMin();
     if(uf.find(min.V1()) != uf.find(min.V2())){
       uf.union(min.V1(),min.V2());
       sum += min.getWeight();
     }
   }
  System.out.println(sum);
 }

  public static void main(String[] args) throws IOException{
    Reader.init( System.in );
    int v = Reader.nextInt();
    int e = Reader.nextInt();

    new Kruskal(v,e);
    add(e);
    calcMST();


  }
}
