import java.util.Arrays;
import java.util.HashMap;

public class subarraySum_560 {
    /* 暴力破解
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

     */

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap <> ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }


    public static void main(String[] args) {
        int[] num = {1,-1,0};
        int k = 0;
        System.out.println(new subarraySum_560().subarraySum(num, k));
    }
}
