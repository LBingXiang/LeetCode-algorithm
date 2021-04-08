[153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

解法一：
> 虽然时间复杂度为O(n),但肯定不是最优解
![image](https://user-images.githubusercontent.com/47679525/113959597-c2a27180-9855-11eb-94f6-0670e71719cb.png)


解法二：
> 二分查找法 ：时间复杂度为O(log n)
</br>

#### 二分查找法</br>
> 这种题目算二分查找中相对复杂的，于是借此机会再次加深一下二分查找 </br>


二分查找最重要是两个：
  - 边界收缩
  - 终止条件
当这两个条件处理好了，那么问题也将会迎刃而解

首先明确这个题目的情况：

旋转的定义：其实就是将数组最后一个元素放在第一个去，所以只会出现以下情况
```
   1. 未旋转的          2.旋转的  
        *                *
      *                *  
    *                       *
  *                       * 
```

此时我们需要考虑的是收缩情况和mid条件：
1. mid > left  &&  mid < right
> 说明l -> r 的范围之类是单调递增的,最小值在左边，且不为mid</br>
2. mid < left  && mid < right
> 说明l -> r区间包含转折点，此范围先递增，然后降到最低，然后递增。最小值在mid或者mid的左边</br>
3. mid > left && mid > right
> 说明l -> r区间包含转折点，所以此时最小值在mid右边，不为mid</br>

明确了3中情况，我们就需要判断收缩区间方式和终止条件了：

``` java
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
            // 该条件等价于(nums[mid] >=  nums[l] && nums[mid] < nums[r]) || (nums[mid] <= nums[l] && nums[mid] < nums[r])
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
```
![image](https://user-images.githubusercontent.com/47679525/113980589-41f56c80-9879-11eb-9ecf-a6bef1e6c726.png)

其实对于二分查找法来说，只要明确情况，确定边界收缩和终止条件，会容易很多
