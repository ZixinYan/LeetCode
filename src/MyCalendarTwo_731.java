import java.util.*;

// 采用差分数组来存储每个时间点的预定情况，然后遍历差分数组，判断是否有时间冲突。
// 时间复杂度为O(n)，空间复杂度为O(n)。
// https://leetcode.com/problems/my-calendar-ii/

public class MyCalendarTwo_731 {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarTwo_731() {
        timeline = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);
        int ongoing = 0;
        for (int count : timeline.values()) {
            ongoing += count;
            if (ongoing >= 3) {
                timeline.put(startTime, timeline.get(startTime) - 1);
                timeline.put(endTime, timeline.get(endTime) + 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo_731 calendar = new MyCalendarTwo_731();
        System.out.println(calendar.book(10, 20)); // 返回 true
        System.out.println(calendar.book(50, 60)); // 返回 true
        System.out.println(calendar.book(10, 40)); // 返回 true
        System.out.println(calendar.book(5, 15));  // 返回 false，三重预定
        System.out.println(calendar.book(5, 10));  // 返回 true
        System.out.println(calendar.book(25, 55)); // 返回 true
    }
}
