package practice;


public class TwoSum {
//    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//
//        int[] result = findTwoSum(nums, target);
//
//        if (result != null) {
//            System.out.println("Indices: " + result[0] + ", " + result[1]);
//        } else {
//            System.out.println("No two elements found that add up to the target.");
//        }
//    }
//
//    public static int[] findTwoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null; // Return null if no pair is found
//    }
//}

    public static void main(String[] args) {
        int[] nums = {1,2,8,9,4,55,77,3,12};
        int target = 10;

        int[] result = findTwosums(nums , target);
        if(result != null){
            System.out.println("Indicies for target are at location------> " + result[0]+ " & " + result[1]);

        } else {
            System.out.println("There are no numbers which are found to match with target");
        }
    }

    private static int[] findTwosums(int[] nums , int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] + nums[i+1] == target){
                return new int[] {i , i+1};
            }

        }
        return null;
    }
    }