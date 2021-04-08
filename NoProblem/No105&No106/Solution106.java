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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildSubtree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildSubtree(int[] postorder, int pl, int pr, int[] inorder, int il, int ir){

        //base
        if(pl > pr || il > ir)
            return null;

        //前序遍历的第一个结点，将中序划分为两部份
        int index = il;
        while(inorder[index] != postorder[pr]) {
            index++;
        }
        
        int leftLength = index - il;
        int rightLength = ir - index;

        TreeNode root = new TreeNode(inorder[index]);

        //一定要注意传递的值
        root.right = buildSubtree(postorder, pr-rightLength, pr-1, inorder, index+1, ir);
        root.left = buildSubtree(postorder, pl, pr-rightLength-1, inorder, il, index-1);

        return root;
    }
}
