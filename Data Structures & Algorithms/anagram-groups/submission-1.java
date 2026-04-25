class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            int[] count = new int[26];
            for (char c:strs[i].toCharArray()) {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);

            ans.putIfAbsent(key, new ArrayList<>());
            ans.get(key).add(strs[i]);
        }

        return new ArrayList<>(ans.values());
    }
}
