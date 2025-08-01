// 🔍 Problem: Binary Tree Zigzag Level Order Traversal
// 📝 Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(That is, from left to right, then right to left for the next level and alternate between).

🧾 Example:
Input: 
        3
       / \
      9  20
         / \
        15  7

Output: [[3],[20,9],[15,7]]

*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                if (leftToRight) {
                    level.addLast(current.val);
                } else {
                    level.addFirst(current.val);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(level);
            leftToRight = !leftToRight;  // Toggle direction
        }

        return result;
    }
}

/*
🧠 Approach:
- Use a Queue for BFS traversal.
- For each level, use a LinkedList to add elements either at end (left-to-right) or beginning (right-to-left).
- Alternate the direction using a boolean flag.

🛠️ Time Complexity: O(n) – where n is the number of nodes (each visited once)
🛠️ Space Complexity: O(n) – for the queue and result list

✅ Status: Accepted on LeetCode
*/
