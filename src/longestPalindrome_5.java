public class longestPalindrome_5 {
    public boolean isPalindrome(String s,int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
     public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            String res = "";
            int maxLength = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
                res = s.substring(i, i + 1);
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    res = s.substring(i, i + 2);
                }
            }
            for (int len = 3; len <= s.length(); len++) {
                for (int i = 0; i <= s.length() - len; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        if (len > maxLength) {
                            maxLength = len;
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }

            return res;
    }

    public static void main(String[] args) {
        String a = "babad";
        System.out.println(new longestPalindrome_5().longestPalindrome(a));
    }
}
