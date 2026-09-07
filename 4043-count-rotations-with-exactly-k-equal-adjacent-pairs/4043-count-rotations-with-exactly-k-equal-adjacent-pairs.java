class Solution {
    public int countRotations(String s, int k) {

        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int score = 0;
            for(int j = i; j < s.length() + i - 1; j++) {
                if(s.charAt(j % s.length()) == s.charAt((j + 1) % s.length())) {
                    score++;
                }
            }
            if(score == k) {
                ans++;
            }
        }
        return ans;
    }
}