此问题是动态规划的经典问题：
</br>
我采用的是从下向上的方式计算

![image](https://user-images.githubusercontent.com/47679525/115676965-a4bf2b80-a382-11eb-9acc-1231a85b7669.png)

> 大概思路就是，第一层一定都是matri的值，我们将第一行中防止为这个值，这样第二行的dp[i][j]的值，就等于上面一行dp[i-1][j / j-1/ j+1]（需要考虑边界）；
></br>
>

第一中的dp为O(n^2)的空间复杂度，其实在运行过程中，我们只需要当前的一行和上一行，这样空间复杂就能降低为O(2n)， 也就是O(n)
> 但LeetCode的提交十分魔幻，本来应该减小很多的，但每次提交却不稳定
> 

![image](https://user-images.githubusercontent.com/47679525/115688638-e7d2cc00-a38d-11eb-9e24-dadaaa71219c.png)
