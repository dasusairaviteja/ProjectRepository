package practice;
import java.util.*;
public class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if(age >= 25){
            System.out.println("The person is above 25 years of age");
        } else {
            System.out.println("The person is below 25 years");
        }
    }
}
