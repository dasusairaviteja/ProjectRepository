package practice;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4};
        System.out.println(findDuplicates(nums));

        }

    private static boolean findDuplicates(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(visited.contains(nums[i])){
                return true;
            } else {
                visited.add(nums[i]);
            }

        } return false;
    }
}