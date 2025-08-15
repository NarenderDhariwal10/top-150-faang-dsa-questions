// 🔍 Problem: Jump Game
// 📝 Link: https://leetcode.com/problems/jump-game/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Google, Adobe, Facebook

/*
📝 Problem Statement:
You are given an integer array `nums`. You are initially positioned at the first index, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

👨‍💻 Example:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [3,2,1,0,4]
Output: false
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // can't reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
/*
🧠 Approach (Greedy):
1. Initialize `maxReach` as 0.
2. Iterate through the array:
   - If `i > maxReach`, return false (you can't reach this index).
   - Update `maxReach = max(maxReach, i + nums[i])`.
3. If loop finishes, return true.

🛠️Time Complexity: O(n)  
🛠️Space Complexity: O(1)  
✅ Status: Accepted on LeetCode
*/