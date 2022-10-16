package pages;

import java.lang.reflect.Array;
import java.util.*;

public class Trainging2 {
    public static void main(String[] args) {
        Training training = new Training();
        System.out.println(training.getName());
        String s = "adladslaldk";
        String ss = s.replaceAll("d","f");
        System.out.println(ss);
        Set<String> ahah = new HashSet<String>();
        Collections.addAll(ahah,"adsad","asd","asdd","dasdad","dql");
        System.out.println(ahah);
        System.out.println(ahah.stream().findFirst());
        List<Integer> numbers = new ArrayList<Integer>();
        Collections.addAll(numbers,1,2,34,2,1,3,4,5,2,3,5,6,7,8);
        System.out.println(numbers.size()+"        "+numbers.stream().distinct().count());
        Set<Integer> numbersSet = new HashSet<>();
        numbers.stream().allMatch(t->numbersSet.add(t));
        System.out.println(numbersSet);
        int l[] = new int[3];

    }
}
