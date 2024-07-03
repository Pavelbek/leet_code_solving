package pargunov.medium;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoinChange_322 {

    public static void main(String[] args) {}

    // good explanation on Nikhil Lohia channel
    // dynamic programming bottom-up approach
    private static int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for(int coin : coins) {
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE) return -1;

        return dp[amount];
    }
}
