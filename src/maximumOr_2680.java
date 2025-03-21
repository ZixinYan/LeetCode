// 贪心+前缀和
class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] suf = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }
        long res = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, pre | ((long) nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return res;
    }
}

// 纯贪心 超时
class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long max = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            long temp = (int)Math.pow(2, k) * nums[i];
            max = 0;
            for(int j = 0;j<n;j++){
                if(i==j){
                    max |= temp;
                }else {
                    max |= nums[j];
                }
            }
            res = Math.max(res,max);
        }
        return res;
    }
}

class Solution {
    public long maximumOr(int[] nums, int k) {
        // 把乘2分配给不同的数，不如分配给一个数，这样能够得到更大的答案
        // 反证法。如果答案的长度与修改后的nums[i]一样长，同时还修改了其它的数，那么将修改其它数的*2应用到nums[i]上，可以得到二进制更大的数
        // 如何直接通过allOr(所有值的异或结果)直接去掉x=nums[i]然后直接与x<<k计算
        // 1.使用异或运算直接去掉x，即allOr^x
        // 2.如果x的某位比特为0不影响结果，直接异或去掉即可。
        // 3.如果x的某位比特为1,需要添加修正值（如果有其它值在这位也为1需要异或1进行修正）
        // 4.如何求解修正值？allOr & x == 1则说明某位必然出现两次1 所以只用fixed|(allOr & x)即可求得修正值
        int allOr = 0;
        int fixed = 0;
        for(int x : nums){
            fixed |= allOr & x;
            allOr |= x;
        }
        long res = 0;
        for(int x : nums){
            res = Math.max(res, (allOr ^ x) | fixed | ((long)x << k));
        }
        return res;
    }
}