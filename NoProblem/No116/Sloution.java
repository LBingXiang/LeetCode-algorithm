/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    //定义子函数
    public Node connect(Node root) {
        if(root == null)
            return root;

        connect0(root.left, root.right);
        return root;      
    }

    public void connect0(Node l, Node r){
        if(l == null) 
            return;
        
        // base
        l.next = r;

        connect0(l.left, l.right);
        //采用双节点，解决了不同的树的之间无法连接的问题
        connect0(l.right, r.left);
        connect0(r.left, r.right);
    }
}
