[154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)</br>
本题与是四月八号的加强版：区别在于需要处理重复数组：
有两种思路：
  1.缩小边界
  2.改为线性查找

线性查找在极端情况下，还是会退化成线性表,但正常情况下则是logN

内存消耗感觉是个迷，我看了内存消耗很低的，代码基本一样:weary:
![image](https://user-images.githubusercontent.com/47679525/114113677-d01d3180-9911-11eb-829a-5f686e090574.png)
