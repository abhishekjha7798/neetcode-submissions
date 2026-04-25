class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}
class PrefixTree {
    TrieNode root; 
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

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()) {
            int pos = c - 'a';
            if (curr.children[pos] == null) {
                return false;
            }
            curr = curr.children[pos];
        }
        return true;
    }
}
