// 🔍 Problem: Validate Binary Search Tree
// 📝 Link: https://leetcode.com/problems/validate-binary-search-tree/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
- The left subtree of a node contains only nodes with keys less than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- Both the left and right subtrees must also be binary search trees.

🧾 Example:
Input: root = [2,1,3]
Output: true

Input: root = [5,1,4,null,null,3,6]
Output: false

           5
         /   \
        1     4
             / \
            3   6

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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to validate BST using min-max range
    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;

        // BST violation check
        if (node.val <= min || node.val >= max) return false;

        // Recursively validate left and right subtrees
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}

/*
🧠 Approach:
Use DFS with a valid range [min, max] for each node. Every node must lie within its allowed range:
- Left child's max is parent value
- Right child's min is parent value

🛠️ Time Complexity: O(n) – Traverse all nodes once
🛠️ Space Complexity: O(h) – h is the height of the tree (recursion stack)

✅ Status: Accepted on LeetCode
*/
