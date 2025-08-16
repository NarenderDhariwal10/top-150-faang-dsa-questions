// 🔍 Problem: Merge Intervals
// 📝 Link: https://leetcode.com/problems/merge-intervals/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Google, Facebook, Microsoft, Amazon

/*
📝 Problem Statement:
   Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
   and return an array of the non-overlapping intervals that cover all the intervals in the input.

   🧾 Example 1:
   Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
   Output: [[1,6],[8,10],[15,18]]
   Explanation: Intervals [1,3] and [2,6] overlap, so merge them into [1,6].

   🧾 Example 2:
   Input: intervals = [[1,4],[4,5]]
   Output: [[1,5]]
   Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlapping → merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap → add current interval
                merged.add(current);
                current = intervals[i];
            }
        }

        // Add last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }
}

/*
🧠 Approach (Greedy + Sorting):
   - Sort intervals by their starting times.
   - Traverse the sorted list:
       - If current interval overlaps with previous → merge them.
       - Otherwise, push previous into result and move to next.
   - Collect merged intervals in a list.

🛠️ Time Complexity: O(n log n) (sorting dominates)  
🛠️ Space Complexity: O(n) (for result list)  
✅ Status: Accepted on LeetCode
*/
