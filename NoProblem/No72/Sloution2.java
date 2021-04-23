class Solution {
    /**
        迭代 + dp table
    */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        //base case
        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        //因为dp[i][j] 值取决于三个值，也就是dp[i][j-1]  dp[i-1][j]  dp[i-1][j-1]
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                //从增加、删除、替换中选择最小的
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                }
            }
        }

        return dp[m][n];
    }
}
