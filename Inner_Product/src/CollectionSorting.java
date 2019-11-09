import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionSorting {

    private static List<Integer> ordered = new LinkedList<>();

    public static void add(int n){
        ordered.add(n);
        Collections.sort(ordered);
    }

    public static void deleteMin(){
        ordered.remove(0);
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        List<Integer> unordered = new LinkedList<>();

        int count = 0;
        while(count < N){
            unordered.add(Integer.parseInt(br.readLine()));
            count++;
        }

        long start = System.nanoTime();
        for(Integer num:unordered){
            add(num);
        }

        System.out.println(System.nanoTime()-start);

        System.out.println(ordered.get(0));
        deleteMin();

        System.out.println(ordered.get(0));
    }
}
