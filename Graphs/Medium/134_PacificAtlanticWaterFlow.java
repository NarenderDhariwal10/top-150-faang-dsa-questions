// 🔍 Problem: Pacific Atlantic Water Flow
// 📝 Link: https://leetcode.com/problems/pacific-atlantic-water-flow/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. 
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches 
the island's right and bottom edges.

The island is partitioned into a grid of square cells. Each cell has a height represented by 
an integer. Water can flow from a cell to another one with equal or lower height if they are adjacent 
(up, down, left, or right).

Return a list of coordinates [r, c] where water can flow to both the Pacific and Atlantic oceans.

🧾 Example 1:
Input: heights = [
  [1,2,2,3,5],
  [3,2,3,4,4],
  [2,4,5,3,1],
  [6,7,1,4,5],
  [5,1,1,2,4]
]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

🧾 Example 2:
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
*/

import java.util.*;

class Solution {
    private int rows, cols;
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // DFS from Pacific (top and left borders)
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]);
        }
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]);
        }
        
        // Collect cells reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        // boundary + flow check
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;
        if (visited[r][c] || heights[r][c] < prevHeight) return;
        
        visited[r][c] = true;
        
        for (int[] d : directions) {
            dfs(heights, r + d[0], c + d[1], visited, heights[r][c]);
        }
    }
}

/*
🧠 Approach:
- Water flows from higher/equal → lower/equal heights.
- Instead of simulating flow from each cell, **reverse the thinking**:
   - Start DFS/BFS from Pacific-border cells (top, left) → mark reachable.
   - Start DFS/BFS from Atlantic-border cells (bottom, right) → mark reachable.
- The intersection of both visited sets = cells where water can flow to both oceans.

🛠️ Time Complexity: O(m * n) → Each cell visited at most twice
🛠️ Space Complexity: O(m * n) for visited arrays + recursion stack
✅ Status: Accepted on LeetCode
*/
