此问题是动态规划的经典问题：
</br>
我采用的是从下向上的方式计算

![image](https://user-images.githubusercontent.com/47679525/115676965-a4bf2b80-a382-11eb-9acc-1231a85b7669.png)

> 大概思路就是，第一层一定都是matri的值，我们将第一行中防止为这个值，这样第二行的dp[i][j]的值，就等于上面一行dp[i-1][j / j-1/ j+1]（需要考虑边界）；
></br>
