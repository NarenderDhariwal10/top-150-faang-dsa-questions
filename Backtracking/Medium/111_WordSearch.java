// 🔍 Problem: Word Search
// 📝 Link: https://leetcode.com/problems/word-search/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Google, Facebook, Bloomberg

/*
📝 Problem Statement:
Given an `m x n` grid of characters `board` and a string `word`, 
return true if `word` exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

-
🧾 Example 1:
Input: board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
], word = "ABCCED"
Output: true

🧾 Example 2:
Input: board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
], word = "SEE"
Output: true

🧾 Example 3:
Input: board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
], word = "ABCB"
Output: false
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // If we found the entire word
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        // explore in 4 directions
        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                        backtrack(board, word, i - 1, j, index + 1) ||
                        backtrack(board, word, i, j + 1, index + 1) ||
                        backtrack(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // backtrack
        return found;
    }
}

/*
🧠 Approach:
1. Use **Backtracking** to search the word starting from each cell.
2. At each step:
   - If the character does not match → return false.
   - If index == word.length() → word found → return true.
   - Mark the current cell as visited (e.g., '#') to avoid reuse.
   - Explore 4 possible directions (up, down, left, right).
   - Backtrack by restoring the original character.
3. Try every starting cell in the board.

--------------------------------------------------
🛠️ Time Complexity: O(M * N * 4^L)
   - M = number of rows, N = number of columns
   - L = length of the word
   - Each cell may branch in 4 directions.
🛠️ Space Complexity: O(L) recursion depth for the word

✅ Status: Accepted on LeetCode
*/
