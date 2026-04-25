class Solution {
    // ["a@pple", "big%", "&tiny"]
    // 6a@pple4big%5&tiny
    // 6,4,5$a@pplebig%&tiny
    public String encode(List<String> strs) {
        if (strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (String str:strs) {
            sb.append(str.length()).append(',');
        }
        sb.append("#");
        for (String str:strs) {
            sb.append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if (str.isEmpty()) return ans;
        List<Integer> sz = new ArrayList<>();

        int l = 0;
        while (str.charAt(l)!='#') {
            StringBuilder len = new StringBuilder();
            while(str.charAt(l)!=',') {
                len.append(str.charAt(l));
                l++;
            }
            sz.add(Integer.parseInt(len.toString()));
            l++;
        }
        l++;
        for(int len:sz) {
            ans.add(str.substring(l, l+len));
            l+=len;
        }

        return ans;
    }
}
