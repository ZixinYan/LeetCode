import java.util.PriorityQueue;

//采用优先队列来存储苹果的过期时间和数量，每次取出最早过期的苹果，然后吃掉一个，直到没有苹果过期或者没有苹果可以吃。
//时间复杂度为O(nlogn)，空间复杂度为O(n)。
//https://leetcode.com/problems/maximum-number-of-eaten-apples/discuss/987313/Java-PriorityQueue

public class eatenApples_1705 {
    public int eatenApples(int[] apples,int[] days) {
        int n = apples.length;
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n || !pq.isEmpty(); i++) {
            if (i < n && apples[i] > 0) {
                pq.add(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] == 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.peek()[1]--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};
        eatenApples_1705 ea = new eatenApples_1705();
        System.out.println(ea.eatenApples(apples, days));
    }
}
