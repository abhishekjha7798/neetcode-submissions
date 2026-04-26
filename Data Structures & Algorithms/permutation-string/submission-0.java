class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        Map<Character, Integer> count = new HashMap<>();
        int window = n;
        for (char c:s1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;

        Map<Character, Integer> wCount = new HashMap<>();
        while (r < window-1) {
            wCount.put(s2.charAt(r), wCount.getOrDefault(s2.charAt(r), 0) + 1);
            r++;
        }
        while (r < m) {
            wCount.put(s2.charAt(r), wCount.getOrDefault(s2.charAt(r), 0) + 1);
            boolean sAns = true;
            for (Map.Entry<Character, Integer> entry: count.entrySet()) {
                int cnt = wCount.getOrDefault(entry.getKey(), 0);
                if (entry.getValue() != cnt) {
                    sAns = false;
                }
            }
            if (sAns) return true;
            wCount.put(s2.charAt(l), wCount.get(s2.charAt(l)) - 1);
            l++;r++;
        }
        return false;
    }
}
