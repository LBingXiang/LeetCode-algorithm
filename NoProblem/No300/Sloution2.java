class Solution {

    /**
        二分查找法：思路拓展，原理大概能理解
        解释参考：@url https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zi-xu-lie-lei-xing-wen-ti/dong-tai-gui-hua-she-ji-zui-chang-di-zeng-zi-xu-lie
    */
    public int lengthOfLIS(int[] nums) {
        // dp 存储每个排队的最顶层元素，最多数组本身有序，直接堆数为n
        int[] top = new int[nums.length];

        //记录堆的数目，也就是最大纸堆长度
        int len = 0;
        //依次处理数组 遍历时间复杂度O(n)
        for(int i = 0; i < nums.length; i++) {

            //能在堆里面找到位置存放
            int left = 0, right = len;
            //二分查找log(n)
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid]  > nums[i]) {
                    right = mid;
                } else if (top[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }

            //不能再堆里面存放的情况
            if(left == len) {
                len++;
            }
            top[left] = nums[i];
        }

        //堆数就是数组长度
        return len;
    }
}
