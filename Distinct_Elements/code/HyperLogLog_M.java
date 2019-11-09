import java.io.*;
import java.lang.Math;
import java.util.Scanner;
import java.io.File;

public class HyperLogLog_M{


 private  int V = 0;
 private  double Z = 0;
 private  int m;
 private  int[] M;
 private  File input;
 private  Scanner sc;

 public HyperLogLog_M (int m_size, File file) throws Exception {
   m = m_size;
   M = new int[m];
//   input = file;
   sc = new Scanner(file);
 }


public void ex2 () {
  int[] list = new int[32];
  while(sc.hasNextInt()){
    int nextInt = sc.nextInt();
    list[DE_Hashing.indexFirst1Bit(DE_Hashing.hash_h(nextInt))-1]++;
  }
  System.out.println("leadingZeroes,distribution");
  for(int i = 0; i < list.length ; i++) {
    System.out.println(i + "," + list[i]);
  }
}


 public double addFileAndGetE() {
   while (sc.hasNextInt()) {

     add(sc.nextInt());
   }
    double E = getEstimation();
   return E;

 }


 private  void add(int x){
  int bucket = DE_Hashing.hash_f(x,m); //use hash f function to determine bucket number
  int max = DE_Hashing.indexFirst1Bit(DE_Hashing.hash_h(x));//use hash_h to create an hash object, then determine
                                            //where the index of the first 1 bit occurs, reading from left to right

  M[bucket] = Math.max(M[bucket],max);
  }


  public  double getEstimation(){

    calcVandZ();
    //System.out.println("V == " + V);
  //  System.out.println("Z " + Z);
    double E = (m*m*Z*0.7213)/(1+1.079/m);
  //  System.out.println("E before " + E);
    if(E < 2.5*m && V > 0){
    E = m * (Math.log(m) - Math.log(V));
//    System.out.println("E after " + E);
    }
    return E;
}


  private  void calcVandZ(){

    for(int i = 0; i<m; i++){
      Z += Math.pow(2,-M[i]);
      if(M[i] == 0){
        V++;
      }
    }
   Z=1/Z;
  }



/* public static void main(String[] args) throws IOException{

  //for codejudge
  /*
  int treshHold = Integer.parseInt(sc.nextLine());

  if(E>=treshHold){
    System.out.println("above");
  }else{
      System.out.println("below");
  }


  //get estimate

  while(sc.hasNextInt()){
    add(sc.nextInt());
    }

  double E = getEstimation();

  //Printing data for histogram plotting
  //System.out.println("m;estimate");
  System.out.println(m + ";" + E);




  //Checking shift positon
  /*
  int shift =  DE_Hashing.indexFirst1Bit(m)-1;
  System.out.println("m = "+ m + " shift = >>" + shift);
  */
  /// For plotting distribution
/*




}*/



}
// Exercise 3 sol - 973089.2722159306 which is pretty near a million
