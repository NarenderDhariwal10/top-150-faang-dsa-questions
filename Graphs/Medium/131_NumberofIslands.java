// 🔍 Problem: Number of Islands
// 📝 Link: https://leetcode.com/problems/number-of-islands/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook, Apple

/*
👨‍💻 Problem Statement:
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are surrounded by water.

🧾 Example 1:
Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1

🧾 Example 2:
Input: grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output: 3

*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // boundary + visited check
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return;

        // mark as visited
        grid[r][c] = '0';

        // explore neighbors (up, down, left, right)
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}

/*
🧠 Approach:
- Treat the grid as a graph where each cell is a node.
- Each island is a group of connected '1's (land).
- Traverse the grid:
   - If a cell is '1', it starts a new island → increment counter.
   - Use DFS (or BFS/Union-Find) to "sink" the entire connected component by marking visited cells as '0'.
- Continue until the whole grid is processed.

🛠️ Time Complexity: O(m * n) → visit each cell once
🛠️ Space Complexity: O(m * n) in worst case recursion stack (DFS) 
✅ Status: Accepted on LeetCode
*/
