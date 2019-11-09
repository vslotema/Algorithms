import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarException;

public class MinPQs {

    //PriorityQueue based on the MinPQ class written by Sedgewick and Kevin Wayne

    private  EdgeWeight[] pq;
    private  int indx;

    public MinPQs(int N){
        pq = new EdgeWeight[N+1];
        indx = 0;
    }

    public EdgeWeight[] getPq(){
        return pq;
    }

  /*  private void resize(int capacity) {
        assert capacity > indx;
        EdgeWeight[] temp = new EdgeWeight[capacity];
        for (int i = 1; i <= indx; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }*/

    public double insert(EdgeWeight item) {
        // double size of array if necessary
      //  if (indx == pq.length - 1) resize(2 * pq.length);

        pq[++indx] = item;
        swim(indx);
        return 1.0;
    }

    public EdgeWeight deleteMin(){
        EdgeWeight min = pq[1];
        exch(1,indx--);
        sink(1);
        pq[indx+1] = null;
    //    if ((indx > 0) && (indx == (pq.length - 1) / 4)) resize(pq.length / 2);
        return min;
    }



    private void sink(int k){
        while(2*k <= indx){
            int j = 2*k;
            if(j<indx && greater(j,j+1)) j++;
            if(!greater(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    private void swim(int k){

        while(k > 1 && greater(k/2,k)){
            exch(k,k/2);
            k = k/2;
        }
    }

    private boolean greater(int i, int j){
        return pq[i].compareTo(pq[j]) >  0;
    }

    private void exch(int i, int j){
        EdgeWeight swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


    public void print(){
        for(int i = 0; i <= indx;i++){
            System.out.println(pq[i]);
        }
    }




}
