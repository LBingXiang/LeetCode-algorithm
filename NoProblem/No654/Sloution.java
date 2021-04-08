/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
        思路很简单：
            1、寻找指定下标范围内的最大值，构造root
            2、将左边数组的递归调用，并赋值给root.left 
            3、右边数组同理

        因为数组时无序的，所以只能采用全表扫描的方式时间为O(n)
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructSubtree(nums, 0, nums.length-1);
    }

    /*
        构建子函数处理
    */
    public TreeNode constructSubtree(int[] nums, int left, int right){

        if(left > right) 
            return null;
        //寻找最大值
        int max = Integer.MIN_VALUE, index = -1;
        for(int i = left; i <= right; i++) {
            if(max < nums[i]) {
                max = nums[i];
                index =  i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        //递归调用
        root.left = constructSubtree(nums, left, index-1);
        root.right = constructSubtree(nums, index+1, right);

        return root;
    }
}
