class Solution {
    public int countGoodRotations(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        long total = 0;
        long sum1 = 0;

       
        for (int num : nums) {
            total += num;
        }

        
        for (int i = 0; i < half; i++) {
            sum1 += nums[i];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (2L * sum1 > total) {
                ans++;
            }

            
            sum1 -= nums[i];
            sum1 += nums[(i + half) % n];
        }

        return ans;
    }
}