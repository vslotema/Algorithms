package BasicDesign;// For week 2
// sestoft@itu.dk * 2014-09-04
// thdy@itu.dk * 2019
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

//import net.jcip.annotations.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

interface Histogram {
    void increment(int bin);

    int getCount(int bin);

    int getSpan();

    int[] getBins();
}

class SimpleHistogram {
    public static void main(String[] args) {
        final Histogram histogram = new Histogram5(30);
        histogram.increment(7);
        histogram.increment(13);
        histogram.increment(7);
    /*   int[] copy1 = histogram.getBins();
        for(int i = 0; i < copy1.length; i++){
          System.out.println(copy1[i]);
        }*/
        dump(histogram);

    }

    public static void dump(Histogram histogram) {
        int totalCount = 0;
        for (int bin = 0; bin < histogram.getSpan(); bin++) {
            System.out.printf("%4d: %9d%n", bin, histogram.getCount(bin));
            totalCount += histogram.getCount(bin);
        }


        System.out.printf("      %9d%n", totalCount);
    }
}
/*
class Histogram2 implements Histogram {
    private final int[] counts;

    public Histogram2(int span) {
        this.counts = new int[span];

    }

    public synchronized void increment(int bin) {
        synchronized (counts) {
            counts[bin] = counts[bin] + 1;
        }
    }

    public int getCount(int bin) {
        synchronized (counts) {
            return counts[bin];
        }

    }

    public int getSpan() {
        return counts.length;
    }

    public int[] getBins() {
        synchronized (counts) {
            return counts.clone();
        }
    }


class Histogram3 implements Histogram {
        private final AtomicInteger[] counts;

        public Histogram3(int span) {
            this.counts = new AtomicInteger[span];
            for (int i = 0; i < counts.length; i++) {
                AtomicInteger atom = new AtomicInteger(0);
                counts[i] = atom;
            }

        }

        public synchronized void increment(int bin) {
            counts[bin].incrementAndGet();
        }

        public int getCount(int bin) {
            return counts[bin].get();
        }

        public int getSpan() {
            return counts.length;
        }

        public synchronized int[] getBins() {
            int[] copyOfCounts = new int[counts.length];
            for (int i = 0; i < getSpan(); i++) {
                copyOfCounts[i] = counts[i].get();
            }
            return copyOfCounts;
        }
    }
    class Histogram4 implements Histogram {
            private final AtomicIntegerArray counts;

            public Histogram4(int span) {
                this.counts = new AtomicIntegerArray(span);

            }

            public void increment(int bin) {
                counts.incrementAndGet(bin);
            }

            public int getCount(int bin) {
                return counts.get(bin);
            }

            public int getSpan() {
                return counts.length();
            }
            public int[] getBins() {
                int[] copy = new int[getSpan()];
                for (int i = 0; is < getSpan(); i++) {
                    copy[i] = counts.get(i);
                    //  increment(1);
                }
                return copy;
            }
        }
    }*/

class Histogram5 implements Histogram {
    private final LongAdder[] counts;


    public Histogram5(int span){
        this.counts = new LongAdder[span];
        for(int i = 0; i<span;i++){
            LongAdder la = new LongAdder();
            counts[i]=la;
        }
    }

    public void increment(int bin) {
        counts[bin].add(1);
    }

    public int getCount(int bin) {
        int count = counts[bin].intValue();
        return count;
    }

    public int getSpan(){
        return counts.length;
    }
    public int[] getBins() {
        int[] copy = new int[getSpan()];
        for (int i = 0; i < getSpan(); i++) {
            copy[i] = getCount(i);
        }
        return copy;
    }

}
