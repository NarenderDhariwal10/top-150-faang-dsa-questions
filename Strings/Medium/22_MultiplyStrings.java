// 🔍 Problem: Multiply Strings
// 📝 Link: https://leetcode.com/problems/multiply-strings/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google

/*
👨‍💻 Problem Statement:
Given two non-negative integers `num1` and `num2` represented as strings,
return the product of `num1` and `num2`, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

🧾 Example:
Input: num1 = "2", num2 = "3"
Output: "6"

Input: num1 = "123", num2 = "456"
Output: "56088"
*/

public class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either is "0"
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] result = new int[num1.length() + num2.length()];

        // Multiply digits from the end
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;      // carry position
                int p2 = i + j + 1;  // current digit position

                int sum = mul + result[p2];

                result[p2] = sum % 10;     // update current digit
                result[p1] += sum / 10;    // carry over
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            if (!(sb.length() == 0 && val == 0)) { // skip leading zero
                sb.append(val);
            }
        }

        return sb.toString();
    }
}

/*
🧠 Approach:
- Simulate the manual multiplication process digit by digit.
- Use an array to store intermediate sums at the correct positions.
- Convert the result array to string after handling all carry overs.

🛠️ Time Complexity: O(m * n) where m and n are lengths of num1 and num2
🛠️ Space Complexity: O(m + n)

✅ Status: Accepted on LeetCode
*/
