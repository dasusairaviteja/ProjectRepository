package practice;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        String[] names = {"sai","Dasu","padma"};
        System.out.println(Arrays.toString(nums));
        changeName(names);
        change(nums);
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(nums));
    }
    static void change(int[] arr){
        arr[1] = 33;
        arr[3] = 123;
    }

    static void changeName(String[] arr){
        arr[1] = "krishna";

    }

}
