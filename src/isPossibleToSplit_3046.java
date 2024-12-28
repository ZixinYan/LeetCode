// 采用数组记录每个数字出现的次数，如果一个数字出现两次以上就肯定不能在两个数组里面不重复了
// https://leetcode.cn/problems/split-the-array/description/
public class isPossibleToSplit_3046 {
    public boolean isPossibleToSplit(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]]++;
            if(dp[nums[i]] > 2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(new isPossibleToSplit_3046().isPossibleToSplit(nums));
    }
}
