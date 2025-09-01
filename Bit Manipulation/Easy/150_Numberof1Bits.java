// 🔍 Problem: Number of 1 Bits (Hamming Weight)
// 📝 Link: https://leetcode.com/problems/number-of-1-bits/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Google, Amazon, Microsoft, Apple

/*
👨‍💻 Problem Statement:
Write a function that takes an unsigned integer and returns the number of '1' bits 
it has (also known as the Hamming weight).

🧾 Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string has a total of three '1' bits.

🧾 Example 2:
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string has a total of one '1' bit.

🧾 Example 3:
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string has a total of thirty-one '1' bits.
*/

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // check last bit
            n >>>= 1;         // unsigned right shift
        }
        return count;
    }
}

/*
🧠 Approach:
- Use bitwise AND `n & 1` to check if the last bit is 1.
- Right shift the number (unsigned) until it becomes 0.
- Count how many times the last bit was 1.

🛠️ Time Complexity:
- O(32) = O(1), since we only check up to 32 bits.

🛠️ Space Complexity:
- O(1), only integer variables used.

✅ Status: Accepted on LeetCode
*/
