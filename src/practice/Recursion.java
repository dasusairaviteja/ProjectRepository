package practice;

public class Recursion {
    public static void main(String[] args) {
        int n= 5;
        printNumber(n);
    }

    private static void printNumber(int n) {
        if(n == 0){
            return;
        }
        System.out.println(n);
        printNumber(n-1);
    }


}
