import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 2, 3);

        // 1. collect
        List<Integer> l = list.stream().skip(1).collect(Collectors.toList());
        System.out.println(l);

        // List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam", "Akshit");
        // Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // // no filtering at this point
        // long res = filteredStream.count();
        // System.out.println(res);
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}