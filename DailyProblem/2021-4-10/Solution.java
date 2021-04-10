class Solution {

    //确实参考评论区，就是不断的除 2 3 5，厉害了，洞悉问题的本质
    public boolean isUgly(int n) {
        if(n <= 0) 
            return false;

        while (n%5==0){
            n/=5;
        }
        while (n%3==0){
            n/=3;
        }
        while (n%2==0){
            n>>=1;
        }
        return n == 1;
    }
}
