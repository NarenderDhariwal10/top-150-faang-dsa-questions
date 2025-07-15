// 🔍 Problem: Rotate Image
// 📝 Link: https://leetcode.com/problems/rotate-image/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Apple, Facebook

/*
👨‍💻 Problem Statement:
You are given an `n x n` 2D matrix representing an image, rotate the image by 90 degrees (clockwise) in-place.

🧾 Example:
Input:  matrix = [[1,2,3],
                  [4,5,6],
                  [7,8,9]]
Output: [[7,4,1],
         [8,5,2],
         [9,6,3]]
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (rows -> columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements at (i, j) and (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete 90° clockwise rotation
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    // Helper function to reverse a row
    private void reverseRow(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}

/*
🧠 Approach:
- First transpose the matrix (swap i,j with j,i).
- Then reverse each row to simulate a 90-degree clockwise rotation.

🛠️ Time Complexity: O(n^2)
🛠️ Space Complexity: O(1) – Done in-place

✅ Status: Accepted on LeetCode
*/
