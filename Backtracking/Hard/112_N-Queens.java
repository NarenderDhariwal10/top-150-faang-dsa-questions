// 🔍 Problem: N-Queens
// 📝 Link: https://leetcode.com/problems/n-queens/
// 🎯 Difficulty: Hard
// 🏢 Asked In: Amazon, Microsoft, Google, Adobe

/*
📝 Problem Statement:
The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
such that no two queens attack each other.

Given an integer `n`, return all distinct solutions to the n-queens puzzle. 
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space, respectively.

-
🧾 Example 1:
Input: n = 4
Output: [
 [".Q..",
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",
  "Q...",
  "...Q",
  ".Q.."]
]

🧾 Example 2:
Input: n = 1
Output: [["Q"]]
*/

import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(result, board, 0, n);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}

/*
🧠 Approach:
1. Place queens row by row using **Backtracking**.
2. At each row, try placing a queen in every column.
   - Before placing, check if it's **safe**:
     - No queen in the same column.
     - No queen in the upper-left diagonal.
     - No queen in the upper-right diagonal.
3. If safe → place queen and move to the next row.
4. If all rows are filled → add configuration to result.
5. Backtrack by removing the queen and trying next position.

--------------------------------------------------
🛠️ Time Complexity: O(N!) → Each row has N choices, pruned by constraints.
🛠️ Space Complexity: O(N^2) → To store the board + recursion depth.

✅ Status: Accepted on LeetCode
*/
