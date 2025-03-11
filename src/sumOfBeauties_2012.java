import java.util.PriorityQueue;
// 用最大堆维护右侧最小值，复杂度有点儿高，不是个好算法
class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int res = 0;
        int leftMax = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // 初始化优先队列，存储元素值和对应的索引
        for (int i = 1; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        for (int i = 1; i < n - 1; i++) {
            // 移除所有不在当前元素右侧的元素（索引 <= i）
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            int rightMin = pq.peek()[0]; // 当前右侧的最小值

            // 计算美丽值
            if (nums[i] > leftMax && nums[i] < rightMin) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }

            // 更新左侧最大值
            if (nums[i] > leftMax) {
                leftMax = nums[i];
            }
        }
        return res;
    }
}

// 复杂度是O(n)，优化点在于通过第二次遍历直接维护了右侧最小值
class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] state = new int[n];
        int pre_max = nums[0];
        for (int i = 1; i < n - 1; i++) {
            // 如果这个是一个最大值就更新为1
            if (nums[i] > pre_max) {
                state[i] = 1;
                pre_max = nums[i];
            }
        }
        int suf_min = nums[n - 1];
        int res = 0;
        for (int i = n - 2; i > 0; i--) {
            if (state[i] == 1 && nums[i] < suf_min) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res += 1;
            }
            suf_min = Math.min(suf_min, nums[i]);
        }
        return res;
    }
}
