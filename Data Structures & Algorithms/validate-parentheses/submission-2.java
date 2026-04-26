class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n < 2 || (n&1) == 1) return false;
        Map<Character, Character> p = Map.of(']', '[', '}', '{', ')', '(');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c:s.toCharArray()) {
            if (p.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top != p.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
