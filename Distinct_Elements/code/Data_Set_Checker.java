import java.util.Scanner;
import java.util.HashSet;

public class Data_Set_Checker {

  private static int counter = 1_000_000;
  private static boolean[] exists = new boolean[100_000_001];


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    HashSet<Integer> set = new HashSet<>();
    while(sc.hasNextInt()) {
      int thisint = sc.nextInt();
      set.add(thisint);
    }

    System.out.println(set.size());
  }
}
