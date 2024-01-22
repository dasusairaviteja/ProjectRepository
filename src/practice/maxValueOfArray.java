package practice;

public class maxValueOfArray {
    public static void main(String[] args) {
        int[] arr = {1,15,35,20,6911,25,84,45};
        System.out.println(maxValue(arr));
    }
    static int maxValue(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
             if (max < arr[i]){
                max = arr[i];

            }

        }
        return max;
    }
}