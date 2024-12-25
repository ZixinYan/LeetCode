import java.util.PriorityQueue;

// 采用优先队列来存储水平和垂直切割的位置，每次取出最小的切割位置，然后计算切割的代价，直到切割完所有的位置。
// 时间复杂度为O((m+n)log(m+n))，空间复杂度为O(m+n)。
// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/780880/Java-Intuition-with-Explanation

public class minimumCost_3218 {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0;i < horizontalCut.length;i++){
            pq.add(new int[]{horizontalCut[i], 0});
        }
        for (int i = 0; i < verticalCut.length; i++) {
            pq.add(new int[]{verticalCut[i], 1});
        }
        while(m!=1 || n!=1) {
            int[] temp = pq.poll();
            if (temp[1] == 0) {
                cost += temp[0] * n;
                m--;
            } else {
                cost += temp[0] * m;
                n--;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[] horizontalCut = {1, 3};
        int[] verticalCut = {5};
        minimumCost_3218 mc = new minimumCost_3218();
        System.out.println(mc.minimumCost(m, n, horizontalCut, verticalCut));
    }
}
