// 🔍 Problem: Vertical Order Traversal of a Binary Tree
// 📝 Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given the root of a binary tree, return the vertical order traversal of its nodes' values.
Nodes should be reported from top to bottom, and within the same row, from left to right.
If two nodes are in the same row and column, the node with the smaller value should be reported first.

🧾 Example:
Input: 
        3
       / \
      9  20
         / \
        15  7

Output: [[9],[3,15],[20],[7]]

*/

class Solution {

    // Helper class to store node with its row and column
    static class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap for sorted column order, then rows inside that, then priority queue for values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // BFS queue storing (node, row, col)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        // BFS traversal
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            // Insert into the map: column -> row -> minHeap of node values
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            // Traverse left and right child with updated positions
            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Prepare result from the TreeMap
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll()); // Maintain sorting for same row/col
                }
            }
            result.add(column);
        }

        return result;
    }
}

/*
🧠 Approach:
- Use BFS traversal while keeping track of each node's row and column.
- Store nodes in a TreeMap<col, TreeMap<row, PriorityQueue<val>>> to maintain vertical order.
- Extract the results by traversing TreeMap in order.

🛠️ Time Complexity: O(n log n) – due to sorting rows/columns and using priority queues
🛠️ Space Complexity: O(n) – storing nodes in maps and queues

✅ Status: Accepted on LeetCode
*/
