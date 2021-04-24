class Solution {
    /**
     最长公共子序列的变种问题:
     思路:
     1.排序：按照一维空间，从小到大；二维空间从大到小
     2.求二维最长递增子序列值，则为信封最多嵌套多少个
     注意：宽和高都必须大于不能是等于
     */
    public int maxEnvelopes(int[][] envelopes) {

        // 重写排序规则，按照envelopes[][0] 升序   envelopes[][1] 降序
        Arrays.sort(envelopes, (arr1, arr2) -> arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr1[0] - arr2[0]);

        //求最长递增子序列：方法一 动态规划 O(n^2)
        int max = 0;
        int[] len = new int[envelopes.length];
        Arrays.fill(len, 1);

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1]  < envelopes[i][1]) {
                    len[i] = Math.max(len[j]+1, len[i]);
                }
            }
            max = Math.max(max, len[i]);
        }

        return max;
    }
}
