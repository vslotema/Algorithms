import java.io.*;
import java.util.*;


public class SparseOVectors{

  private static List<List<Long>> list = new ArrayList<>();
  private static long i;
  private static long max;

  public SparseOVectors(long k){
    max = k;
  }


  public static void add(List<Long> innerList){
    list.add(innerList);
    i++;
  }

  public static boolean listFull(){
    return  i == max;
  }


  public static void addToList(String line){
    StringTokenizer st = new StringTokenizer(line);
    List<Long> innerList = new ArrayList<>();
    while(st.hasMoreTokens()){
      innerList.add(Long.parseLong(st.nextToken()));
    }
    add(innerList);
  }

  public static boolean findOrthogonel(List<Long> inner){

    for(List<Long> l : list){
      if(isOrthogonal(l,inner)){
        return true;
      }
    }return false;
  }


  private static boolean isOrthogonal(List<Long> list, List<Long> inner){

    for(Long x:inner){
      if(list.contains(x)){
        return false;
      }
    }return true;
  }

  public static List<Long> createList(String line){
    List<Long> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(line);
    while(st.hasMoreTokens()){
      list.add(Long.parseLong(st.nextToken()));
    }
    return list;
  }

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken()); //length of indices
    long k = Long.parseLong(st.nextToken()); //lines per list
    long s = Long.parseLong(st.nextToken()); //amount of non-zero indices

    boolean found = false;
    new SparseOVectors(k);

    int count = 0;
    while(count <= 2*k){
      String line = br.readLine();
    
      if(!line.equals("")){

        if(!listFull()){
          addToList(line);

        }else{
          List<Long> flist = createList(line);
          found = findOrthogonel(flist);
          if(found){
            System.out.println("yes");
            break;
          }
        }
      }
      count++;

    }

    if(!found){
      System.out.println("no");
    }
  }
}
