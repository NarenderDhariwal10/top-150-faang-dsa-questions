// 🔍 Problem: Inorder Successor in BST
// 📝 Link: https://leetcode.com/problems/inorder-successor-in-bst/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Microsoft

/*
👨‍💻 Problem Statement:
Given the root of a Binary Search Tree (BST) and a node `p` in it, find the in-order successor of that node in the BST.

The in-order successor of a node `p` is the node with the smallest key greater than `p.val`.

🧾 Example:
Input: root = [5,3,6,2,4,null,null,1], p = 4
Output: 5

      5
     / \
    3   6
   / \
  2   4
 /
1

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val < root.val) {
                successor = root; // potential successor
                root = root.left; // try to find smaller one
            } else {
                root = root.right; // go right if root.val <= p.val
            }
        }

        return successor;
    }
}

/*
🧠 Approach:
- Do a BST traversal.
- If p.val < root.val, we update the potential successor and move left.
- If p.val ≥ root.val, we go right.
- We stop when we reach null.

🛠️ Time Complexity: O(h) → h is the height of the tree (O(log n) for balanced, O(n) worst)
🛠️ Space Complexity: O(1) → no extra space used

✅ Status: Accepted on LeetCode
*/
