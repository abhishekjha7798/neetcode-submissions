class Solution {
    // xyzwzzrbghj
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i = 0, j = 0, ans = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while(i < n && j < n) {
            if (!seen.containsKey(s.charAt(j))) {
                seen.put(s.charAt(j), j);
                ans = Math.max(j-i+1, ans);
                j++;
            } else {
                int temp = seen.get(s.charAt(j));
                while (i <= temp) {
                    if (seen.get(s.charAt(i)) <= temp) {
                        seen.remove(s.charAt(i));
                    }
                    i++;
                }
            }
        }
        return ans;
    }
}
