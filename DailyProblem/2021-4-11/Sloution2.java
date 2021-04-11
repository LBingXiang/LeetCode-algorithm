class Solution {

    //参考丑数Ⅱ
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp =  new int[n];
        dp[0] = 1;

        //下标 
        int[] p = new int[primes.length];
        //按照规则顺序生成丑数
        for(int i = 1; i < n; i++) {

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                    min = dp[p[j]] * primes[j] < min ? dp[p[j]] * primes[j] : min;               
            }

            //最重要的是解决重复数字
            for(int j = 0; j < primes.length; j++) {
                    if (min  == dp[p[j]] * primes[j])
                        p[j]++;
            }

            dp[i] = min;
        }
        return dp[n-1];
    }

}
