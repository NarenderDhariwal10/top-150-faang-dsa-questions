// 🔍 Problem: Merge Sorted Array
// 📝 Link: https://leetcode.com/problems/merge-sorted-array/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order,
and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

Merge `nums2` into `nums1` as one sorted array in-place.

Note: The array `nums1` has length `m + n`, with the last `n` elements set to 0 and should be ignored.

🧾 Example:
Input: nums1 = [1,2,3,0,0,0], m = 3
       nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both arrays
        int i = m - 1; // Last index of actual element in nums1
        int j = n - 1; // Last index of nums2
        int k = m + n - 1; // Last index of merged array (nums1)

        // Fill nums1 from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements left
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // No need to copy the remaining nums1 values (already in place)
    }
}

/*
🧠 Approach:
- Use three pointers to merge from the back to avoid overwriting values in nums1.
- Fill the largest elements first.

🛠️ Time Complexity: O(m + n)
🛠️ Space Complexity: O(1) – In-place merge

✅ Status: Accepted on LeetCode
*/
