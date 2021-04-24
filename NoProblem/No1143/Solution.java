class Solution {
    //最长公共子序列，感觉递增子序列这一类的很类似，只不过公共的是二维的
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        //dp[][]二维数组，当dp[0][j] = 0, dp[i][0] = 0，未进行状态压缩
        int[][] dp = new int[len1+1][len2+1];

        //因为下标为0的时候最长递增子序列为0，所以不需要计算
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }
        return dp[len1][len2];
    }
}
