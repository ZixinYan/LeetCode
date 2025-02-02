import java.util.Arrays;

public class maxCount_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int res = m*n;
        int[] dp = new int[2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int[] op : ops) {
            if(op[0] < dp[0]){
                dp[0] = op[0];
            }
            if(op[1] < dp[1]){
                dp[1] = op[1];
            }
            res = dp[0] * dp[1];
        }
        return res;
    }
}
