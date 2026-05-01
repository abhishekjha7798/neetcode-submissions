class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int k = 0;
        while(k < n) {
            int i = k, j = k;
            while (i >= 0 && j < n) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans++;
                    i--;j++;
                } else {
                    break;
                }
            }
            i = k; j = k+1;
            while (i >= 0 && j < n) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans++;
                    i--;j++;
                } else {
                    break;
                }
            }
            k++;
        }

        return ans;
    }
}
