[654. 最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree/)

思路很简单：
1.寻找指定下标范围内的最大值，构造root
2.将左边数组的递归调用，并赋值给root.left 
3.右边数组同理</br>

> 因为数组时无序的，所以只能采用全表扫描的方式时间为O(n)
  
  ![image](https://user-images.githubusercontent.com/47679525/114021773-a4636280-98a3-11eb-9443-214dd7314c2c.png)
