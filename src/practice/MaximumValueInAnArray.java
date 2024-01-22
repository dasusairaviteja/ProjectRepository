package practice;

public class MaximumValueInAnArray {
    public static void main(String[] args) {
        int[] arr = {1,58,6,79,46,1001,855,755,414};
        System.out.println(Maximum(arr, 2, 8));
    }
//    static int Maximum(int[] arr){
//        int max = arr[0];
//        for (int value = 1; value < arr.length; value++) {
//            if(arr[value] > max){
//                max = arr[value];
//
//            }
//
//        }return max;
//    }

    static int Maximum(int[] arr , int start ,int end){
        int max = arr[start];
        for (int i = start; i <= end; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        } return max;
    }
}
