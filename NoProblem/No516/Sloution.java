class Solution {
    static int[][] memo = null;
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            memo[i][i] = 1;
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = memo[i+1][j-1] + 2;
                } else {
                    memo[i][j] = Math.max(memo[i][j-1], memo[i+1][j]);
                }
            }
        }
        return memo[0][n-1];
    }    
}
