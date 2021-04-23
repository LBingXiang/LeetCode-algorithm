class Solution {
    /**
        双重循环查找： 时间复杂度O(n^2) 空间复杂度O(n)
    */
    public int lengthOfLIS(int[] nums) {
        //dp
        int[] len = new int[nums.length];

        //每个字符串的递增子串至少为1
        Arrays.fill(len, 1);

        //返回值
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i])  {
                    len[i] = Math.max(len[i], len[j]+1);
                }
            }
            //得出计算结果就判断，减少之后再循环
            max = Math.max(max, len[i]);
        }
        return max;
    }
}
