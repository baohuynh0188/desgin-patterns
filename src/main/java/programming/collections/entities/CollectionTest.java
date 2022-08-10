package programming.collections.entities;

import java.util.Arrays;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        String[] listName = {"Bao", "Nam", "Thong", "Tu", "Nhan", "Huy"};

        Arrays.parallelSort(listName);

        Arrays.stream(listName).forEach(System.out::println);

        List<String> list = Arrays.asList(listName);
//        // show origin list
        list.forEach(n -> System.out.println(n));
//
//        list.sort((o1, o2) -> o2.compareTo(o1));
//
//        list.forEach(System.out::println);

//        Collections.reverse(list);
//        list.forEach(System.out::println);
    }

}
