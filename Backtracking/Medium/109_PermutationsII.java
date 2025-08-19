// 🔍 Problem: Permutations II
// 📝 Link: https://leetcode.com/problems/permutations-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Google, Facebook

/*
📝 Problem Statement:
Given a collection of numbers, `nums`, that might contain duplicates, 
return all possible unique permutations in any order.

-
🧾 Example 1:
Input: nums = [1,1,2]
Output: [[1,1,2],[1,2,1],[2,1,1]]

🧾 Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates (only if previous identical wasn't used)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, used, current, result);

            // Undo (Backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

/*
🧠 Approach:
1. Sort the array so duplicates are adjacent.
2. Use **Backtracking** to build permutations.
3. Maintain a `used[]` array to track visited elements.
4. At each recursion:
   - Skip already used elements.
   - Skip duplicates if the same number has already been tried in this branch.
5. Continue until the current list size equals `nums.length`.

--------------------------------------------------
🛠️ Time Complexity: O(N! * N) → generating all permutations with duplicate handling
🛠️ Space Complexity: O(N) → recursion stack + used array

✅ Status: Accepted on LeetCode
*/
