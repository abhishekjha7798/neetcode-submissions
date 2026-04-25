class Solution {
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] seen = new int[26];
        for (char x:a.toCharArray()) {
            int ind = x - 'a';
            seen[ind]++;
        }
        for (char x:b.toCharArray()) {
            int ind = x - 'a';
            seen[ind]--;
        }

        for (int x:seen) {
            if (x!=0) return false;
        }
        return true;
    }
}
