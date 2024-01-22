package practice;

public class calcFactorialRecursion {
//    static int calcFactorial(int n){
//        if(n ==1 || n ==0){
//            return 1;
//        }
//        int factCaluclate = calcFactorial(n-1);
//        int fact_main_calc = n* factCaluclate;
//        return fact_main_calc;
//    }

    static int calcPower(int x , int n ){
        if(n == 0){
            return 1;
        }
        if ( x == 0){
            return 0;

        }
        if ( n % 2 == 0){
            return calcPower( x,n/2) * calcPower( x , n/2);
        }
        else {
            return calcPower(x , n/2) * calcPower(x , n/2) * x ;
        }
//        int xpwrnm1 = calcPower( x , n-1);
//        int xpwrn = x * xpwrnm1;
//        return xpwrn;

    }
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(calcPower(x , n));


    }
}
