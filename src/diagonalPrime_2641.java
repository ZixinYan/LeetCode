class Solution {
    public boolean ifPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2;i <= Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 0;i < n;i++){
            if(ifPrime(nums[i][i])){
                res = Math.max(res,nums[i][i]);
            }
            if(ifPrime(nums[i][n - i - 1])){
                res = Math.max(res,nums[i][n - i - 1]);
            }
        }
        return res;
    }
}


class Solution {
    public int diagonalPrime(int[][] nums) {
        int max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i][i] > max && check(nums[i][i])) {
                max = Math.max(max, nums[i][i]);
            }
            if (nums[i][n - i - 1] > max && check(nums[i][n - i - 1])) {
                max = Math.max(max, nums[i][n - i - 1]);
            }
        }
        return max == 1 ? 0 : max;
    }

    private boolean check(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}