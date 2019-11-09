import java.io.*;
import java.util.*;

public class SparseOrthogonalVectors{

  private static boolean[][] array;
  private static int row;
  private static int n;
  private static int k;
  private static int s;

  public SparseOrthogonalVectors(int k, int n){
    array = new boolean[k][n+1];
  }

  public static void add(String line){
    StringTokenizer st = new StringTokenizer(line);
    while(st.hasMoreTokens()){
      array[row][Integer.parseInt(st.nextToken())] = true;
    }
    row++;
  }

  public static boolean isFull(){
    return row == k;
  }

  public static int[] createArray(String line){
    int[] farray = new int[s];
    StringTokenizer st = new StringTokenizer(line);
    int i =0;
    while(st.hasMoreTokens()){
      farray[i] = Integer.parseInt(st.nextToken());
      i++;
    }
    return farray;
  }

  public static boolean findOrthogonel(int[] farray){
      for(int i = 0; i<k;i++){
      if(isOrthogonal(farray,i)){
        System.out.println("yes");
        return true;
      }
    }  return false;
    }



  private static boolean isOrthogonal(int[] farray, int row){
    for(int i = 0; i < farray.length; i++){
      if(array[row][farray[i]]){
        return false;
      }
    }return true;
  }



  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

     n = Integer.parseInt(st.nextToken()); //length of index
     k = Integer.parseInt(st.nextToken()); //rows
     s = Integer.parseInt(st.nextToken()); //amount of non-zero indices

     SparseOrthogonalVectors sp = new SparseOrthogonalVectors(k,n);


    int count = 0;
    boolean found = false;

    while(count<=k*2){
      String line = br.readLine();
      if(!line.equals("")){
        if(!isFull()){
          add(line);
        }else{
          int[] farray= createArray(line);
          if(findOrthogonel(farray)){
            found = true;
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
