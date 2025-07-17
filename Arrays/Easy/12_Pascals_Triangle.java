// 🔍 Problem: Pascal's Triangle  
// 📝 Link: https://leetcode.com/problems/pascals-triangle/  
// 🎯 Difficulty: Easy  
// 🏢 Asked in: Amazon, Google, Adobe  

/*
👨‍💻 Problem Statement:
Given an integer `numRows`, return the first `numRows` of Pascal's Triangle.

In Pascal’s Triangle:
- Each number is the sum of the two numbers directly above it.

🧾 Example:
Input: numRows = 5
Output:
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col <= row; col++) {
                // First and last element of each row is always 1
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    int left = triangle.get(row - 1).get(col - 1);
                    int right = triangle.get(row - 1).get(col);
                    currentRow.add(left + right);
                }
            }

            triangle.add(currentRow);
        }

        return triangle;
    }
}

/*
🧠 Approach:
- Start with the first row as [1].
- For each new row, use the values from the previous row to compute new values.
- Every row starts and ends with 1.

🛠️ Time Complexity: O(numRows^2)
🛠️ Space Complexity: O(numRows^2)

✅ Status: Accepted on LeetCode
*/
