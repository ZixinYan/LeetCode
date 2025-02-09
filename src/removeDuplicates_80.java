import java.util.HashMap;

public class removeDuplicates_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int res = 1; 
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[res - 1]) {
                count++;
            } else {
                count = 1; 
            }
            if (count <= 2) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

/*
    通过双指针解决，fast代表当前位置，slow代表长度>2的元素的最后一个元素位置
    如果nums[slow - 2] != nums[fast]，则代表当前元素没有超过2，整体往前移动，反之相等的话就只移动fast角标直到不相等，这时候的slow元素替换为fast完成数组更新

    之后的操作中所有slow后面的相同元素都会被替换为fast，直到fast到达新元素的时候，重新开始判断
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

 */

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        removeDuplicates_80 sol = new removeDuplicates_80();
        System.out.println(sol.removeDuplicates(nums));
    }
}
