class Solution {
    // ABBBACBB 2
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int i = 0, j = 0, ans = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxF = 0;
        while (j < n) {
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
            maxF = Math.max(maxF, freq.get(s.charAt(j)));

            while ((j - i + 1) - maxF > k) {
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
