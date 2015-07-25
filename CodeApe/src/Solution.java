import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution ins = new Solution();
        char[][] b = new char[][]{
            new char[]{
                    'a', 'b'
            },
            new char[]{
                    'c', 'd'
            }
        };
        String[] s = new String[]{
                "cdba"
        };
        List<String> result = ins.findWords(b, s);
        for (String str: result)
            System.out.println(str);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }

        // first, insert all words into Trie
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        // second, do DFS on the board, and return when (startsWith == false)
        int m = board.length;
        int n = board[0].length;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(set, board, new boolean[m][n], trie, "", m, n, i, j);
            }
        }
        for (String str: set) {
            result.add(str);
        }
        return result;
    }

    public void dfs(Set<String> set, char[][] board, boolean[][] visited, Trie trie,
                    String path, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            // invalid position
            return;
        } else if (visited[x][y]) {
            // already visited position
            return;
        }

        // add the current char into path
        String newPath = path + board[x][y];
        if (!trie.startsWith(newPath)) {
            return;
        } else if (trie.search(newPath)) {
            // one result is found
            set.add(newPath);
        }

        // for 4 different neighbor locations, do DFS
        visited[x][y] = true;
        for (int i = -1; i <= 1; i += 2) {
            // x-axis
            dfs(set, board, visited, trie, newPath, m, n, x + i, y);
            // y-axis
            dfs(set, board, visited, trie, newPath, m, n, x, y + i);
        }
        visited[x][y] = false;
    }
}

// if this code passes, try move the 'set/reset visted flag' code into for loop

class TrieNode {
    char value;
    boolean wordEnd;
    TrieNode[] child;

    public TrieNode() {
        value = 0;
        wordEnd = false;
    }

    public void insert(String str) {
        if (str == null || str.length() == 0) {
            wordEnd = true;
            return;
        }
        if (child == null) {
            // lazy instantiating
            child = new TrieNode['z' - 'a' + 1];
        }
        // remember that 'insert' does not affect current node's value
        // it only affect chlid array
        int firstIndex = (int) (str.charAt(0) - 'a');
        if (child[firstIndex] == null) {
            child[firstIndex] = new TrieNode();
            // actually, for the purpose of this question, 
            // we don't really main what TrieNode.value is
            // but it's good to put it there for debugging purpose
            child[firstIndex].value = str.charAt(0);
        }
        child[firstIndex].insert(str.substring(1));
    }

    public TrieNode find(String str) {
        if (str == null || str.length() == 0) {
            return this;
        }

        int firstIndex = (int) (str.charAt(0) - 'a');
        if (child == null || child[firstIndex] == null) {
            return null;
        }
        return child[firstIndex].find(str.substring(1));
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tail = root.find(word);
        return (tail != null && tail.wordEnd);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tail = root.find(prefix);
        return tail != null;
    }
}
