import java.util.PriorityQueue;

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
