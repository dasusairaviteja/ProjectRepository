package practice;
import java.util.*;
public class oddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberEnteredIs = sc.nextInt();
        if(numberEnteredIs % 2 ==0){
            System.out.println("The number is EVEN");
        } else{
            System.out.println("The number is ODD");
        }
    }
}
