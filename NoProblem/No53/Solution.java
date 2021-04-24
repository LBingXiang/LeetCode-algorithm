class Solution {
    //很简单
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];

        for(int i = 1; i < nums.length; ++i) {
            sum = sum < 0 ? nums[i] : nums[i]+sum;
            res = Math.max(res, sum);
        }
        return res;
    }
}
