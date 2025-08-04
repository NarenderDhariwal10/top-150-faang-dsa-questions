// 🔍 Problem: Kth Smallest Element in a BST
// 📝 Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
Given the root of a Binary Search Tree (BST) and an integer k, return the kth smallest value (1-indexed) 
of all the values of the nodes in the tree.

Since the in-order traversal of a BST yields nodes in sorted order, 
we can leverage this to solve the problem efficiently.

🧾 Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Tree:
      3
     / \
    1   4
     \
      2

🧾 Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Tree:
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
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    // Inorder traversal to get elements in sorted order
    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}

/*
🧠 Approach:
- Perform an in-order traversal (Left -> Node -> Right) which gives sorted order for BST.
- Keep a counter of visited nodes.
- When counter == k, record the value and return.

🛠️ Time Complexity: O(H + k) where H is the height of the tree
🛠️ Space Complexity: O(H) for recursion stack

✅ Status: Accepted on LeetCode
*/
