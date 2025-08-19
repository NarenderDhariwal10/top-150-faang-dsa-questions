// 🔍 Problem: Subsets II
// 📝 Link: https://leetcode.com/problems/subsets-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Google, Microsoft, Facebook

/*
📝 Problem Statement:
Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
-
🧾 Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

🧾 Example 2:
Input: nums = [0]
Output: [[],[0]]
*/


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
/*
🧠 Approach:
1. Sort the array to group duplicates together.
2. Use **Backtracking** to explore all subset possibilities.
3. At each recursive call:
   - Add current subset to result.
   - Iterate over remaining elements.
   - Skip duplicates by checking if current element equals previous one and it's not the first choice in this level.
4. Continue recursion until all elements are processed.

--------------------------------------------------
🛠️ Time Complexity: O(2^N) → Each element can be included or excluded
🛠️ Space Complexity: O(N) → Recursion stack + temporary subset

✅ Status: Accepted on LeetCode
*/