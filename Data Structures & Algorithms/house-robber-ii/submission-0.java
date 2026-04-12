class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robHelp(nums, 0), robHelp(nums, 1));
    }

    public int robHelp(int[] nums, int s) {
        int includeLast = (s == 0) ? 1: 0;
        int n = nums.length - 1;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[s];

        for (int i=2;i<=n;i++) {
            dp[i] = Math.max(dp[i-2] + nums[s + i - 1], dp[i-1]);
        }

        return dp[n];
    }
}
