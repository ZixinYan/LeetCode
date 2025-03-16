class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i = 0;i < m;i++){
            if(matrix[i][0] == 0){
                col = true;
            }
        }
        for(int i = 0;i < n;i++){
            if(matrix[0][i] == 0){
                row = true;
            }
        }
        // use the first row and first column to store the information of the other rows and columns
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set the other rows and columns to 0
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row){
            for(int i = 0;i < n;i++){
                matrix[0][i] = 0;
            }
        }
        if(col){
            for(int i = 0;i < m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}