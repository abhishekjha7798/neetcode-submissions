class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    class PrefixTree {
        public TrieNode root; 
        public PrefixTree() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                int pos = c - 'a';
                if (curr.children[pos] == null) {
                    curr.children[pos] = new TrieNode();
                }
                curr = curr.children[pos];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(char c:word.toCharArray()) {
                int pos = c - 'a';
                if (curr.children[pos] == null) {
                    return false;
                }
                curr = curr.children[pos];
            }
            return curr.isEndOfWord;
        }
    }
    public void dfs(char[][] board, int i, int j, TrieNode root, StringBuilder sb, boolean[][] visited, Set<String> ans) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || root.children[board[i][j] - 'a'] == null) {
            return;
        }
        sb.append(board[i][j]);
        visited[i][j] = true;
        TrieNode next = root.children[board[i][j] - 'a'];
        if (next.isEndOfWord) ans.add(sb.toString());
        // System.out.println(sb.toString());
        dfs(board, i + 1, j, next, sb, visited, ans);
        dfs(board, i, j + 1, next, sb, visited, ans);
        dfs(board, i - 1, j, next, sb, visited, ans);
        dfs(board, i, j - 1, next, sb, visited, ans);
        sb.setLength(sb.length() - 1);
        visited[i][j] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree trie = new PrefixTree();
        for (String word:words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> ans = new HashSet<>();
        for (int i = 0; i<board.length;i++) {
            for (int j = 0; j<board[0].length;j++) {
                dfs(board, i, j, trie.root, new StringBuilder(), visited, ans);
            }
        }
        
        return new ArrayList<>(ans);
    }
}
