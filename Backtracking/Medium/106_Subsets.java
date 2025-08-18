// 🔍 Problem: Subsets
// 📝 Link: https://leetcode.com/problems/subsets/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Google, Amazon, Microsoft, Facebook

/*
📝 Problem Statement:
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

🧾 Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]

🧾 Example 2:
Input: nums = [0]
Output: [[],[0]]


*/

class Solution {
public List<List<Integer>> subsets(int[] nums) {
List<List<Integer>> result = new ArrayList<>();
//  Start with an empty subset
backtrack(0, nums, new ArrayList<>(), result);
return result;
}

// Backtracking helper to build subsets
private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
    //  Add the current subset (make a copy)
    result.add(new ArrayList<>(path));

    for (int i = start; i < nums.length; i++) {
        // Choose
        path.add(nums[i]);
        // Explore with next start index
        backtrack(i + 1, nums, path, result);
        // Un-choose
        path.remove(path.size() - 1);
    }
}


}

/*
🧠 Approach (Backtracking):

Build subsets incrementally using DFS/backtracking.

At each index, decide to include or exclude the current element.

Add a copy of the current path to the result at every recursion level.

🛠️ Time Complexity: O(n * 2^n) — there are 2^n subsets and copying path costs up to O(n)
🛠️ Space Complexity: O(n) extra for recursion/path (excluding output)
✅ Status: Accepted on LeetCode
*/