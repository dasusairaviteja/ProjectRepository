package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<String>();
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("apple");
        fruits.add("kiwi");

        List<String> listFruits = fruits.stream().sorted((o1 , o2)-> o1.compareTo(o2)).collect(Collectors.toList());
        List<String> listFruits1 = fruits.stream().sorted(String ::compareTo).collect(Collectors.toList());
        System.out.println(listFruits1);
        List<String> listFruits2 = fruits.stream().sorted().collect(Collectors.toList());

        System.out.println(listFruits2);



    }
}
