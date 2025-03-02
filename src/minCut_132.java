import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minCut_132 {
    int[] res;
    boolean[][] dp;
    int n;
    public int minCut(String s) {
        n = s.length();
        dp = new boolean[n][n];
        // setting length = 1 for true
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }
        for(int i = n-1;i>=0;--i){
            for(int j = i+1; j < n; j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
            }
        }
        res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        for(int i = 0;i<n;++i){
            if(dp[0][i]){
                res[i] = 0;
            }else{
                for(int j = 0; j<i;++j){
                    if(dp[j+1][i]){
                        res[i] = Math.min(res[i], res[j]+1);
                    }
                }
            }
        }


        return res[n-1];
    }
}
