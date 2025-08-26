// 🔍 Problem: Clone Graph
// 📝 Link: https://leetcode.com/problems/clone-graph/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook, Apple

/*
👨‍💻 Problem Statement:
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. 
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:
For simplicity, each node’s value is the same as the node’s index (1-indexed).
The graph is represented as an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph.
Each list describes the set of neighbors of a node in the graph.

🧾 Example 1:
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation:
Graph:
   1 -- 2
   |    |
   4 -- 3

🧾 Example 2:
Input: adjList = [[]]
Output: [[]]
Explanation: The graph consists of a single node with no neighbors.

🧾 Example 3:
Input: adjList = []
Output: []
Explanation: Empty graph.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return from map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the current node
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        // Clone all neighbors recursively
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}

/*
🧠 Approach:
- Use DFS or BFS to traverse the graph.
- Maintain a HashMap<Node, Node> to map original → cloned nodes.
- For each node:
   1. If it’s already cloned, return it.
   2. Otherwise, create a new clone node.
   3. Recursively clone neighbors and add to the cloned node’s neighbor list.
- This ensures deep copy without cycles causing infinite recursion.

🛠️ Time Complexity: O(V + E) → Each node and edge visited once
🛠️ Space Complexity: O(V) → HashMap + recursion stack
✅ Status: Accepted on LeetCode
*/
