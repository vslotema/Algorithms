import java.util.concurrent.atomic.AtomicInteger;

public class myAtomicInteger {
     private AtomicInteger value = new AtomicInteger(0);

    public int addAndGet(int amount) {
        return value.addAndGet(amount);
    }

    public int get() {
        return value.get();
    }


    public static void main (String[]args){

        myAtomicInteger atomInt = new myAtomicInteger();
        atomInt.addAndGet(5);
        System.out.println(atomInt.get());


    }

}
