// 🔍 Problem: Daily Temperatures
// 📝 Link: https://leetcode.com/problems/daily-temperatures/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Facebook, Google

/*
👨‍💻 Problem Statement:
Given an array `temperatures` where `temperatures[i]` is the daily temperature on day i,
return an array `answer` such that `answer[i]` is the number of days you have to wait 
after the i-th day to get a warmer temperature. If there is no future day for which this is possible, 
keep answer[i] = 0.

🧾 Example:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Explanation:  
- For day 0 (73°F), warmer temperature is 74°F at day 1 → wait 1 day.
- For day 2 (75°F), warmer temperature is 76°F at day 6 → wait 4 days.
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices of days

        for (int i = 0; i < n; i++) {
            // While current temperature > temperature at top index of stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay; // number of days waited
            }
            stack.push(i); // push current day's index
        }

        // Days without warmer temperature remain 0
        return answer;
    }
}

/*
🧠 Approach:
- Use a monotonic decreasing stack to keep track of indices with unresolved warmer temperatures.
- Iterate through the temperatures, and for each day:
  - Pop from stack while current temperature is warmer than the top.
  - Calculate days waited and update the answer array.
- Push current day index to stack.
- Remaining indices in stack have no warmer future days → answer[i] stays 0.

🛠️ Time Complexity: O(n) → Each index is pushed/popped at most once
🛠️ Space Complexity: O(n) → Stack for indices

✅ Status: Accepted on LeetCode
*/
