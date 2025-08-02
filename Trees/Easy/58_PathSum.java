// 🔍 Problem: Path Sum
// 📝 Link: https://leetcode.com/problems/path-sum/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path 
such that adding up all the values along the path equals targetSum.

🧾 Example:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22

         5
       /   \
      4     8
     /     / \
    11    13  4
   /  \         \
  7    2         1

Output: true

🧾 Example 2:
Input: root = [1,2,3], targetSum = 5  
Output: false

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: null node
        if (root == null) return false;

        // If it's a leaf node, check if the sum equals the target
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check the left and right subtree with reduced target
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}

/*
🧠 Approach:
Use DFS recursively. At each node, subtract its value from the target sum.
If we reach a leaf node and remaining sum is zero, return true.

🛠️ Time Complexity: O(n) – Traverse each node once
🛠️ Space Complexity: O(h) – h is height of the tree (recursion stack)

✅ Status: Accepted on LeetCode
*/
