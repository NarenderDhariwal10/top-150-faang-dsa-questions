// 🔍 Problem: Diameter of Binary Tree
// 📝 Link: https://leetcode.com/problems/diameter-of-binary-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

🧾 Example:
Input: root = [1,2,3,4,5]
Output: 3

Explanation:
        1
       / \
      2   3
     / \
    4   5

The longest path is [4,2,1,3] or [5,2,1,3], with 3 edges (length = 3).

Constraints:
- The number of nodes in the tree is in the range [1, 10⁴].
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

    // Helper class to store height and diameter together
    static class TreeInfo {
        int ht;
        int diam;
        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diam - 1; // number of edges = nodes in path - 1
    }

    // Recursive function to compute diameter and height
    public TreeInfo diameter(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int height = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1; // nodes in the longest path through root

        int ansDia = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(height, ansDia);
    }
}

/*
🧠 Approach:
We use a post-order traversal to calculate the height of left and right subtrees. 
The longest path between two nodes in a tree (diameter) may pass through the root or exist in left/right subtree.

🛠️ Time Complexity: O(n) – Each node is visited once.
🛠️ Space Complexity: O(h) – Height of the tree (due to recursion stack).

✅ Status: Accepted on LeetCode
*/
