class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        HashSet<Integer> leftSet = new HashSet<Integer>();
        HashSet<Integer> rightSet = new HashSet<Integer>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int tempI = i;
                int tempJ = j;
                while(i - 1 >= 0 && j - 1 >= 0){
                    if(!leftSet.contains(grid[i-1][j-1])) {
                        leftSet.add(grid[i - 1][j - 1]);
                    }
                    i--;
                    j--;
                }
                i = tempI;
                j = tempJ;
                while(i + 1 < n && j + 1 < m){
                    if(!rightSet.contains(grid[i+1][j+1])) {
                        rightSet.add(grid[i + 1][j + 1]);
                    }
                    i++;
                    j++;
                }
                i = tempI;
                j = tempJ;
                res[i][j] = Math.abs(leftSet.size() - rightSet.size());
                leftSet.clear();
                rightSet.clear();
            }
        }
        return res;
    }
}


// faster
class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        for (int k = 1; k < m + n; k++) {
            int minJ = Math.max(n - k, 0);
            int maxJ = Math.min(m + n - 1 - k, n - 1);

            long set = 0;
            for (int j = minJ; j <= maxJ; j++) {
                int i = k + j - n;
                ans[i][j] = Long.bitCount(set); // 计算 set 中 1 的个数
                set |= 1L << grid[i][j];  // 把 grid[i][j] 加到 set 中
            }

            set = 0;
            for (int j = maxJ; j >= minJ; j--) {
                int i = k + j - n;
                ans[i][j] = Math.abs(ans[i][j] - Long.bitCount(set));
                set |= 1L << grid[i][j];
            }
        }
        return ans;
    }
}