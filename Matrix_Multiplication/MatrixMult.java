import java.util.*;
import java.io.*;

public class MatrixMult{

  private static int[][] A;
  private static int[][] C;
  private static int columnA;
  private static int n;

  public MatrixMult(int n){
    A = new int[n][n];
    C = new int[n][n];
  }

  public static void addA() throws IOException{
     for(int i = 0; i<n; i++){
       for(int j = 0; j<n; j++){
         A[i][j] = Reader.nextInt();
       }
     }
  }

  public static void modifyC(int x,int column){
    for(int i = 0; i<n; i++){
      C[i][column] += A[i][columnA] * x;
    }
  }

  public static boolean done(){
    return columnA == n;
  }

  public static void loop() throws IOException{
    int count = 0;
    while(count < n){
     int x =Reader.nextInt();
     modifyC(x,count);
     count++;
    }
  }

  public static void printC(){
    for(int i = 0; i<n;i++){
      for(int j = 0; j<n;j++){
        System.out.print(C[i][j] + " ");
      }
      System.out.println();

    }
  }

  public static void main(String[] args) throws IOException{
    Reader.init( System.in ); // connect Reader to an input stream
    n = Reader.nextInt();
    new MatrixMult(n);

    addA();

    while(!done()){
      loop();
      columnA++;
    }

    printC();




  }
}
