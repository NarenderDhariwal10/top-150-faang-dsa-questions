// 🔍 Problem: Convert BST to Greater Tree
// 📝 Link: https://leetcode.com/problems/convert-bst-to-greater-tree/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Bloomberg, Facebook

/*
👨‍💻 Problem Statement:
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST 
is changed to the original key plus the sum of all keys greater than the original key in BST.

🧾 Example:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

        Before:             After:
           4                  30
         /   \              /    \
        1     6           36      21
       / \   / \         / \     /  \
      0  2  5   7       36 35   26   15
            \                        \
             3                       33
                                       \
                                        8


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
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        // Traverse the tree in reverse in-order (Right -> Node -> Left)
        if (root == null) return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }
}

/*
🧠 Approach:
- We do a reverse in-order traversal (Right -> Node -> Left)
- Keep a running `sum` and update each node’s value with this running sum.

🛠️ Time Complexity: O(n) — visit every node once
🛠️ Space Complexity: O(h) — height of tree due to recursion stack

✅ Status: Accepted on LeetCode
*/
