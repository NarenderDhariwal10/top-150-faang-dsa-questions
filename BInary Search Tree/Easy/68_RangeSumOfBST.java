// 🔍 Problem: Range Sum of BST
// 📝 Link: https://leetcode.com/problems/range-sum-of-bst/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

🧾 Example:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32

Tree:
        10
       /  \
      5    15
     / \     \
    3   7     18

Nodes in range [7, 15]: 7, 10, 15 → sum = 32
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            // Discard left subtree
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            // Discard right subtree
            return rangeSumBST(root.left, low, high);
        } else {
            // Include current node and explore both subtrees
            return root.val +
                   rangeSumBST(root.left, low, high) +
                   rangeSumBST(root.right, low, high);
        }
    }
}

/*
🧠 Approach:
- Use recursion to traverse the BST.
- Prune the tree: If node < low, ignore left; if node > high, ignore right.
- If node is within range, add value and check both sides.

🛠️ Time Complexity: O(n), where n is the number of nodes
🛠️ Space Complexity: O(h), where h is the height of the tree (due to recursion stack)

✅ Status: Accepted on LeetCode
