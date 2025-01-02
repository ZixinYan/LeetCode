import java.util.ArrayList;
import java.util.List;

// 采用数组来存储每个事件的开始时间和结束时间，每次调用book方法时，遍历数组，判断是否有时间冲突。
// 时间复杂度为O(n)，空间复杂度为O(n)。
// https://leetcode.com/problems/my-calendar-i/discuss/109475/Java-Solution-Sweep-Line
public class MyCalendar_729 {
    private ArrayList<int[]> calendar;
    public MyCalendar_729() {
        calendar = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] event : calendar) {
            if (Math.max(event[0], startTime) < Math.min(event[1], endTime)) {
                return false;
            }
        }
        calendar.add(new int[]{startTime, endTime});
        return true;
    }
}
