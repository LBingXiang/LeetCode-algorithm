1143. 最长公共子序列

可以采用迭代的方式，自低向上的方式，迭代进行，最后可以进行优化，采用状态压缩

### 动态规划（未进行状态压缩）
![image](https://user-images.githubusercontent.com/47679525/115950865-69526780-a510-11eb-94de-220e8395ee35.png)

### 动态规划 + 状态压缩
> 时间复杂度未变O(m * n) 空间复杂度优化为O (min(m , n))
> 可以看到在优化空间后，时间也有一定的提升，可能在大数组的申请上面耗时减少的原因
> 

![image](https://user-images.githubusercontent.com/47679525/115951475-7b81d500-a513-11eb-86ff-c9e00bae21f5.png)
