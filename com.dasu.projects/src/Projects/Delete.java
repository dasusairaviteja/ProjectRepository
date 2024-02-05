package Projects;

import java.util.*;
import java.util.stream.Collectors;

public class Delete {
    public static void main(String[] args) {
     List<String> arr = Arrays.asList("a" , "b " ,"c");
     List<String> collect = arr.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

     List<Integer> nums = Arrays.asList(1,2,3,4,5);
     List<Integer> numsChange = nums.stream().map(n -> n*5).collect(Collectors.toList());
        System.out.println(numsChange);
    }
}
