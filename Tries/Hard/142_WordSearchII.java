// 🔍 Problem: Word Search II
// 📝 Link: https://leetcode.com/problems/word-search-ii/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

/*
👨‍💻 Problem Statement:
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. The same letter cell 
may not be used more than once in a word.

🧾 Example 1:
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

🧾 Example 2:
Input: 
board = [['a','b'],['c','d']], words = ["abcb"]
Output: []
*/

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null; // store complete word at terminal node
}

class Solution {
    private TrieNode root;
    private List<String> result;
    private int rows, cols;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        result = new ArrayList<>();

        // build Trie
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        // backtracking search
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                backtrack(r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.word = word; // mark complete word
    }

    private void backtrack(int r, int c, TrieNode node) {
        // boundary + visited check
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '#') return;

        char ch = board[r][c];
        TrieNode next = node.children[ch - 'a'];
        if (next == null) return;

        // word found
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates
        }

        // mark visited
        board[r][c] = '#';

        // explore neighbors
        backtrack(r + 1, c, next);
        backtrack(r - 1, c, next);
        backtrack(r, c + 1, next);
        backtrack(r, c - 1, next);

        // restore
        board[r][c] = ch;
    }
}

/*
🧠 Approach:
- Use Trie to store all words (efficient prefix lookup).
- Traverse each cell of the board:
   - Start DFS + backtracking if character exists in Trie.
   - Use '#' to mark visited cells temporarily.
   - Store word in result when Trie node indicates word-end.
   - Avoid duplicates by setting node.word = null once found.
- Return all collected words.

🛠️ Time Complexity:
- Building Trie: O(sum of all word lengths)
- Backtracking: O(M * N * 4^L) worst case 
   where M = rows, N = cols, L = max word length
   (but pruning with Trie drastically reduces search space)

🛠️ Space Complexity: O(sum of all word lengths) for Trie + O(L) recursion stack

✅ Status: Accepted on LeetCode
*/
