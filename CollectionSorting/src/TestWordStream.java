// Week 3
// sestoft@itu.dk * 2015-09-09

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class TestWordStream {
    public static void main(String[] args) throws IOException{
        String filename = "usr/share/dict/words";

        //  System.out.println(readWords(filename).count());
        //  printFirst100(filename);
        //    printAtLeast22(filename);
        //  printSome22(filename);
        // printPalindromePar(filename);
        printMaxAndMinLength(filename);

    }

    public static void printFirst100(String filename){
        readWords(filename)
                .limit(100)
                .forEach(System.out::println);
    }

    public static void printAtLeast22(String filename){
        readWords(filename)
                .filter(word -> word.length() >= 22)
                .forEach(System.out::println);
    }

    public static void printSome22(String filename){
        readWords(filename)
                .filter(word -> word.length() >= 22)
                .limit(1)
                .forEach(System.out::println);

    }

    public static Stream<String> readWords(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            return reader.lines();
        } catch (IOException exn) {
            return Stream.<String>empty();
        }
    }

    public static void printPalindrome(String filename){
        readWords(filename)
                .filter(x -> isPalindrome(x))
                .forEach(System.out::println);
    }

    public static void printPalindromePar(String filename){
        readWords(filename)
                .parallel()
                .filter(x -> isPalindrome(x))
                .forEach(System.out::println);
    }

    public static void printMaxAndMinLength(String filename){


        Integer max = readWords(filename)
                .map(x -> x.length())
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println(max);
    }

    public static boolean isPalindrome(String s) {

        int rev = s.length()-1;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) != s.charAt(rev)){
                return false;
            }else if(i == (s.length()/2)-1){
                return true;
            }else{
                rev--;
            }

        }
        return false;
    }



    public static Map<Character,Integer> letters(String s) {
        Map<Character,Integer> res = new TreeMap<>();
        // TO DO: Implement properly
        return res;
    }
}
