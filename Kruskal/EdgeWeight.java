import java.util.*;

public class EdgeWeight implements Comparable<EdgeWeight> {

  private int vector1;
  private int vector2;
  private long weight;

  public EdgeWeight(int v1, int v2, long w){
    vector1 = v1;
    vector2 = v2;
    weight = w;
  }

  public int V1(){
    return vector1;
  }

  public int V2(){
    return vector2;
  }


  public long getWeight(){
    return weight;
  }

  @Override
  public int compareTo(EdgeWeight o){
    return Long.compare(this.getWeight(),o.getWeight());
  }

}
