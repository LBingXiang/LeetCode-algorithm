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
    //一旦牵扯到树，递归则是很适合
    public void flatten(TreeNode root) {

        if(root == null)
            return;

        //将左右子树拉直
        flatten(root.left);
        flatten(root.right);

        TreeNode l = root.left;
        TreeNode r = root.right;

        root.left = null;
        root.right = l;

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = r;
    }
}
