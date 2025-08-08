// 🔍 Problem: Task Scheduler
// 📝 Link: https://leetcode.com/problems/task-scheduler/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
You are given an array of CPU tasks, each represented by a character from 'A' to 'Z', and an integer n representing the cooldown period between the same tasks.

Each task takes 1 unit of time to complete. Tasks can be done in any order, but there must be at least `n` units of time between two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

🧾 Example:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8

Explanation: A -> B -> idle -> A -> B -> idle -> A -> B

*/

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25] - 1;
        int idleSlots = maxFreq * n;

        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(freq[i], maxFreq);
        }

        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}

/*
🧠 Approach:
- Count frequencies of all tasks.
- Sort to find the task with maximum frequency.
- Use formula:
  Total time = max(tasks.length, (maxFreq - 1) * (n + 1) + count of tasks with maxFreq)

- We fill idle slots with remaining tasks or keep them idle.

🛠️ Time Complexity: O(26 log 26) + O(n) = O(n)
🛠️ Space Complexity: O(1) (since only 26 task types)

✅ Status: Accepted on LeetCode
*/
