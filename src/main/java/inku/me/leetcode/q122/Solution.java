package inku.me.leetcode.q122;

import inku.me.leetcode.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution extends TestSupport {
    private int[] prices;

    @BeforeEach
    void befor() {
        this.prices = new int[]{7, 1, 5, 3, 6, 4};
    }

    @Test
    void test() {
        int profit = maxProfit(prices);
        logger.info(profit + "");
    }

    private int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }
}
