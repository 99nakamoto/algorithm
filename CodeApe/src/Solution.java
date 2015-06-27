import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution ins = new Solution();
        char[][] b = new char[][]{
            new char[]{
                    'a'
            }
        };
        String[] s = new String[]{
                "a"
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
        dfs(result, board, new boolean[m][n], new Trie(), "", m, n, 0, 0);
        return result;
    }

    public void dfs(List<String> result, char[][] board, boolean[][] visited, Trie trie,
                    String path, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            // invalid position
            return;
        } else if (visited[x][y]) {
            // already visited position
            return;
        }

        // process the result
        visited[x][y] = true;
        String newPath = path + board[x][y];
        if (!trie.startsWith(newPath)) {
            // current string does not exist in the trie
            return;
        } else if (trie.search(newPath)) {
            if (!result.contains(newPath)) {
                result.add(newPath);
            }
        }

        // for 4 different neighbor locations, do DFS
        for (int i = -1; i <= 1; i += 2) {
            // x-axis
            dfs(result, board, visited, trie, newPath, m, n, x + i, y);
            // y-axis
            dfs(result, board, visited, trie, newPath, m, n, x, y + i);
        }

        // reset visited flag
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

// test