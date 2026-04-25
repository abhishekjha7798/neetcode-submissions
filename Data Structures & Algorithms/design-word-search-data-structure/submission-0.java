class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c:word.toCharArray()) {
            int ind = c-'a';
            if (curr.children[ind] == null) {
                curr.children[ind] = new TrieNode();
            }
            curr = curr.children[ind];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(TrieNode root, String word, int st) {
        TrieNode curr = root;

        int i = st;
        while(i < word.length()) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j<26; j++) {
                    if (curr.children[j] != null && search(curr.children[j], word, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int ind = c-'a';
                if (curr.children[ind] == null) {
                    return false;
                }
                curr = curr.children[ind];
            }
            i++;
        }
        return curr.isEndOfWord;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }
}
