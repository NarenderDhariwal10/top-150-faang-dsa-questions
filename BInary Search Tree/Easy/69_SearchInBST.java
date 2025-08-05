// 🔍 Problem: Search in a Binary Search Tree
// 📝 Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Facebook

/*
👨‍💻 Problem Statement:
You are given the root of a binary search tree (BST) and an integer val.

Return the subtree rooted with the node whose value equals val. 
If such a node does not exist, return null.

🧾 Example:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Tree:
        4
       / \
      2   7
     / \
    1   3

Search for 2 returns subtree [2,1,3]
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

/*
🧠 Approach:
- Use the BST property: left < root < right.
- Recursively search either left or right depending on the value.

🛠️ Time Complexity: O(h), where h is the height of the tree
🛠️ Space Complexity: O(h) due to recursion

✅ Status: Accepted on LeetCode
*/
