[105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
[106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
> 两个题目十分类似，因此放在一起说明，以前序+中序为例</br>

此问题解有两种，递归和迭代，我采用的是递归的方式，两者的时间的复杂度都是O(n)：

其实本质上只需要抓住：</br>

前序遍历  =  [根节点][左子树的前序遍历][右子树的前序遍历]</br>

后序遍历  =  [左子树的后序遍历][右子树的后序遍历][根节点]</br>

而中序遍历实质上就是 [左子树中序遍历][根][右子树的中序遍历]</br>

我们可以通过 前序+中序 或者 后序+ 中序 还原一棵树，所以只要理解了这个核心思想，问题便迎刃而解

> 问题是我提交的代码，运行速度不快</br>

前序+中序：</br>
![image](https://user-images.githubusercontent.com/47679525/114023995-19379c00-98a6-11eb-84f0-a342aabdf373.png)
</br>
后序+中序</br>
![image](https://user-images.githubusercontent.com/47679525/114024038-28b6e500-98a6-11eb-9134-358c57815c01.png)
