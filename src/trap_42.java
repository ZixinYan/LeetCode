public class trap_42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;

        while (left < right) {
            // 比较左右指针当前的高度，处理较小的一侧
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 更新左最大值
                } else {
                    res += leftMax - height[left]; // 计算当前左指针的积水量
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // 更新右最大值
                } else {
                    res += rightMax - height[right]; // 计算当前右指针的积水量
                }
                right--;
            }
        }
        return res;
    }

}
