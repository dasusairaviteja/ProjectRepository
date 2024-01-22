package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class sorting {
    public static void main(String[] args) {
        List<Integer> fruits = new ArrayList<>();
        fruits.add(100);
        fruits.add(104);
        fruits.add(102);
        fruits.add(103);
        fruits.add(106);
        fruits.add(99);
        fruits.add(99);

        List<Integer> sortedFruits = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> sortedFruitsLambda = fruits.stream().sorted((o1 , o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        sortedFruitsLambda.forEach(System.out::println);


//        System.out.println(sortedFruits);
//        System.out.println(sortedFruitsLambda);
//
//        System.out.println(fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
//        System.out.println(fruits.stream().sorted((o1,o2) -> o2.compareTo(o1)).collect(Collectors.toList()));


    }
}
