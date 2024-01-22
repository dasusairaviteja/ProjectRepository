package practice;

import java.util.Scanner;

public class SwitchCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carNameEntered = sc.nextInt();
        switch(carNameEntered){
            case 1 :
                System.out.println("I love BMW");
                break;
            case 2 :
                System.out.println("I love 'AUDI");
                break;
            case 3 :
                System.out.println("I love Porsche");
                break;
            default :
                System.out.println("Please enter a word instead of other things");

        }
    }
}
