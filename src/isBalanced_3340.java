class Solution {
    public boolean isBalanced(String num) {
        int n = num.length();
        boolean flag = true;
        int res = 0;
        for(int i = 0;i < n;i++){
            if(flag){
                res += num.charAt(i) - '0';
                flag = false;
            }else{
                res -= num.charAt(i) - '0';
                flag = true;
            }
        }

        if(res == 0){
            return true;
        }else{
            return false;
        }

    }
}