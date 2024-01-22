package practice;

import java.util.Scanner;

public class FunctionsPractice {

    static int multiplicationOfTwoNumbers (int number1, int number2){
        int multiplication = number1 * number2;
        return multiplication;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        System.out.println("Multiplied Number Is : " + multiplicationOfTwoNumbers(number1 , number2));
    }


}
