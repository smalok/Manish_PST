class Task_9 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Pre-calculate 2D Prefix Sum
        // sum[i][j] will store the sum of mat from (0,0) to (i-1, j-1)
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = mat[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
            }
        }
        
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 2. Identify the boundaries of the block
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // 3. Use the Prefix Sum formula (adjusting for 1-based sum array)
                ans[i][j] = sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1];
            }
        }
        
        return ans;
    }
}
