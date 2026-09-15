class Solution {
    public static boolean isValid(int[] weights, int days, int capacity){
        int sum = 0;
        int count = 1;
        for(int num:weights){
            if(num>capacity){
                return false;
            }
            sum+=num;

            if(sum>capacity){
                count++;
                sum = num;
            }
        }
        
        return count<=days;
    }
        

    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;

        int sum = 0;
        for(int num : weights){
            sum+=num;
        }
        high = sum;

        int ans = high;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(isValid(weights,days,mid)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }

        return ans;
    }
}