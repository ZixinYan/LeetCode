class Solution {
    public int minimumSum(int n, int k) {
        int m = Math.min(n,k/2);
        int ans = m *(m+1)/2;
        if(m<n){
            ans+=(2*k + (n-m) -1) * (n-m)/2;
        }
        return ans;
    }
}
