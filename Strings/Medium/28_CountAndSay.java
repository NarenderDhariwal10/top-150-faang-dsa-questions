// 🔍 Problem: Count and Say
// 📝 Link: https://leetcode.com/problems/count-and-say
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google

/*
👨‍💻 Problem Statement:
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

- countAndSay(1) = "1"
- countAndSay(n) is the way you would "say" the previous term

To determine countAndSay(n), start with countAndSay(n - 1) and read off the digits,
counting the number of digits in groups of the same digit.

🧾 Example:
Input: n = 4
Output: "1211"

Explanation:
countAndSay(1) = "1"
countAndSay(2) = "11"     // one 1
countAndSay(3) = "21"     // two 1s
countAndSay(4) = "1211"   // one 2, then one 1
*/

public class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) return "1";

        // Recursively get the previous term
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            // If same character, increase count
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                // Append count and the digit
                sb.append(count).append(prev.charAt(i - 1));
                count = 1; // Reset count
            }
        }

        // Append the last group
        sb.append(count).append(prev.charAt(prev.length() - 1));

        return sb.toString();
    }
}

/*
🧠 Approach:
- Use recursion: `countAndSay(n) = say(countAndSay(n - 1))`
- Read the previous string and count consecutive digits, appending counts and characters.

🛠️ Time Complexity: O(2^n) (approximate, due to recursion and repeated string construction)
🛠️ Space Complexity: O(2^n) for recursion + output string

✅ Status: Accepted on LeetCode
*/
