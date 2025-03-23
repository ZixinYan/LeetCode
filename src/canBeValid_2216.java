class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;

        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '1') {
                if (c == '(') {
                    low++;
                    high++;
                } else {
                    low--;
                    high--;
                }
            } else {
                low--;
                high++;
            }
            if (high < 0) return false;
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}