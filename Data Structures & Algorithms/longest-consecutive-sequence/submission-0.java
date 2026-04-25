class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen = 0;
        int count = 1;
        int i = 1;
        while(i<nums.length) {
            while (i<nums.length && nums[i] == nums[i-1]) {
                maxLen = Math.max(maxLen, count);
                i++;
            }
            if (i >= nums.length) break;
            if (nums[i] != nums[i-1]+1) {
                maxLen = Math.max(maxLen, count);
                count = 1;
            } else {
                count++;
            }
            i++;
        }
        maxLen = Math.max(maxLen, count);
        return maxLen;
    }
}
