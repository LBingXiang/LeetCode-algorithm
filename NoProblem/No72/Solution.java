class Solution {
    static int[][] memo =null;

    public static int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        return minDistance(word1, word2, word1.length()-1, word2.length()-1);
    }

    public static int minDistance(String word1, String word2, int len1, int len2) {
        //base case
        if (len1<0) {
            return len2+1;
        }
        if (len2<0) {
            return len1+1;
        }
        //dp 剪枝
        if (memo[len1][len2] != 0) {
            return memo[len1][len2];
        }

        //状态选择
        if (word1.charAt(len1) == word2.charAt(len2)) {
            return minDistance(word1, word2, len1-1, len2-1);
        }else {
            //增加
            int a = minDistance(word1, word2, len1, len2-1) + 1;
            //替换
            int b = minDistance(word1, word2, len1-1, len2-1) + 1;
            //删除
            int c = minDistance(word1, word2, len1-1, len2) + 1;
            memo[len1][len2] = Math.min(a, Math.min(b, c));
            return memo[len1][len2];
        }
    }
}
