package Projects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapImpl {
    public static void main(String[] args) {
        HashMap<String,Long> map = new HashMap<>();
        map.put("India" , 150L);
        map.put("China" , 140L);
        map.put("Usa" , 64L);

        if(map.containsKey("India")){
            System.out.println("Key is present with value of " + map.get("India") + " Million");
        }

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.replace("India" , 150L , 160L));
        System.out.println(map);

//        map.entrySet().stream().map(element -> map).forEach(System.out::println);

        for(Map.Entry<String , Long> ele : map.entrySet()){
            System.out.println(ele + " Million");
        }
    }
}
