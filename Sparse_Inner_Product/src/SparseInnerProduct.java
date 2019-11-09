
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseInnerProduct {

    private Map<Long, Long> v;


    public SparseInnerProduct() {
        v = new HashMap<>();
    }

    public Map<Long, Long> getV() {
        return v;
    }


    public long getInnerProduct(long k, long value) {

        if (v.get(k) != null) {
            return v.get(k) * value;
        }
        return 0;
    }


    public List<Long> splitter(String line) {

        List<Long> nums = new ArrayList<>();
        long num = 0;
        int index = 0;
        boolean neg = false;
        while (index <= line.length()) {
            if(index == line.length()){
                if(neg){
                    num = num * -1;
                }
                nums.add(num);
                break;
            }
            int c = line.charAt(index);
            if (c == ' ' || c == ':') {
                if(neg){
                    num = num * -1;
                }
                nums.add(num);
                num = 0;
            }else if(c == '-') {
                neg = true;
            }else {
                long digit = c - 48;
                num = num * 10 + digit;
            }

            index++;
        }
        return nums;
    }



    public static void main(String[] args)throws IOException {

        SparseInnerProduct sp = new SparseInnerProduct();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        List<Long> vw = sp.splitter(br.readLine());

        long transfer = vw.get(2);
        long count = vw.get(1) + vw.get(2) + 1;

        long innerProduct = 0;
        String line = br.readLine();
        while(count !=0){
            if(!line.equals("")){
                vw = sp.splitter(line);

                if(count > transfer){
                    sp.getV().put(vw.get(0), vw.get(1));

                }else{
                    innerProduct += sp.getInnerProduct(vw.get(0),vw.get(1));
                }
            }
            count--;
            line = br.readLine();
        }
        System.out.println(innerProduct);

    }
}
