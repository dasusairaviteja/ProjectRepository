package practice;

import java.util.Arrays;

public class Swappiung {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Swap(arr, 3, 6);
        System.out.println(Arrays.toString(arr));
    }
    static void Swap(int[] arr , int index3 , int index6){
        int temp = arr[index3];
        arr[index3] = arr[index6];
        arr[index6] = temp;
    }
}
