import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Mark8 {

    public static double Mark8Setup(String msg, String info, Benchmarkable f,
                                    int n, double minTime) {
        int count = 1, totalCount = 0;
        double dummy = 0.0, runningTime = 0.0, st = 0.0, sst = 0.0;
        do {
            count *= 2;
            st = sst = 0.0;
            for (int j=0; j<n; j++) {
                Timer t = new Timer();
                for (int i=0; i<count; i++) {
                    t.pause();
                    f.setup();
                    t.play();
                    dummy += f.applyAsDouble(i);
                }
                runningTime = t.check();
                double time = runningTime * 1e9 / count;
                st += time;
                sst += time * time;
                totalCount += count;
            }
        } while (runningTime < minTime && count < Integer.MAX_VALUE/2);
        double mean = st/n, sdev = Math.sqrt((sst - mean*mean*n)/(n-1));
        System.out.printf("%-25s %s%15.1f ns %10.2f %10d%n", msg, info, mean, sdev, count);
        return dummy / totalCount;
    }

    public static double Mark8Setup(String msg, Benchmarkable f) {
        return Mark8Setup(msg, "", f, 10, 0.25);
    }

    public static double Mark8Setup(String msg, String info, Benchmarkable f) {
        return Mark8Setup(msg, info, f, 10, 0.25);
    }

    public static void SystemInfo() {
        System.out.printf("# OS:   %s; %s; %s%n",
                System.getProperty("os.name"),
                System.getProperty("os.version"),
                System.getProperty("os.arch"));
        System.out.printf("# JVM:  %s; %s%n",
                System.getProperty("java.vendor"),
                System.getProperty("java.version"));
        // The processor identifier works only on MS Windows:
        System.out.printf("# CPU:  %s; %d \"cores\"%n",
                System.getenv("PROCESSOR_IDENTIFIER"),
                Runtime.getRuntime().availableProcessors());
        java.util.Date now = new java.util.Date();
        System.out.printf("# Date: %s%n",
                new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(now));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");
        int size = Integer.parseInt(read[0]);
        CollectionSorting cs = new CollectionSorting();

        //    PriorityQueue pq = new PriorityQueue(size);

        int[] unordered = new int[size];

        for(int i = 0;i<size;i++){

            String x = br.readLine().replace(" ","");
            unordered[i]=Integer.parseInt(x);
        }


        for(int i = 0; i<size;i++){
            CollectionSorting.add(unordered[i]);
        }

        List<Integer> ordered = CollectionSorting.getList();



        SystemInfo();
        Mark8Setup("Collection_sort_Int_getMinimum",
                String.format("%8d", size),
                new Benchmarkable() {
                    public void setup() {
                        new CollectionSorting(ordered);
                        //    Sort.CollectionSort(unordered);
                        //  Sort.shuffle(unordered);
                    }

                    public double applyAsDouble(int i) {
                        Sort.getMin(size);
                        return 0.0;
                    }
                });
    }
}
