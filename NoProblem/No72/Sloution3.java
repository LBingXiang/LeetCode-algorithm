class Solution {

    public int minDistance(String word1, String word2) { 
        //无论从word1 到 word2, 还是反过来，本质上都是一样的，所以增加这个哦按段的步骤，是为了实现O(min(n, m))
        //但时间是不受影响的，因为都需要遍历n * m次
        if( word1.length() > word2.length()) {
            return subMinDistance(word1, word2);
        }
        return subMinDistance(word2, word1);
    }
    /**
        迭代 + dp table
    */
    public int subMinDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        //解决边界问题
        if(n == 0) {
            return m;
        }
        if(m == 0) {
            return n;
        }

        int[] dp = new int[n+1];
        int[] newDp = new int[n+1];
        //base case
        for(int j = 1; j <= n; j++) {
            //dp[0][j] = j;
            dp[j] = j;
        }

        //因为dp[i][j] 值取决于三个值，也就是dp[i][j-1]  dp[i-1][j]  dp[i-1][j-1]
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //base case
                newDp[0] = i;

                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    newDp[j] = dp[j-1];
                //从增加、删除、替换中选择最小的
                } else {
                    newDp[j] = Math.min(dp[j-1] + 1, Math.min(newDp[j-1] + 1, dp[j] + 1));
                }
            }

            int[] temp = dp;
            dp = newDp;
            newDp = temp;
        }
        return dp[n];
    }
}
