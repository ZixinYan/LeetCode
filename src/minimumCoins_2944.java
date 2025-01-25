import java.util.HashMap;
import java.util.Map;

public class minimumCoins_2944 {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        int[] prices;

        public int minimumCoins(int[] prices) {
            this.prices = prices;
            return dp(0);
        }

        public int dp(int index) {
            if (2 * index + 2 >= prices.length) {
                return prices[index];
            }
            if (!memo.containsKey(index)) {
                int minValue = Integer.MAX_VALUE;
                for (int i = index + 1; i <= 2 * index + 2; i++) {
                    minValue = Math.min(minValue, dp(i));
                }
                memo.put(index, prices[index] + minValue);
            }
            return memo.get(index);
        }
}
