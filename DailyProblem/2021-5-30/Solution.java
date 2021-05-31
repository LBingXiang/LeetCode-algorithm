class Solution {
    public boolean isPowerOfFour(int n) {

        //如果求余不为0，且数不是1，一定不是4的幂
        if(n % 4 != 0 && n != 1 || n == 0)
            return false;
        
        //循环判断
        boolean isNeedNum = false;

        while(n >= 4) {
            if(n % 4 != 0)
                return false;

            //上一个分支走下来，一定能被整除
            n = n / 4;
        }
        //同时处理n为1的情况
        return n == 1;
    }
}
