class Task_8 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;    // number of rows
        int n = matrix[0].length; // number of columns
        
        // The new matrix has swapped dimensions: n rows and m columns
        int[][] result = new int[n][m];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // Flip the indices
                result[col][row] = matrix[row][col];
            }
        }
        
        return result;
    }
}
