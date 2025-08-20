// 🔍 Problem: Sudoku Solver
// 📝 Link: https://leetcode.com/problems/sudoku-solver/
// 🎯 Difficulty: Hard
// 🏢 Asked In: Google, Amazon, Microsoft, Facebook, Apple

/*
📝 Problem Statement:
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:
1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column.
3. Each of the digits 1-9 must occur exactly once in each of the 9 sub-boxes of the grid.

The '.' character indicates empty cells.

You may assume that the input board has only one solution.

-
🧾 Example:
Input: 
board = [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]

Output: 
[
  ["5","3","4","6","7","8","9","1","2"],
  ["6","7","2","1","9","5","3","4","8"],
  ["1","9","8","3","4","2","5","6","7"],
  ["8","5","9","7","6","1","4","2","3"],
  ["4","2","6","8","5","3","7","9","1"],
  ["7","1","3","9","2","4","8","5","6"],
  ["9","6","1","5","3","7","2","8","4"],
  ["2","8","7","4","1","9","6","3","5"],
  ["3","4","5","2","8","6","1","7","9"]
]
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // if no number works
                }
            }
        }
        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // check row
            if (board[i][col] == c) return false; // check column
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false; // check 3x3 box
        }
        return true;
    }
}

/*
🧠 Approach:
1. Use **Backtracking** to try filling each empty cell with digits 1–9.
2. For each empty cell:
   - Try placing a digit if it’s valid (row, column, and 3x3 subgrid check).
   - If placing works, recurse to the next cell.
   - If recursion fails, undo the choice (backtrack).
3. Stop when all cells are filled (board solved).

--------------------------------------------------
🛠️ Time Complexity: O(9^(M)) → M = number of empty cells, each has up to 9 choices
🛠️ Space Complexity: O(M) → recursion depth

✅ Status: Accepted on LeetCode
*/
