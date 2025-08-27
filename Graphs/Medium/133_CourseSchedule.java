// 🔍 Problem: Course Schedule
// 📝 Link: https://leetcode.com/problems/course-schedule/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook, Apple

/*
👨‍💻 Problem Statement:
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [a, b] indicates that 
you must take course b before course a.

- Return true if you can finish all courses.
- Otherwise, return false.

🧾 Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: You can finish course 0 before course 1.

🧾 Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: You must take course 0 before 1, and 1 before 0 → cycle exists.
*/

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int course) {
        if (state[course] == 1) return true;   // cycle detected
        if (state[course] == 2) return false;  // already checked

        state[course] = 1; // mark as visiting
        for (int neighbor : graph.get(course)) {
            if (hasCycle(graph, state, neighbor)) {
                return true;
            }
        }
        state[course] = 2; // mark as visited
        return false;
    }
}

/*
🧠 Approach:
- The problem is essentially **detecting a cycle in a directed graph**.
- Each course is a node, and an edge from b → a means "take b before a".
- Steps:
  1. Build adjacency list for the graph.
  2. Perform DFS to detect cycles.
     - Use states: 0 = unvisited, 1 = visiting, 2 = visited.
     - If during DFS we revisit a "visiting" node → cycle exists → return false.
  3. If no cycle → all courses can be finished → return true.

🛠️ Time Complexity: O(V + E) → V = numCourses, E = prerequisites.length
🛠️ Space Complexity: O(V + E) for graph + recursion stack
✅ Status: Accepted on LeetCode
*/
