// 🔍 Problem: Jump Game II
// 📝 Link: https://leetcode.com/problems/jump-game-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Google, Facebook

/*
📝 Problem Statement:
   You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
   Each element nums[i] represents the maximum jump length from that position.
   Your goal is to reach the last index in the minimum number of jumps.
   You can assume that you can always reach the last index.

   🧾 Example:
   Input: nums = [2,3,1,1,4]
   Output: 2
   Explanation: The minimum number of jumps to reach the last index is 2.
   Jump 1 step from index 0 to 1, then 3 steps to the last index.
  
   Input: nums = [2,3,0,1,4]
   Output: 2
*/

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
/*
🧠 Approach (Greedy):
   - Use a Greedy approach to track the farthest reachable index while iterating.
   - Maintain two pointers: `currentEnd` (end of current jump range) and `farthest` (farthest we can reach so far).
   - When `i` reaches `currentEnd`, increment `jumps` and update `currentEnd` to `farthest`.
   - This ensures we only jump when we must.

🛠️Time Complexity: O(n)  
🛠️Space Complexity: O(1)  
✅ Status: Accepted on LeetCode
*/