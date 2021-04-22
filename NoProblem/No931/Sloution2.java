class Solution {

  /**
     题目的思路：采用动态规划，从第一层开始，遍历，一直到最后一层结束

     最后再遍历最后一层求，最小值

     状态压缩，空间复杂度压缩
     */
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        //数组的长度
        int n = matrix.length;

        //状态压缩
        int[] dp = new int[n];
        int[] newDp=  new int[n];

        //子函数计算
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                subFunction(matrix, i, j, dp, newDp);
            }

            //数组交换
            int[] temp = dp;
            dp = newDp;
            newDp = temp;
        }

        //求结果
        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    /*
        递归调用，获取值
        i 和 j 表示的是，我们期望求出的值
    */
    private void subFunction(int[][] matrix, int i, int j, int[] dp, int[] newDp ) {

        //base case
        if(i == 0) {
            newDp[j] = matrix[i][j];
            return;
        }

        //计算非第一行的情况，在最左边的情况
        if(j - 1 < 0){
            //不需要计算j-1
            newDp[j] = Math.min(dp[j], dp[j+1]) + matrix[i][j];
            return;
        }

        //在最右边的情况
        if(j + 1 >= matrix.length) {
            newDp[j] = Math.min(dp[j-1], dp[j]) + matrix[i][j];
            return;
        }

        //正常情况
        newDp[j] = Math.min(dp[j], Math.min(dp[j-1], dp[j+1])) + matrix[i][j];
    }
}
