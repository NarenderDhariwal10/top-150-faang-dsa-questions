// 🔍 Problem: Next Greater Element I
// 📝 Link: https://leetcode.com/problems/next-greater-element-i/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe

/*
👨‍💻 Problem Statement:
You are given two integer arrays nums1 and nums2 where nums1 is a subset of nums2.
Find the next greater element for each element of nums1 in nums2.

The Next Greater Element for an element x is the first greater element to the right of x in nums2.
If it does not exist, return -1 for that number.

🧾 Example:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
- For 4: No greater element in nums2 → -1
- For 1: Next greater is 3
- For 2: No greater element → -1
*/


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Process nums2 to find next greater element for each number
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreaterMap.put(stack.pop(), num);
            }                          
            stack.push(num);
        }

        // Remaining elements in stack have no greater element
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}

/*
🧠 Approach:
- Use a monotonic decreasing stack to process nums2.
- Store next greater element for each number in a map.
- For nums1, retrieve answers directly from the map.

🛠️ Time Complexity: O(n + m) → n = nums1.length, m = nums2.length
🛠️ Space Complexity: O(m) → Stack and map storage

✅ Status: Accepted on LeetCode
*/
