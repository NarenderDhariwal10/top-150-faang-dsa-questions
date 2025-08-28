// 🔍 Problem: Critical Connections in a Network
// 📝 Link: https://leetcode.com/problems/critical-connections-in-a-network/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Facebook, Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network.
A critical connection is a connection that, if removed, will make some servers unable to reach some others.

Return all critical connections in the network in any order.

🧾 Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]

Explanation: Removing edge [1,3] disconnects node 3 from the network.

🧾 Example 2:
Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
*/

class Solution {
    private List<List<Integer>> graph;
    private List<List<Integer>> result;
    private int[] disc; // discovery time
    private int[] low;  // lowest reachable time
    private int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList<>();
        result = new ArrayList<>();
        disc = new int[n];
        low = new int[n];
        time = 1;

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);

        return result;
    }

    private void dfs(int node, int parent) {
        disc[node] = low[node] = time++;
        
        for (int nei : graph.get(node)) {
            if (nei == parent) continue;

            if (disc[nei] == -1) { 
                dfs(nei, node);
                low[node] = Math.min(low[node], low[nei]);

                if (low[nei] > disc[node]) {
                    result.add(Arrays.asList(node, nei));
                }
            } else {
                low[node] = Math.min(low[node], disc[nei]);
            }
        }
    }
}

/*
🧠 Approach (Tarjan's Algorithm for Bridges):
- Use DFS to assign each node:
   - discovery time (first visit time)
   - low-link value (earliest visited vertex reachable).
- For each edge (u,v):
   - If low[v] > disc[u], then (u,v) is a bridge (critical connection).
- Build adjacency list, run DFS from node 0.

🛠️ Time Complexity: O(n + e), where e = number of edges
🛠️ Space Complexity: O(n + e) for adjacency list + recursion stack
✅ Status: Accepted on LeetCode
*/
