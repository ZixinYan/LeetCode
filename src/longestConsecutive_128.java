import java.util.Arrays;

public class longestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                count++;
            }else if(nums[i] == nums[i + 1]){
                continue;
            }else{
                res= Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
