class Solution {

    /*
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
        int[] dp = new int[sum+1];

        //base case 当sum 为0 的时候，只有不装，所以为1
            dp[0] = 1;

        //迭代计算
        for(int i = 1; i <= len; i++) {
            //需要为0 因为数组中，可能存在值为0 的情况
            //从后向前遍历，因为dp[j] 依赖前面的数组，倘若从前往后，会导致数组被覆盖；或者采用双数组的方式
            for(int j = sum; j >= 0; j--) {
                //空间充足
                if(j >= nums[i-1]) {
                    dp[j] = dp[j] + dp[j - nums[i-1]];
                //空间不足
                } else {
                    dp[j] = dp[j];
                }
            }
        } 
        return dp[sum];
    }

}
