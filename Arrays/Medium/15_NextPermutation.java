// 🔍 Problem: Next Permutation
// 📝 Link: https://leetcode.com/problems/next-permutation/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Microsoft

/*
👨‍💻 Problem Statement:
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order 
(i.e., sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

🧾 Example:
Input: nums = [1,2,3]
Output: [1,3,2]

Input: nums = [3,2,1]
Output: [1,2,3]

Input: nums = [1,1,5]
Output: [1,5,1]
*/

import java.util.*;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If found, swap with next greater element on right
        if (i >= 0) {
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Reverse elements to the right of i
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

/*
🧠 Approach:
1. Traverse from right to find the first element which is smaller than its next.
2. Swap it with the next bigger element on the right.
3. Reverse the part after the swapped element to get next lexicographical order.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
