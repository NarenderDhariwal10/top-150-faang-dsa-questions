// 🔍 Problem: Convert Sorted Array to Binary Search Tree
// 📝 Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Facebook, Amazon, Microsoft

/*
👨‍💻 Problem Statement:
Given an integer array `nums` where the elements are sorted in ascending order, 
convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of 
every node never differs by more than one.

🧾 Example:
Input: nums = [-10,-3,0,5,9]

Output:
        0
       / \
    -10   5
      \     \
      -3     9


*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // Recursive helper to construct BST from subarray
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        // Always choose middle element as root for balance
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}

/*
🧠 Approach:
- Recursively choose the middle element of the array (or subarray) as root.
- Build left subtree from left half and right subtree from right half.
- Ensures height-balanced property.

🛠️ Time Complexity: O(n), where n = length of nums
🛠️ Space Complexity: O(log n), for recursion stack (balanced tree height)

✅ Status: Accepted on LeetCode
*/
