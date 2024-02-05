package Projects;

import java.util.*;
import java.util.stream.Collectors;

public class SecondSmallestElement {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,5,6,8,8,5,7,85,8,5,5,78,54,8,5,45);
         Optional<Integer> collect = nums.stream().distinct().sorted().filter(n -> n % 2 == 0).skip(1).findFirst();
        System.out.println(collect);
    }
        };


