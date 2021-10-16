package Algorithm;

public class Palindrome {
    public boolean isPalindrome(int x) {
        int res = 0;
       if(x>=0){
           int y=x;
           while (x != 0) {
               int tmp = res * 10 + x % 10;
               if (tmp / 10 != res) { // 溢出!!!
                   return false;
               }
               res = tmp;
               x /= 10;
           }
           if(res==y){
               return true;
           }else {
               return false;
           }
       }else{
           return false;
       }
    }
    public boolean isPalindrome2(int x){
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int number=0;
        while (number<x){
            number=number*10+x%10;
            x/=10;
        }
        return number/10==x||number==x;
    }
}
