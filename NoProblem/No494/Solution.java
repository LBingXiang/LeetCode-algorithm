class Solution {

    /*
        方法一：回溯算法
        方法二：dp数组
    */
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }

        return subFunction(nums, 0, target);
    }

    //dp 数组 实现剪枝
    HashMap<String, Integer> dp = new HashMap<>();

    private int subFunction(int[] nums, int i, int res) {
        //base case
        if(i == nums.length) {
            if(res == 0) {
                return 1;
            }
            return 0;
        }

        String key = i + "," + res;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int result = subFunction(nums, i+1, res - nums[i]) + subFunction(nums, i+1, res + nums[i]);
        dp.put(key, result);

        return result;
    }
}
