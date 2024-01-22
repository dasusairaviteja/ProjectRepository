package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class MethodConstructor {
    public static void main(String[] args) {
        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("banana");
        fruitsList.add("apple");
        fruitsList.add("watermelon");
        fruitsList.add("kiwi");
        fruitsList.add("kiwi");

        Function<List<String> , Set<String>> setFunction = (List) -> new HashSet<>(fruitsList);
        System.out.println(setFunction.apply(fruitsList));
    }
}
