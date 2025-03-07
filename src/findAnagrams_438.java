import java.util.*;

public class findAnagrams_438 {
    /* simulation
    public List<Integer> findAnagrams(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(pArr);
        int left = 0, right = p.length() - 1;
        while(right < s.length()) {
            boolean flag = true;
            for(int i = left; i<=right;i++) {
                if(pArr[i - left] != sArr[i]){
                    flag = false;
                    break;
                }
            }

            if(flag) {
                res.add(left);
            }

        }
        return res;
    }

     */

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
