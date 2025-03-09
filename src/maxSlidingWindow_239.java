import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class maxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, left = 0, right = k - 1;
        int rlen = len - k + 1;
        int[] res = new int[rlen];
        int index = 0;
        int preIndex = -1;
        int max = Integer.MIN_VALUE;
        while(right < len){

            int prun = max - 2;
            if(left <= preIndex){ //前一最大值的下标还在区间内

                if(nums[right] >= nums[preIndex]){

                    preIndex = right;
                    max = nums[right];
                }
            }else if(nums[right] > prun){ //范围减枝

                preIndex = right;
                max = nums[right];
            }else if(nums[left] > prun){

                preIndex = left;
                max = nums[left];
            }else{
                //重新遍历出区间最大值
                max = Integer.MIN_VALUE;
                for(int i = left; i <= right; i++){

                    int num = nums[i];
                    if(num >= max){

                        preIndex = i;
                        max = num;
                    }
                }
            }

            res[index++] = max;
            right++;
            left++;
        }
        return res;
    }
}
