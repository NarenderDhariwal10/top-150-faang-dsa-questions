// 🔍 Problem: Symmetric Tree
// 📝 Link: https://leetcode.com/problems/symmetric-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, check whether it is a mirror of itself
(i.e., symmetric around its center).
*/

/*
🧾 Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true
Explanation:
        1
      /   \
     2     2
    / \   / \
   3   4 4   3
This tree is symmetric.

🧾 Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
Explanation:
        1
      /   \
     2     2
      \     \
       3     3
This tree is not symmetric.
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

}
/*
🧠 Approach:
A tree is symmetric if its left subtree is a mirror of its right subtree.
We compare nodes pairwise in a mirrored manner:
- Values must be equal.
- left.left mirrors right.right
- left.right mirrors right.left

We implement a recursive helper `isMirror(a, b)` that returns true iff the
two given nodes are mirrors of each other.


🛠️ Time Complexity: O(n) — Each node is visited once.
🛠️ Space Complexity: O(h) — Recursion stack height h (O(log n) for balanced, O(n) worst-case).

✅ Status: Accepted on LeetCode
*/