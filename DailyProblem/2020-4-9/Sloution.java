class Solution {
    /*
        和昨天的题解很类似，唯一的区别是如果是重复数组怎么处理
        我想的是如果是l == m == r，就直接更改为线性遍历？或者移动左右边界
    */
    //需要利用排序的性质，因为数组元素不重复所以比较方便
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            //防止溢出
            int mid = l + (r  - l) / 2;
            //此时最小值在左边区间
            //(nums[mid] >=  nums[l] && nums[mid] < nums[r]) || (nums[mid] <= nums[l] && nums[mid] < nums[r])
            if(nums[mid] < nums[r]) {
                r = mid;            
            //此时区间值在右边
            }  else if (nums[mid] > nums[r] ) {
                l = mid+1;
            } else {
                r--;
            }
            
        }
        return nums[l];
    }
}
