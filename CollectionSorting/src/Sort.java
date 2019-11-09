// Example code for microbenchmark note
// sestoft@itu.dk * 2013-08-01

public class Sort {


    public static void CollectionSort(int[] arr){
        for(int i = 0; i<arr.length;i++){
            CollectionSorting.add(arr[i]);
        }
    }

    public static void pqSort(int[] arr){
        PriorityQueue pq = new PriorityQueue(arr.length);
        for(int i = 0; i<arr.length;i++){
            pq.insert(arr[i]);
        }
    }

    public static void getMin(int size){
        int count = size;
        while(count > 0){
            CollectionSorting.deleteMin();
            count--;
        }
    }

    public static void deleteMinPQ(PriorityQueue pq){
        pq.deleteMin();
    }


    // Utility for sorting
    private static void swap(int[] arr, int s, int t) {
        int tmp = arr[s];  arr[s] = arr[t];  arr[t] = tmp;
    }


    private static final java.util.Random rnd = new java.util.Random();

    public static void shuffle(int[] arr) {
        for (int i = arr.length-1; i > 0; i--)
            swap(arr, i, rnd.nextInt(i+1));
    }
}
