import java.util.Arrays;

// 利用滑动窗口解决
// 原本尝试了排列组合计算，逻辑有点儿混乱，大体思想和滑动窗口类似，但是没有实现

public class ValidSubstringCount_3298{
    public long validSubstringCount(String word1, String word2) {
        int[] diff = new int[26];
        for (char c : word2.toCharArray()) {
            diff[c - 'a']--;
        }

        long res = 0;
        int[] cnt = { (int) Arrays.stream(diff).filter(c -> c < 0).count() };
        int l = 0, r = 0;
        while (l < word1.length()) {
            while (r < word1.length() && cnt[0] > 0) {
                update(diff, word1.charAt(r) - 'a', 1, cnt);
                r++;
            }
            if (cnt[0] == 0) {
                res += word1.length() - r + 1;
            }
            update(diff, word1.charAt(l) - 'a', -1, cnt);
            l++;
        }
        return res;
    }

    private void update(int[] diff, int c, int add, int[] cnt) {
        diff[c] += add;
        if (add == 1 && diff[c] == 0) {
            // 表明 diff[c] 由 -1 变为 0
            cnt[0]--;
        } else if (add == -1 && diff[c] == -1) {
            // 表明 diff[c] 由 0 变为 -1
            cnt[0]++;
        }
    }
}
