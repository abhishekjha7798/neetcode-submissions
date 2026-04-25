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
        List<Integer> sz = new ArrayList<>();

        int flip = 0;
        int i = 0;
        while (i<str.length()) {
            char c = str.charAt(i);
            if (c == '#' && flip == 0) {
                flip = 1;
                i++;
                continue;
            }
            if (flip == 0) {
                if (c == ',') continue;
                String num = "";
                while (str.charAt(i) >= '0' && str.charAt(i)<='9') {
                    num += str.charAt(i);
                    i++;
                }
                sz.add(Integer.parseInt(num));
            } else {
                int st = i;
                for (int j:sz) {
                    System.out.println(j);
                    System.out.println(str.substring(st, st+j));
                    ans.add(str.substring(st, st+j));
                    st+=j;
                }
                break;
            }
            i++;
        }
        if (ans.isEmpty()) {
            for (int j:sz)
                ans.add("");
        }
        return ans;
    }
}
