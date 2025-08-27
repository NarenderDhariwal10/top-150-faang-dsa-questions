// 🔍 Problem: Rotting Oranges
// 📝 Link: https://leetcode.com/problems/rotting-oranges/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Apple, Facebook

/*
👨‍💻 Problem Statement:
You are given an m x n grid where each cell can have one of three values:
- 0 representing an empty cell,
- 1 representing a fresh orange,
- 2 representing a rotten orange.

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten one becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
If this is impossible, return -1.

🧾 Example 1:
Input: grid = [
  [2,1,1],
  [1,1,0],
  [0,1,1]
]
Output: 4

🧾 Example 2:
Input: grid = [
  [2,1,1],
  [0,1,1],
  [1,0,1]
]
Output: -1
Explanation: The orange at (2,0) will never rot because it's isolated.

🧾 Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are no fresh oranges at the start, the answer is 0.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Count fresh oranges and add rotten ones to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (fresh == 0) return 0;
        
        int minutes = -1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // Step 2: BFS (multi-source from all rotten oranges)
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : directions) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] != 1) {
                        continue;
                    }
                    
                    grid[nr][nc] = 2; // rot the orange
                    fresh--;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return fresh == 0 ? minutes : -1;
    }
}

/*
🧠 Approach:
- Use **BFS (multi-source)** starting from all initially rotten oranges.
- Each level in BFS = 1 minute of time.
- Whenever a fresh orange becomes rotten, decrease fresh count.
- At the end:
   - If fresh == 0 → return elapsed minutes.
   - Else → return -1 (some oranges never rotted).

🛠️ Time Complexity: O(m * n) → each cell visited once
🛠️ Space Complexity: O(m * n) → queue in worst case
✅ Status: Accepted on LeetCode
*/
