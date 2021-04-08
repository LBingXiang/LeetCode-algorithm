class Solution {

    //需要利用排序的性质，因为数组元素不重复所以比较方便
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while(l < r) {
            //防止溢出
            mid = l + (r  - l) / 2;
            //此时最小值在左边区间
            //(nums[mid] >=  nums[l] && nums[mid] < nums[r]) || (nums[mid] <= nums[l] && nums[mid] < nums[r])
            if(nums[mid] <= nums[r]) {
                r = mid;            
            //此时区间值在右边
            }  else if (nums[mid] > nums[r] ) {
                l = mid+1;
            }
            
        }
        return nums[l];
    }
}
