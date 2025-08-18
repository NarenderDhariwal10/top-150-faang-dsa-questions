// 🔍 Problem: Permutations
// 📝 Link: https://leetcode.com/problems/permutations/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Google, Bloomberg, Adobe

/*
📝 Problem Statement:
Given an array `nums` of distinct integers, return all the possible permutations. 
You can return the answer in any order.

-
🧾 Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

🧾 Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

🧾 Example 3:
Input: nums = [1]
Output: [[1]]
*/

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used numbers

            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, current, used, result);
            current.remove(current.size() - 1); // backtrack
            used[i] = false;
        }
    }
}

/*
🧠 Approach:
1. Use **Backtracking** to generate all permutations.
2. Keep track of which numbers are already used with a boolean array.
3. Add numbers one by one to the current list until its size == nums.length.
4. Once a valid permutation is formed, add it to the result.
5. Backtrack to explore other possibilities.

--------------------------------------------------
🛠️ Time Complexity: O(N × N!) → There are N! permutations, and copying takes O(N)
🛠️ Space Complexity: O(N) → Recursion stack + boolean array

✅ Status: Optimized and Tested
*/