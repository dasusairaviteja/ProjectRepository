package practice;

public class BubbleSort {

    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);


        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,2,7,8,9};
        for (int i = 0; i < arr.length-1; i++) {
            for(int j=0;j<arr.length -1 - i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
            printArray(arr);
        }
    }
}
