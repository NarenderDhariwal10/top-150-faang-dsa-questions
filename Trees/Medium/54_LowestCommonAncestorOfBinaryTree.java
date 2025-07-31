// 🔍 Problem: Lowest Common Ancestor of a Binary Tree
// 📝 Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

The lowest common ancestor is defined as the lowest node in the tree that has both p and q as descendants 
(where we allow a node to be a descendant of itself).

🧾 Example:
Input:
        3
       / \
      5   1
     / \ / \
    6  2 0  8
      / \
     7   4

p = 5, q = 1  
Output: 3

p = 5, q = 4  
Output: 5
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null || root == p || root == q) return root;

        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q found in different subtrees, root is LCA
        if (left != null && right != null) return root;

        // Otherwise, return the non-null child
        return left != null ? left : right;
    }
}

/*
🧠 Approach:
- Use DFS to traverse the tree.
- If current node is either p or q, return that node.
- Check left and right subtrees recursively.
- If both calls return non-null, current node is LCA.

🛠️ Time Complexity: O(n) – Visit each node once
🛠️ Space Complexity: O(h) – Recursion stack, where h = height of the tree

✅ Status: Accepted on LeetCode
*/
