// 🔍 Problem: Construct Binary Tree from Preorder and Inorder Traversal
// 📝 Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
Given two integer arrays preorder and inorder, construct and return the binary tree.

🧾 Example:
Input: 
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Output: 
      3
     / \
    9  20
       / \
      15  7

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
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i); // Map value to index
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }
}

/*
🧠 Approach:
- The first element in preorder is always the root.
- Use a HashMap to find the index of the root in the inorder array in O(1).
- Recursively build left and right subtrees using the position in inorder.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n) — for the map and recursion stack

✅ Status: Accepted on LeetCode
*/
