class Solution {
    /**
        其实相同就是前文的1143的最长公共子串
        然后返回：word1长度 - n  + word2长度 - m 
    */
    public int minDistance(String word1, String word2) {
        int len = word1.length() > word2.length() ? subLongestCommonSubsequence(word1, word2) : subLongestCommonSubsequence(word2, word1);

        return word1.length() + word2.length() - 2*len;
    }

    //最长公共子序列，感觉递增子序列这一类的很类似，只不过公共的是二维的
    public int subLongestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        //dp[][]二维数组，当dp[0][j] = 0, dp[i][0] = 0
        int[] dp = new int[len2+1];
        int[] newDp = new int[len2+1];

        //因为下标为0的时候最长递增子序列为0，所以不需要计算
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                
                //因为计算时从下向上计算的，所以只需要相邻的一个状态，并且从左向右
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    newDp[j] = dp[j-1] + 1;
                } else {
                    newDp[j] = Math.max(dp[j], newDp[j-1]);
                } 
            }

            //交换位置
            int[] temp = newDp;
            newDp = dp;
            dp = temp;
        }
        return dp[len2];
    }
}
