// 🔍 Problem: Binary Tree Level Order Traversal
// 📝 Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
*/

/*
🧾 Example:
Input: root = [3,9,20,null,null,15,7]

        3
       / \
      9  20
        /  \
       15   7

Output: [[3],[9,20],[15,7]]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> qe = new LinkedList<>();
        qe.add(root);

        while (!qe.isEmpty()) {
            int levelSize = qe.size();
            List<Integer> sublist = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = qe.remove();
                sublist.add(current.val);

                if (current.left != null) qe.add(current.left);
                if (current.right != null) qe.add(current.right);
            }
            list.add(sublist);
        }
        return list;
    }

}

/*
🧠 Approach (BFS – Queue):
Use a queue to process nodes level by level.
For each level:
1) Note the current queue size (number of nodes at this level).
2) Pop exactly that many nodes, collecting their values.
3) Push their non-null children to the queue.
Repeat until the queue is empty.


🛠️ Time Complexity: O(n) — Visit each node once.
🛠️ Space Complexity: O(n) — Queue holds up to O(width) nodes in the worst case.

✅ Status: Accepted on LeetCode
*/