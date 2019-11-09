import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exercise1{

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        int test = Integer.parseInt(reader.readLine());

        System.out.println(test);
    }

}