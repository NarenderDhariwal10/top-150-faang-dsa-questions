// 🔍 Problem: Set Matrix Zeroes
// 📝 Link: https://leetcode.com/problems/set-matrix-zeroes/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Flipkart, Adobe

/*
👨‍💻 Problem Statement:
Given an `m x n` integer matrix, if an element is 0, set its entire row and column to 0.
You must do it **in place**.

🧾 Example:
Input: matrix = [
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: [
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRow = false, firstCol = false;

        // Step 1: Check if first row or first column has zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstCol = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRow = true;
        }

        // Step 2: Use first row/col to mark zeros for rest of matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: Set zeroes based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Set first row and column
        if (firstRow) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (firstCol) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}

/*
🧠 Approach:
- Use the first row and column of the matrix as flags to store which rows and columns should be zeroed.
- Avoid extra space by reusing the matrix itself to track.

🛠️ Time Complexity: O(m * n)
🛠️ Space Complexity: O(1) (in-place solution)

✅ Status: Accepted on LeetCode
*/
