import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class minimumSize_1760 {
    /* 优先队列似乎不太行，所以采用二分查找了
    public int minimumSize(int[] nums, int maxOperations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            pq.add(num);
        }

        return pq.poll();
    }

     */

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        Arrays.sort(nums);
        int right = nums[nums.length - 1];
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }

}
