// 🔍 Problem: Subarray Product Less Than K
// 🔗 Link: https://leetcode.com/problems/subarray-product-less-than-k/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Google, Microsoft, Adobe, Facebook

/*
👨‍💻Problem Statement:
 Given an array of positive integers nums and an integer k, return the number of contiguous subarrays 
 where the product of all the elements in the subarray is strictly less than k.

🧾 Example:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]

Input: nums = [1,2,3], k = 0
Output: 0
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // no valid subarray possible
        int left = 0;
        int count = 0;
        long product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}
/*
🧠Approach:
We use the sliding window technique to keep track of a subarray whose product is less than k.
- Maintain a running product.
- Expand the right pointer and multiply nums[right].
- If the product becomes >= k, shrink from the left until product < k.
- For each right, the number of valid subarrays ending at right is (right - left + 1).

🛠️Time Complexity: O(n) – each element is visited at most twice.
🛠️Space Complexity: O(1) – constant extra space.
✅ Status: Optimized and Accepted
*/