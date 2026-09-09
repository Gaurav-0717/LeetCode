class Solution {
    public int reverse(int x) {
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }
        int reverse=0;
        while(x!=0){
            int digit= x%10;
            if (reverse < Integer.MIN_VALUE/10 || reverse > Integer.MAX_VALUE/10) {
                return 0;
            }
            if(digit==0){
                reverse = reverse*10;
            }else{
                reverse=reverse * 10 + digit;
            }
            
            x/=10;
        }

        

        return reverse;
    }
}