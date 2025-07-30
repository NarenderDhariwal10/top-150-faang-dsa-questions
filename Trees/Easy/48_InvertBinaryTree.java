// 🔍 Problem: Invert Binary Tree
// 📝 Link: https://leetcode.com/problems/invert-binary-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Facebook

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, invert the tree, and return its root.

🧾 Example:
Input: root = [4,2,7,1,3,6,9]

         4
       /   \
      2     7
     / \   / \
    1   3 6   9

Output: [4,7,2,9,6,3,1]

         4
       /   \
      7     2
     / \   / \
    9   6 3   1


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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}

/*
🧠 Approach:
Use recursion to invert the left and right subtrees, and then swap them.

🛠️ Time Complexity: O(n) – Every node is visited once.
🛠️ Space Complexity: O(h) – h is the height of the tree (due to recursion stack).

✅ Status: Accepted on LeetCode
*/
