import java.io.File;

public class Run {

  private static File input = new File("data/input.txt");
  private static File rand_input = new File ("data/rand_1mil_seed30.txt");


  private static void runOnDifferentM() throws Exception {
    System.out.println("m, estimate");
    HyperLogLog_M HLL;
    for (int i = 512; i <= 16_384; i *= 2) {
      HLL = new HyperLogLog_M(i, rand_input);
      double E = HLL.addFileAndGetE();
      System.out.println(i + ", " + E);
    }
    HLL = null;

  }

  private static void ex2 () throws Exception {
    HyperLogLog_M HLL = new HyperLogLog_M(1024, input);
    HLL.ex2();
    HLL = null;
  }

  private static void ex3 () throws Exception {
    HyperLogLog_M HLL = new HyperLogLog_M(1024, input);
    System.out.println(HLL.addFileAndGetE());
    HLL = null;
  }

  public static void main(String[] args) throws Exception {

  //ex. 2
    System.out.println("Excercise 2");
    ex2();
    System.out.println();
  //ex. 3
    System.out.println("Exercise 3");
    ex3();
    System.out.println();

    //print m and E for rand_1mil_seed30
    System.out.println("Exercise 4");
    runOnDifferentM();
    System.out.println();
  }
}
