// 🔍 Problem: Non-overlapping Intervals
// 📝 Link: https://leetcode.com/problems/non-overlapping-intervals/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Google, Amazon, Facebook, Microsoft

/*
📝 Problem Statement:
   Given an array of intervals intervals where intervals[i] = [starti, endi], 
   return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

   🧾 Example 1:
   Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
   Output: 1
   Explanation: Remove [1,3] and the rest of the intervals are non-overlapping.

   🧾 Example 2:
   Input: intervals = [[1,2],[1,2],[1,2]]
   Output: 2
   Explanation: Remove two [1,2] intervals.

   🧾 Example 3:
   Input: intervals = [[1,2],[2,3]]
   Output: 0
   Explanation: No intervals need to be removed since they are already non-overlapping.
*/

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; 
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap → remove current interval
                count++;
            } else {
                // Update prevEnd
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}

/*
🧠 Approach (Greedy):
   - Sort intervals by their ending times.
   - Keep track of the `prevEnd` (end of last non-overlapping interval).
   - If the next interval starts before `prevEnd`, it overlaps → remove it (increment count).
   - Otherwise, update `prevEnd`.

🛠️ Time Complexity: O(n log n) (due to sorting)  
🛠️ Space Complexity: O(1)  
✅ Status: Accepted on LeetCode
*/
