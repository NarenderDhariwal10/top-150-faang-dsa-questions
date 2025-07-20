// 🔍 Problem: String Compression
// 📝 Link: https://leetcode.com/problems/string-compression/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Facebook, Amazon, Google

/*
👨‍💻 Problem Statement:
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:
- If the group's length is 1, append the character to s.
- Otherwise, append the character followed by the group's length.

The compressed string should not be returned separately, but instead stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array in-place, return the new length of the array.

🧾 Example:
Input: chars = ['a','a','b','b','c','c','c']
Output: 6
Explanation: The first 6 characters of the input array should be: ['a','2','b','2','c','3']

Input: chars = ['a']
Output: 1
Explanation: The array is already compressed.

Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
Output: 4
Explanation: The first 4 characters should be: ['a','b','1','2']
*/

public class Solution {
    public int compress(char[] chars) {
        int index = 0;  // Index to insert characters in array
        int i = 0;      // Pointer to traverse chars array

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count frequency of current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Insert the character
            chars[index++] = currentChar;

            // Insert the count if more than 1
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // New length of the compressed array
    }
}

/*
🧠 Approach:
- Use two pointers: one to traverse, another to write.
- Count consecutive characters and write the character and its count in-place.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1) (in-place)

✅ Status: Accepted on LeetCode
*/
