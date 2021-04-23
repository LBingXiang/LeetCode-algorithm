![image](https://user-images.githubusercontent.com/47679525/115699669-6e8ca680-a398-11eb-872b-334114af7ae2.png)

> 采用dp状态数组 + 迭代方式，效率依旧很低
> 

![image](https://user-images.githubusercontent.com/47679525/115805382-6f185200-a417-11eb-891b-18bf020b678b.png)
> 采用动态规划的方式，可以看到速度已经有质的飞越，但是内存还是那么大，因此可以采用状态压缩的方式，将O(n ^ ((sum + target)/2)) 的空间复杂度进行压缩
> 

![image](https://user-images.githubusercontent.com/47679525/115806077-b226f500-a418-11eb-9c82-dcf0130b1f6a.png)
> 动态规划 + 状态压缩直接起飞好吧，确实就是最优解了。但是LeetCode的提交还是比较玄学的，要多次提交，才能获得一个预期值
