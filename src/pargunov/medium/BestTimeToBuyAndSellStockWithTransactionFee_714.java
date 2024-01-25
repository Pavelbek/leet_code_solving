package pargunov.medium;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    public int maxProfit(int[] P, int F) {
        int sell = 0;
        int buy = -P[0];

        for(int i = 1; i < P.length; i++) {
            // we need to buy in cases where more will left from out profit after selling (sell) it means we buy cheaper
            buy = Math.max(buy, sell - P[i]);
            // we need to sell when we get more profit we already include here price of buying a stock so need
            // to subtract only fee and choose is it worth buying
            sell = Math.max(sell, P[i] + buy - F);
        }

        return sell;
    }
}
