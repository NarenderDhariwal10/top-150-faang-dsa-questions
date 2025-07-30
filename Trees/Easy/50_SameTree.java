// 🔍 Problem: Same Tree
// 📝 Link: https://leetcode.com/problems/same-tree/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given the roots of two binary trees p and q, write a function to check if they are the same.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/

/*
🧾 Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

🧾 Example 2:
Input: p = [1,2], q = [1,null,2]
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        java.util.ArrayDeque<TreeNode> dq = new java.util.ArrayDeque<>();
        dq.offer(p);
        dq.offer(q);

        while (!dq.isEmpty()) {
            TreeNode a = dq.poll();
            TreeNode b = dq.poll();

            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;

            dq.offer(a.left);
            dq.offer(b.left);
            dq.offer(a.right);
            dq.offer(b.right);
        }
        return true;
    }
    
}
/*
🧠 Approach:
Use a queue to compare nodes in pairs. At each step:
- If both nodes are null, continue.
- If one is null or values differ, return false.
- Enqueue corresponding left children together and right children together.

🛠️ Time Complexity: O(n) — n is the total number of nodes compared (min size of the two trees in structure).
🛠️ Space Complexity: O(h) — recursion stack height h (O(log n) for balanced, O(n) worst-case).

✅ Status: Accepted on LeetCode
*/

