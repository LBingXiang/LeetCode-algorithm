class Solution {

    //因为旋转数组时从后向前旋转的本题的时间复杂度
    //最坏为O(n) 最好为O(1), 所以平均为O(n/2)  -> O(n)
    //思路简单，但是面试的时候，肯定不能要求使用这种方式
    public int findMin(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < nums[0]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
