import java.util.*;

//采用优先队列来存储空闲的座位区间，每次调用seat方法时，取出最大的区间，然后将区间分为两部分，分别加入到优先队列中，最后返回中间的座位号。
//当调用leave方法时，将离开的座位号左右两边的区间合并，然后加入到优先队列中。
//时间复杂度为O(logN)，空间复杂度为O(N)。
//https://leetcode.com/problems/exam-room/discuss/139873/Java-PriorityQueue-with-Interval

//这段代码最后在当前测试用例下会出现报错，但是不知道是为什么
public class ExamRoom_855 {
    private int N;
    private Set<Integer> seats;
    private PriorityQueue<Interval> freeIntervals;

    private class Interval {
        int dist;
        int left;
        int right;

        Interval(int dist, int left, int right) {
            this.dist = dist;
            this.left = left;
            this.right = right;
        }
    }

    public ExamRoom_855(int N) {
        this.N = N;
        this.seats = new HashSet<>();
        this.freeIntervals = new PriorityQueue<>((a, b) -> {
            if (a.dist == b.dist) {
                return Integer.compare(a.left, b.left);
            }
            return Integer.compare(b.dist, a.dist);
        });
        freeIntervals.add(new Interval(N - 1, -1, N));
    }
    public int seat() {
        Interval maxInterval = freeIntervals.poll();
        int dist = maxInterval.dist;
        int left = maxInterval.left;
        int right = maxInterval.right;

        int seat;
        if (left == -1) {
            seat = 0;
        } else if (right == N) {
            seat = N - 1;
        } else {
            seat = (left + right) / 2;
        }
        seats.add(seat);
        if (seat > left) {
            freeIntervals.add(new Interval((seat - left) / 2, left, seat));
        }
        if (seat < right) {
            freeIntervals.add(new Interval((right - seat) / 2, seat, right));
        }

        return seat;
    }

    public void leave(int p) {
        seats.remove(p);
        int left = p, right = p;
        while (left - 1 >= 0 && !seats.contains(left - 1)) {
            left--;
        }
        while (right + 1 < N && !seats.contains(right + 1)) {
            right++;
        }
        if(left == 0){
            freeIntervals.add(new Interval((right - left) / 2, -1 , right));
        }else if(right - left == 0){
            freeIntervals.add(new Interval(1, left, right));
        }
        else{
            freeIntervals.add(new Interval((right - left) / 2, left, right));
        }
    }

    public static void main(String[] args) {
        ExamRoom_855 examRoom = new ExamRoom_855(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
    }
}
