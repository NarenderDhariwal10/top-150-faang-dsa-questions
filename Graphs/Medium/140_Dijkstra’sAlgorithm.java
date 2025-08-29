// 🔍 Problem: Dijkstra's Algorithm (Shortest Path in Graph)
// 📝 Link: https://leetcode.com/problems/network-delay-time/  (classic LeetCode variant)
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Microsoft, Uber, Facebook

/*
👨‍💻 Problem Statement:
You are given a directed weighted graph represented as an adjacency list or edges.
Your task is to implement **Dijkstra's Algorithm** to find the shortest distance 
from a given source node to all other nodes.

For LeetCode, a classic problem where this is applied:
➡ "Network Delay Time" (LC 743): Given times[i] = (u, v, w) which represents 
   a directed edge from u → v with travel time w.
   Return the time it takes for all nodes to receive the signal from the source k. 
   If impossible, return -1.

🧾 Example:
Input: 
n = 4, edges = [[2,1,1],[2,3,1],[3,4,1]], k = 2
Output: 2

Explanation:
The signal sent from node 2 reaches all nodes:
- Node 1 in time 1
- Node 3 in time 1
- Node 4 in time 2
Maximum = 2 → answer
*/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // Step 2: Min-Heap (priority queue) → (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k}); // {distance=0, start node=k}

        // Step 3: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 4: Process nodes
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];

            if (d > dist[node]) continue; // Skip if outdated

            if (graph.containsKey(node)) {
                for (int[] nei : graph.get(node)) {
                    int next = nei[0], weight = nei[1];
                    if (dist[node] + weight < dist[next]) {
                        dist[next] = dist[node] + weight;
                        pq.offer(new int[]{dist[next], next});
                    }
                }
            }
        }

        // Step 5: Find max distance
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}

/*
🧠 Approach (Dijkstra’s Algorithm):
- Use a **priority queue (min-heap)** to always expand the shortest distance node.
- Maintain a distance array initialized with infinity (Integer.MAX_VALUE).
- Relax edges: if dist[u] + weight < dist[v], update dist[v].
- Continue until all nodes are processed.

🛠️ Time Complexity: O((E + V) log V)  
   - Each edge processed at most once, heap operations log V
🛠️ Space Complexity: O(V + E) for graph storage and distance array
✅ Status: Accepted on LeetCode (Network Delay Time)
*/
