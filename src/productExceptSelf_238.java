class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
// faster
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 计算左侧前缀积
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;  // 存储左侧积
            leftProduct *= nums[i];   // 更新左侧积
        }

        // 计算右侧后缀积，并直接更新 answer 数组
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;  // 乘以右侧积
            rightProduct *= nums[i];    // 更新右侧积
        }

        return answer;
    }
}