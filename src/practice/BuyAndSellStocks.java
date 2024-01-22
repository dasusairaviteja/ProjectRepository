package practice;

import java.sql.SQLOutput;

public class BuyAndSellStocks {
//    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println(maximumProfit(prices));
//    }
//
//    private static int maximumProfit(int[] prices) {
//        int min = prices[0];
//        int profit = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            if(prices[i] < min){
//                min = prices[i];
//            }
//            profit = Math.max(profit , prices[i] - min);
//
//        }
//        return profit;
//    }
public static void main(String[] args) {
    int[] numbers = {7,1,5,6,3,4,8};
    System.out.println(maximumProfit(numbers));

}

    private static int maximumProfit(int[] numbers) {

    int min = numbers[0];
    int profit = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < min){
                min = numbers[i];
            }
            profit = Math.max(profit , numbers[i] - min);
        }
        return profit;
    }
}


