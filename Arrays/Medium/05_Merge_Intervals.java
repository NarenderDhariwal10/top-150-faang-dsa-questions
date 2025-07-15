// 🔍 Problem: Merge Intervals
// 📝 Link: https://leetcode.com/problems/merge-intervals/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Microsoft, Adobe, Facebook

/*
👨‍💻 Problem Statement:
Given an array of intervals where intervals[i] = [start_i, end_i], 
merge all overlapping intervals and return an array of the non-overlapping intervals 
that cover all the intervals in the input.

🧾 Example:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]

Explanation: 
- [1,3] and [2,6] overlap, so merge them into [1,6].
*/

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: if only one or no interval
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            int currentStart = current[0];
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to next interval
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

/*
🧠 Approach:
- Sort intervals by starting time.
- Iterate and compare current interval with the previous one.
- Merge if overlapping, else add as a new interval.

🛠️ Time Complexity: O(n log n)
- Due to sorting

🛠️ Space Complexity: O(n)
- Extra list to store merged intervals

✅ Status: Accepted on LeetCode
*/
