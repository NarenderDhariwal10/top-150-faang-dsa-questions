// 🔍 Problem: Subtree of Another Tree
// 📝 Link: https://leetcode.com/problems/subtree-of-another-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Bloomberg, Google

/*
👨‍💻 Problem Statement:
Given the roots of two binary trees `root` and `subRoot`, return true if there is a subtree of `root` 
with the same structure and node values of `subRoot`, and false otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in tree and all of this node's 
descendants. The tree `tree` could also be considered as a subtree of itself.

🧾 Example:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]

        3
       / \
      4   5
     / \
    1   2

    subRoot:
      4
     / \
    1   2

Output: true
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // Check if current tree matches subRoot
        if (isSameTree(root, subRoot)) return true;

        // Otherwise check in left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function to check if two trees are the same
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

/*
🧠 Approach:
- For every node in `root`, check if the tree starting at that node is identical to `subRoot`.
- Use a helper method to compare two trees (isSameTree).
- Recursively check left and right subtree if not matched at the current root.

🛠️ Time Complexity: O(m * n)
    m = number of nodes in root, n = number of nodes in subRoot (in worst case, compare subRoot at every node in root)
🛠️ Space Complexity: O(h), h = height of tree (recursion stack)

✅ Status: Accepted on LeetCode
*/
