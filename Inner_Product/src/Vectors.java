
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Vectors {

    private static List<String> v1 = new ArrayList<>();


    public static void add(String v) {
        v1.add(v);
    }

    public static List<String> getV1(){
        return v1;
    }

    public static Long getVector(StringTokenizer st, long n) {
        long v = 0;
        long indx = n - 1;
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("1")) {
                v |= ((long)1) << indx;
            }
            indx--;
        }return v;
    }

    public static boolean isOrthogonal(String line){

        for(String v: v1){
           StringTokenizer s = new StringTokenizer(v);
           StringTokenizer st = new StringTokenizer(line);

           boolean found = findOrthogonal(s,st);
           if(found){
               return true;
           }
        }
        return false;
    }

    private static boolean findOrthogonal(StringTokenizer s,StringTokenizer st) {

        while (s.hasMoreTokens()) {
            if ((Long.parseLong(s.nextToken()) & Long.parseLong(st.nextToken())) == 1) {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());


        boolean found = false;
        int count = 0;
        while (count <= 2*k+1) {
            String line = br.readLine();

            if(!line.equals("")) {
                if (count <= k) {
                    add(line);
                } else {
                    found = isOrthogonal(line);
                    if (found) {
                        System.out.println("yes");
                        break;
                    }
                }
            }
            count++;
        }

        if(!found){
            System.out.println("no");
        }


    }
}
