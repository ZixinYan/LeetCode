class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (!wordMap.containsKey(word)) {
                    count = 0;
                    left = right;
                    windowMap.clear();
                } else {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;
                    // 如果窗口中某个单词出现的次数超过了words中的次数，需要移动左指针
                    while (windowMap.getOrDefault(word, 0) > wordMap.getOrDefault(word, 0)) {
                        String leftWord = s.substring(left, left + wordLen);
                        count--;
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                    }
                    if (count == wordCount) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}