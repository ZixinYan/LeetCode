class Solution {
    public int largestVariance(String s) {
        Map<Character, List<Integer>> pos = new HashMap<>();
        // 记录每个字符的位置
        for (int i = 0; i < s.length(); ++i) {
            // 如果字符不存在，就新建一个list
            pos.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        // 枚举两个字符
        for (char c0 : pos.keySet()) {
            for (char c1 : pos.keySet()) {
                // 如果两个字符不同
                if (c0 != c1) {
                    // 记录两个字符的位置
                    List<Integer> pos0 = pos.get(c0);
                    List<Integer> pos1 = pos.get(c1);
                    // 双指针求最长子序列
                    int i = 0, j = 0;
                    int f = 0, g = Integer.MIN_VALUE;
                    // f表示以c0结尾的最长子序列，g表示以c1结尾的最长子序列
                    while (i < pos0.size() || j < pos1.size()) {
                        // 如果c0的位置在c1的位置之前，那么f+1，g+1
                        if (j == pos1.size() || (i < pos0.size() && pos0.get(i) < pos1.get(j))) {
                            f = Math.max(f, 0) + 1;
                            g = g + 1;
                            i++;
                            // 如果c1的位置在c0的位置之前，那么f-1，g-1
                        } else {
                            g = Math.max(Math.max(f, g), 0) - 1;
                            f = Math.max(f, 0) - 1;
                            j++;
                        }
                        ans = Math.max(ans, g);
                    }
                }
            }
        }
        return ans;
    }
}


// faster
class Solution {
    public int largestVariance(String s) {
        var ans = 0;
        var diff = new int[26][26];
        var diffWithB = new int[26][26];
        // diff[a][b]表示a和b的差值
        for (var i = 0; i < 26; i++) Arrays.fill(diffWithB[i], -s.length());
        // diffWithB[a][b]表示以b结尾的最长子序列
        for (var k = 0; k < s.length(); k++) {
            var ch = s.charAt(k) - 'a';
            // 枚举26个字符
            for (var i = 0; i < 26; ++i) {
                // 如果字符相同，那么跳过
                if (i == ch) continue;
                // 如果字符不同，那么更新diff和diffWithB
                ++diff[ch][i]; // a=ch, b=i
                ++diffWithB[ch][i];
                diffWithB[i][ch] = --diff[i][ch]; // a=i, b=ch
                diff[i][ch] = Math.max(diff[i][ch], 0);
                ans = Math.max(ans, Math.max(diffWithB[ch][i], diffWithB[i][ch]));
            }
        }
        return ans;
    }
}