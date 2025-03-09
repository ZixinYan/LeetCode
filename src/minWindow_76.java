class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) {
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

// 这类题目的核心思想就是维护一个滑动窗口，通过一个队列或者hashmap计算该窗口是否满足输出条件
// 在滑动窗口的时候一般分为两类
// 1. 固定长度窗口——这个时候考虑Deque和Queue这种具有先进先出属性的数据结构
// 2. 不固定长度窗口——这个时候考虑HashMap这种具有key-value属性的数据结构，在有大小关系的时候考虑PriorityQueue
// 一般滑动窗口题目设计一个剪枝思想，就是当窗口满足条件的时候，尽量缩小窗口，当窗口不满足条件的时候，尽量扩大窗口