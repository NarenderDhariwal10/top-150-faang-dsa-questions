// 🔍 Problem: Combination Sum
// 📝 Link: https://leetcode.com/problems/combination-sum/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Facebook, Google

/*
📝 Problem Statement:
Given an array of distinct integers `candidates` and a target integer `target`, 
return a list of all unique combinations of candidates where the chosen numbers sum to `target`. 

You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target 
is less than 150 combinations for the given input.
-
🧾 Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

🧾 Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

🧾 Example 3:
Input: candidates = [2], target = 1
Output: []
*/

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                // Allow same element again by passing `i` (not i+1)
                backtrack(candidates, target - candidates[i], i, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }
}

/*
🧠 Approach:
1. Use **Backtracking** to explore all possible combinations.
2. At each recursive step:
   - If target == 0 → add current list to result (valid combination).
   - If target < 0 → stop exploring (invalid path).
   - Otherwise → iterate over candidates and choose a number:
       - Recurse with reduced target.
       - Allow same index again to reuse numbers.
3. Backtrack by removing the last added element before exploring the next option.

--------------------------------------------------
🛠️ Time Complexity: O(2^T) → T is target, exponential due to exploring combinations
🛠️ Space Complexity: O(T) → recursion depth and temporary subset

✅ Status: Accepted on LeetCode
*/
