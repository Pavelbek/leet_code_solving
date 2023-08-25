package pargunov.easy;

import java.util.stream.IntStream;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] arr1 = {7, 1, 5, 3, 6, 4}; // 5
        int[] arr2 = {7, 6, 4, 3, 1}; // 0
        int[] arr3 = {1, 4, 2}; // 3
        int[] arr4 = {3, 2, 6, 5, 0, 3}; // 4


    }

    // Runtime Beats 85.25% Memory Beats 81.22%
    private static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            profit = Math.max(profit, currentPrice - min);
            min = Math.min(min, currentPrice);
        }

        return profit;
    }

}
