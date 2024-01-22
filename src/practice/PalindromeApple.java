package practice;

public class PalindromeApple {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > 0) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x =x/10;
        }

        return x == revertedNumber;
    }
}
