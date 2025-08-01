// 🔍 Problem: Balanced Binary Tree
// 📝 Link: https://leetcode.com/problems/balanced-binary-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Facebook, Google

/*
👨‍💻 Problem Statement:
Given a binary tree, determine if it is height-balanced.
A binary tree is balanced if:
- The left and right subtrees' heights differ by no more than 1, and
- Both the left and right subtrees are also balanced.

🧾 Example:
Input: 
        3
       / \
      9  20
         / \
        15  7

Output: true

Input: 
        1
       / \
      2   2
     / \
    3   3
   / \
  4   4

Output: false

*/

class Solution {

    // Helper function returns height if balanced, -1 if not
    private int checkHeight(TreeNode root) {
        if (root == null) return 0; // Base case: empty tree is height 0

        // Recursively get heights of left and right subtrees
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        // If the current node's subtrees differ by more than 1 in height, not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return height of current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1; // Tree is balanced if checkHeight doesn't return -1
    }
}

/*
🧠 Approach:
- Use post-order traversal to check height of left and right subtrees.
- If at any node, the height difference is > 1, return -1 (flag for unbalanced).
- Propagate -1 upwards if any subtree is unbalanced.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(h) – recursion stack (h = height of tree)

✅ Status: Accepted on LeetCode
*/
