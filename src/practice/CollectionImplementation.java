package practice;


import java.util.*;

public class CollectionImplementation {
    public static void main(String[] args) {
//        Collection<String> fruitCollection = new ArrayList<>();
//        fruitCollection.add("Banana");
//        fruitCollection.add("Apple");
//        fruitCollection.add("pomegranate");
//        fruitCollection.add("kiwi");
//        fruitCollection.add("orange");

        // or we can add like this also
        List<String> fruitsAre = Arrays.asList("Banana" , "Apple" , "pomegranate" ,"kiwi","orange" );

//        fruitsAre.forEach(System.out::println);
        for (int i = 0; i < fruitsAre.size(); i++) {
            System.out.println(fruitsAre.get(i));
        }
        for(String names : fruitsAre){
            System.out.println(names);
        }
        fruitsAre.forEach(fruit -> System.out.println(fruitsAre));
    }
}
