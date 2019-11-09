import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class DE_Hashing{
  private static MatrixA matrix = new MatrixA();

  // This is the function h(x)
  public static int hash_h(int x){
    int hash=0;
    int[] A = matrix.getMatrix();
    for(int i = 0; i<32;i++){
     hash <<= 1;
     hash |= Integer.bitCount(x & A[i]) % 2; //if even number of ones then OR 0 to hash else OR 1 to hash.
    }
    return hash;
  }

  public static int hash_f(int x, int m){
    int shift = indexFirst1Bit(m)-1;
  //  System.out.println(shift);
    return ((x*0xbc164501) & 0x7fffffff) >> shift;
  }

  // This is phi
  public static int indexFirst1Bit(int h){
  if(h == 0){
    return 0;
  }
   return  Integer.numberOfLeadingZeros(h)+1;//return the index of the first 1
  }
}
