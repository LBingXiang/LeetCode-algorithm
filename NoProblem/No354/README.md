### 俄罗斯套娃信封问题
> 此问题与最长子串问题解法类似，思路是先按照规则排序，再顺序遍历O(n^2)，或者二分查找O(nlogN)

## 双重循环顺序遍历
> 可以看到十分耗时，所以O(n^2) 的时间复杂度和O(nlogn)差的还是挺多的
> 

![image](https://user-images.githubusercontent.com/47679525/115943289-963b5600-a4e1-11eb-98b7-c20d68802519.png)

## 二分查找真的很快
> 说实话，数组的递增方式，还是连续子数组还是有区别的，问题就在与dp table的定义上，我也是参考了LeetCode的官方题解，才有明白的，解释详情见代码
> 

![image](https://user-images.githubusercontent.com/47679525/115944727-0c43bb00-a4ea-11eb-96be-7c58be87e27f.png)

