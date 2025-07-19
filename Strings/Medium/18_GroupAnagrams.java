// 🔍 Problem: Group Anagrams  
// 📝 Link: https://leetcode.com/problems/group-anagrams/  
// 🎯 Difficulty: Medium  
// 🏢 Asked in: Amazon, Facebook, Google 

/*
👨‍💻 Problem Statement:
Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

Two strings are anagrams if they contain the same characters in different orders.

🧾 Example:
Input: strs = ["eat","tea","tan","ate","nat","bat"]  
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // Sort characters to get the key
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

/*
🧠 Approach:
- Use a HashMap where the key is the sorted version of the string.
- Group all anagrams under the same key.

🛠️ Time Complexity: O(n * k log k), where n = number of strings and k = length of each string  
🛠️ Space Complexity: O(n * k)

✅ Status: Accepted on LeetCode
*/
