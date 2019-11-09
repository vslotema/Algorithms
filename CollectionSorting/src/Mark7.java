import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntToDoubleFunction;

public class Mark7{

    public static double getMark7(String msg, IntToDoubleFunction f) {
        int n = 10, count = 1, totalCount = 0;
        double dummy = 0.0, runningTime = 0.0, st = 0.0, sst = 0.0;
        do {
            count *= 2;
            st = sst = 0.0;
            for (int j=0; j<n; j++) {
                Timer t = new Timer();
                for (int i=0; i<count; i++)
                    dummy += f.applyAsDouble(i);
                runningTime = t.check();
                double time = runningTime * 1e9 / count;
                st += time;
                sst += time * time;
                totalCount += count;
            }
        } while (runningTime < 0.25 && count < Integer.MAX_VALUE/2);
        double mean = st/n, sdev = Math.sqrt((sst - mean*mean*n)/(n-1));
        System.out.printf("%-25s %15.1f ns %10.2f %10d%n", msg, mean, sdev, count);
        return dummy / totalCount;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");
        int N = Integer.parseInt(read[0]);
        PriorityQueue pq = new PriorityQueue(N);

        int[] unordered = new int[N];


        for(int i = 0;i<N;i++){

            String x = br.readLine().replace(" ","");
            unordered[i]=Integer.parseInt(x);

        }


        getMark7("PQ_delMin_Ints",new Benchmarkable() {
            public void setup() {
                Sort.pqSort(unordered);
            }

            public double applyAsDouble(int i) {
                Sort.deleteMinPQ(pq);
                return 0.0;
            }
        });

    }
}
