class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        pre[0] = 1;
        int[] suf = new int[n+1];
        suf[n] = 1;

        for (int i=0; i<n; i++) {
            pre[i+1] = pre[i] * nums[i];
        }

        for (int i=n-1; i>=0; i--) {
            suf[i] = suf[i+1] * nums[i];
        }

        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            ans[i] = pre[i] * suf[i+1];
        }

        return ans;
    }
}  
