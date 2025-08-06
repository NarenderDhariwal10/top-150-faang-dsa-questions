// 🔍 Problem: Construct Binary Search Tree from Preorder Traversal
// 📝 Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon

/*
👨‍💻 Problem Statement:
Given an array of integers preorder, which represents the preorder traversal of a BST (Binary Search Tree),
construct the tree and return its root.

🧾 Example:
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Tree Structure:
        8
       / \
      5   10
     / \     \
    1   7     12

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
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(int[] preorder, int min, int max) {
        if (index >= preorder.length) return null;

        int val = preorder[index];
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        index++;

        root.left = buildBST(preorder, min, val);
        root.right = buildBST(preorder, val, max);

        return root;
    }
}


/*
🧠 Approach:
- Use a recursive function with boundaries `min` and `max`.
- Traverse the `preorder` array with a shared index.
- For each node, validate if it fits the current BST bounds.
- Recursively build the left and right subtrees with updated bounds.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n) for recursion stack

✅ Status: Accepted on LeetCode
