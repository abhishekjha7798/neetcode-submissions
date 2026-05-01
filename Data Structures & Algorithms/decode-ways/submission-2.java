class Solution {
    private int helper(String s, int i, int n, int[] dp) {
        if (i >= n) return 1;
        if (dp[i] != -1) return dp[i]; 
        char first = s.charAt(i);
        int ans = 0;
        if (first != '0') {
            ans += helper(s, i+1, n, dp);
        }
        if (i < n-1) {
            char second = s.charAt(i+1);
            if (first == '1' || (first == '2' && second <= '6')) {
                ans += helper(s, i+2, n, dp);
            }
        } 
        return dp[i] = ans;
    }
    public int numDecodings(String s) {
        // 123356
        int n = s.length();
        int[] dp = new int[n];
        for (int i=0;i<n;i++) dp[i] = -1;
        return helper(s, 0, n, dp);
    }
}
