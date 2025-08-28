// 🔍 Problem: Graph Valid Tree
// 📝 Link: https://leetcode.com/problems/graph-valid-tree/ (premium problem)
// 🎯 Difficulty: Medium
// 🏢 Asked in: Facebook, Google, Amazon, Microsoft, Apple

/*
👨‍💻 Problem Statement:
You have a graph of n nodes labeled from 0 to n - 1. 
You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates 
that there is an undirected edge between nodes ai and bi.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

👉 A valid tree must:
1. Be fully connected (every node reachable from any other).
2. Have no cycles.

🧾 Example 1:
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

🧾 Example 2:
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // tree must have exactly n-1 edges

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if (hasCycle(graph, 0, -1, visited)) return false; // detect cycle

        // check if fully connected
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, int parent, boolean[] visited) {
        if (visited[node]) return true;
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            if (hasCycle(graph, neighbor, node, visited)) return true;
        }

        return false;
    }
}

/*
🧠 Approach:
- A valid tree must satisfy 2 conditions:
   1. Graph must have exactly n-1 edges.
   2. Graph must be fully connected and have no cycles.
- Build adjacency list, run DFS:
   - If a cycle is detected → return false.
   - After DFS, ensure all nodes are visited (connected).
- If both hold → return true.

🛠️ Time Complexity: O(n + e), where e = number of edges
🛠️ Space Complexity: O(n + e) for adjacency list + recursion stack
✅ Status: Accepted on LeetCode
*/
