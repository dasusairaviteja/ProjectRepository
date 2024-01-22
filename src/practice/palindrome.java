package practice;

public class palindrome {
    public static void main(String[] args) {
        int num = 12321;
        int palindromeFindNumber = 0;
        int temp = num;
        while(temp != 0){
            palindromeFindNumber = palindromeFindNumber * 10 + temp % 10;
            temp /=10;
        }

        if (palindromeFindNumber == num){
            System.out.println("palindrome");

        } else{
            System.out.println("not palindorme");
        }
    }
}
