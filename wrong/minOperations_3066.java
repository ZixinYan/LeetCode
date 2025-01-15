import java.util.PriorityQueue;

public class minOperations_3066 {
    /* 暴力枚举
    public static int[] removeElements(int[] arr, int min1, int min2) {
        int[] temp = new int[arr.length - 1];
        int flag = 0;
        for (int j : arr) {
            if (j != min1 && j != min2) {
                temp[flag] = j;
                flag++;
            }
        }
        temp[flag] = min1 * 2 + min2;
        return temp;
    }


    public static int minOperations(int[] nums, int k) {
        int res =  0;
        while(true) {
            int min1 =  Integer.MAX_VALUE;
            int min2 =  Integer.MAX_VALUE;
            for (int i = 0 ; i < nums.length; i++) {
                if (nums[i] < min1) {
                    min2 = min1;
                    min1 = nums[i];
                } else if (nums[i] < min2) {
                    min2 = nums[i];
                }else if(nums[i] == min2 && min2 < 999999999){
                    int temp = nums[i] + 1;
                    if(temp == k){
                        res++;
                        nums[i] = temp;
                    }else{
                        nums[i] = temp;
                    }
                }
            }
            if(min1 >= k){
                break;
            }
            if(nums.length != 1) {
                nums = removeElements(nums, min1, min2);
            }
            res++;
        }
        return res;
    }
 */

    public static int minOperations(int[] nums, int k) {
            int res = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (long num : nums) {
                pq.offer(num);
            }
            while (pq.peek() < k) {
                long x = pq.poll(), y = pq.poll();
                pq.offer(x + x + y);
                res++;
            }
            return res;
    }



    public static void main(String[] args) {
        int[] nums = {39,100,81,98,59,39,20,25,11};
        int k = 39;
        System.out.println(minOperations(nums,k));
    }
}
