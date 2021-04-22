class Solution {

    int[][] dp;

    /**
        题目的思路：采用动态规划，从第一层开始，遍历，一直到最后一层结束

        最后再遍历最后一层求，最小值
    */
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        //数组的长度
        int n = matrix.length;
        dp = new int[n][n];

        //子函数计算
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                subFunction(matrix, i, j);
            }
        }

        //求结果
        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

    /*
        递归调用，获取值
        i 和 j 表示的是，我们期望求出的值
    */
    private void subFunction(int[][] matrix, int i, int j) {

        //base case
        if(i == 0) {
            dp[i][j] = matrix[i][j];
            return;
        }

        //计算非第一行的情况，在最左边的情况
        if(j - 1 < 0){
            //不需要计算j-1
            dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
            return;
        }

        //在最右边的情况
        if(j + 1 >= matrix.length) {
            dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];
            return;
        }

        //正常情况
        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1])) + matrix[i][j];
    } 
}
