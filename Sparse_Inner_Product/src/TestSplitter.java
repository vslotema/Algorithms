/*
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.junit.Test;
@SuppressWarnings("unused")
public class TestSplitter {

    private static final String line = "12 34";
    private static final int RUNS = 1000000;// 000000;

    public final void testSplit() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < RUNS; i++) {
            String[] st = line.split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
        }
        System.out.println("Split: " + (System.currentTimeMillis() - start) + "ms");
    }

    public final void testIndexOf() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < RUNS; i++) {
            int index = line.indexOf(' ');
            int x = Integer.parseInt(line.substring(0, index));
            int y = Integer.parseInt(line.substring(index + 1));
        }
        System.out.println("IndexOf: " + (System.currentTimeMillis() - start) + "ms");
    }

    public final void testTokenizer() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < RUNS; i++) {
            StringTokenizer st = new StringTokenizer(line, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
        }
        System.out.println("StringTokenizer: " + (System.currentTimeMillis() - start) + "ms");
    }


    static int[] pow = new int[] { 1, 10, 100, 1000, 10000, 100000 };

    public final void testIndexOf2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < RUNS; i++) {

            int x = 0;
            int y = 0;

            int len = line.length();
            int index = len - 1;
            while (index > 0 && line.charAt(index) != ' ') {
                char c = line.charAt(index);
                switch (c) {
                    case '+':
                        break;
                    case '-':
                        y *= -1;
                        break;
                    default:
                        y += (c - '0') * pow[len - index - 1];
                        break;
                }

                index--;
            }

            len = index;
            index--;
            while (index >= 0) {
                char c = line.charAt(index);
                switch (c) {
                    case '+':
                        break;
                    case '-':
                        x *= -1;
                        break;
                    default:
                        x += (c - '0') * pow[len - index - 1];
                        break;
                }

                index--;
            }
        }
        System.out.println("IndexOf2: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static class CSV{
        public int x;
        public int y;
    }

    public static void main(String[] args){
        TestSplitter s = new TestSplitter();
        s.testIndexOf2();
    }

}*/