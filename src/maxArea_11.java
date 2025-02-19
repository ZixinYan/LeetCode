public class maxArea_11 {

    /* 直接模拟
        public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i+1; j < height.length; j++){
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }
     */

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
        while(left < right) {
            if (height[left] < height[right]) {
                left++;
                res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            } else {
                right--;
                res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return res;
    }
}
