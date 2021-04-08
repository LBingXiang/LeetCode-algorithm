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
    /*
        方式有两种：
            1、赋值新数组
            2、根据下标
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubtree(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1);

    }

    private TreeNode buildSubtree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){

        //base
        if(pl > pr || il > ir)
            return null;

        //前序遍历的第一个结点，将中序划分为两部份
        int index = il;
        while(inorder[index] != preorder[pl]) {
            index++;
        }
        
        int leftLength = index - il;
        int rightLength = ir - index;

        TreeNode root = new TreeNode(inorder[index]);
        //一定要注意传递的值
        root.left = buildSubtree(preorder, pl+1, pl+leftLength, inorder, il, il+leftLength-1);
        root.right = buildSubtree(preorder, pl+leftLength+1, pr, inorder, index+1, ir);

        return root;
    }
}
