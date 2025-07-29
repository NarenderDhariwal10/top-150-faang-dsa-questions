// 🔍 Problem: Maximum Depth of Binary Tree
// 📝 Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Payapal, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, return its maximum depth.
A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.

🧾 Example:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Explanation:
        3
       / \
      9  20
         / \
        15  7

The maximum depth is 3.

Constraints:
- The number of nodes in the tree is in the range [0, 10⁴].
- -100 ≤ Node.val ≤ 100
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

/*
🧠 Approach:
Use recursion to compute the maximum depth of left and right subtrees and take the maximum of both +1 (for current node).

🛠️ Time Complexity: O(n) – Each node is visited once.
🛠️ Space Complexity: O(h) – Height of the tree (due to recursion stack).

✅ Status: Accepted on LeetCode
*/
