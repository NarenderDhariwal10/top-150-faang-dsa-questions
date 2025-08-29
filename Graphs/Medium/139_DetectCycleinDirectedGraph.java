// 🔍 Problem: Detect Cycle in Directed Graph
// 📝 Link: https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe

/*
👨‍💻 Problem Statement:
Given a Directed Graph with V vertices and E edges, check whether it contains a cycle or not.

Return true if there is a cycle, else return false.

🧾 Example 1:
Input: V = 4, Edges = [[0,1],[1,2],[2,3]]
Output: false
Explanation: No cycle exists in the graph.

🧾 Example 2:
Input: V = 4, Edges = [[0,1],[1,2],[2,0],[2,3]]
Output: true
Explanation: Cycle exists in the path 0 → 1 → 2 → 0
*/

class Solution {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei] && dfs(nei, visited, recStack, adj)) {
                return true;
            } else if (recStack[nei]) {
                return true; // cycle detected
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }
}

/*
🧠 Approach:
- Use DFS with recursion stack to detect cycle in a directed graph.
- Maintain two arrays:
   - visited[]: marks visited nodes.
   - recStack[]: marks nodes in the current recursion stack.
- If we revisit a node already in the recursion stack → cycle detected.
- Backtrack after processing neighbors.

🛠️ Time Complexity: O(V + E) → visit all nodes and edges once
🛠️ Space Complexity: O(V) → recursion stack + arrays
✅ Status: Accepted (GFG / LeetCode variant)
