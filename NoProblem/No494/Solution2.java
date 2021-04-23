class Solution {
    /**
        方法一：回溯算法
        方法二：dp数组
        方法三：动态规划
            sum(A) - sum(B) = target
            sum(A) = target + sum(B)
            sum(A) + sum(A) = target + sum(B) + sum(A)
            2 * sum(A) = target + sum(nums)
    */
    public int findTargetSumWays(int[] nums, int target) {
        //求和，以转化为背包问题
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        //此条件下不满足填满的情况
        if(nums.length == 0 || (target + sum) % 2 == 1) {
            return 0;
        }
        //子函数求解
        return subFunction(nums, (sum + target) / 2);
    }

    //背包问题
    private int subFunction(int[] nums, int sum) {
        int len = nums.length;
        //dp
        int[][] dp = new int[len+1][sum+1];

        //base case 当sum 为0 的时候，只有不装，所以为1
        for(int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        //迭代计算
        for(int i = 1; i <= len; i++) {
            //不用等于0 ，因为base case中已经对所有1赋值了
            for(int j = 0; j <= sum; j++) {
                //空间充足
                if(j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                    //空间不足
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }

}
