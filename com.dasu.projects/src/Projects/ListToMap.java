package Projects;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {
    public static void main(String[] args) {
       List<Integer> list = Arrays.asList(1,5,7,8,3,4,5,6,9);
//       Collections.sort(list);
//        System.out.println("Sorted List (Ascending): " + list);
//        Collections.sort(list , Collections.reverseOrder());
//        System.out.println(list);
         int i = Arrays.binarySearch(list.toArray() , 3);
        System.out.println(i);
    }
}
