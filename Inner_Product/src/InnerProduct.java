import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InnerProduct {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int[] one = new int[N];
        int[] two = new int[N];



        int indx=0;
        int indxII = 0;
        int i = 0;
        while(indxII<N)
        {
            int curChar = br.read();

            if (curChar == ' ' || curChar == '\n' || indxII == N-1)
            {
                if(indx < N){
                    one[indx] = i;
                    indx++;
                }else{
                    if(indxII == N-1){
                        int digit = curChar - 48;
                        two[indxII] = i*10 + digit;
                        indxII++;
                    }else{
                        two[indxII] = i;
                        indxII++;
                    }

                }
                i=0;
            }
            else
            {

                int digit = curChar - 48;
                if(i == -3){
                    i = -digit;
                }else{
                i = i*10 + digit;
                }

            }



        }

        int sum = 0;
        for(int m =0; m<N; m++){
            sum = sum + (one[m] * two[m]);
        }
        System.out.println(sum);


    }

}
