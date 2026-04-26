class Solution {
    // xyzwzzrbghj
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i = 0, j = 0, ans = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while(i < n && j < n) {
            if (seen.containsKey(s.charAt(j))) {
                i = Math.max(seen.get(s.charAt(j)) + 1, i);
            }
            seen.put(s.charAt(j), j);
            ans = Math.max(j-i+1, ans);
            j++;
        }
        return ans;
    }
}
