class Solution {
    private boolean isAnagram(String a, String b) {
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
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i=0; i<strs.length; i++) {
            if (vis.contains(i)) {
                continue;
            }

            List<String> smallAns = new ArrayList<>();
            smallAns.add(strs[i]);
            for (int j=i+1; j<strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    vis.add(j);
                    smallAns.add(strs[j]);
                }
            }
            ans.add(smallAns);
        }

        return ans;
    }
}
