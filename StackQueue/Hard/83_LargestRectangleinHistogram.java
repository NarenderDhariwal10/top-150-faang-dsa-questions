// 🔍 Problem: Largest Rectangle in Histogram
// 📝 Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given an array of integers `heights` representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

🧾 Example:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The largest rectangle has area 10 (between bars with heights 5 and 6).

Input: heights = [2,4]
Output: 4
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        // Add a sentinel index for easier handling (optional)
        // stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int popped = stack.pop();
        int area;
        if (stack.isEmpty()) {
            area = arr[popped] * i;
        } else {
            area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
}

/*
🧠 Approach:
- Use a stack to keep indexes of bars.
- Maintain increasing height indexes in the stack.
- When a current bar is shorter than the stack's top bar height, calculate area with the top bar as the smallest height.
- Continue until stack is empty and calculate max area.

🛠️ Time Complexity: O(n) - Each element is pushed and popped at most once.
🛠️ Space Complexity: O(n) - Stack space.
*/
