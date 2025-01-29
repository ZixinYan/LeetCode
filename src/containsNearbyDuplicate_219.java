import java.util.HashSet;
import java.util.Set;

public class containsNearbyDuplicate_219 {
    /* 利用贪心算法解决,时间复杂度（n^2）
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){

            if(i+k<nums.length) {
                for (int j = i + 1; j <= i + k; j++) {
                    if (nums[i] == nums[j] && j - i <= k) {
                        return true;
                    }
                }
            }else{
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j] && j - i <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
     */
    
    //利用滑动窗口解决,利用hash表解决
    public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<Integer>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                if (!set.add(nums[i])) {
                    return true;
                }
            }
            return false;
    }
    
    
    
    

    public static void main(String[] args) {
        int[] nums = {99,99};
        int k = 2;
        containsNearbyDuplicate_219 solution = new containsNearbyDuplicate_219();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}
