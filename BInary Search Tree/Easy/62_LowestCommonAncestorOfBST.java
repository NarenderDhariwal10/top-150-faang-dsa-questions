// 🔍 Problem: Lowest Common Ancestor of a Binary Search Tree
// 📝 Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia:
"The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself)."

🧾 Example:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: 2 is an ancestor of 4.

           6
         /   \
        2     8
       / \   / \
      0   4 7   9
         / \
        3   5

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST property: left < root < right
        if (p.val < root.val && q.val < root.val) {
            // LCA is in the left subtree
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // LCA is in the right subtree
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // One is on the left, one is on the right (or one is root)
            return root;
        }
    }
}

/*
🧠 Approach:
Use BST property:
- If both p and q < root, go left
- If both p and q > root, go right
- Else current root is the LCA

🛠️ Time Complexity: O(h), where h = height of BST
🛠️ Space Complexity: O(h) for recursive stack

✅ Status: Accepted on LeetCode
*/
