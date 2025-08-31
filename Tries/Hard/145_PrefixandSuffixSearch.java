// 🔍 Problem: Prefix and Suffix Search
// 📝 Link: https://leetcode.com/problems/prefix-and-suffix-search/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Google, Facebook, Microsoft, Amazon

/*
👨‍💻 Problem Statement:
Design a special data structure that supports two functions:
- WordFilter(String[] words): Initializes the object with the words in the dictionary.
- f(String prefix, String suffix): Returns the index of the word in the dictionary 
  which has the prefix "prefix" and the suffix "suffix". 
  If more than one valid index exists, return the largest index. If no word exists, return -1.

🧾 Example:
Input: 
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output: 
[null, 0]

Explanation:
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0
*/

class WordFilter {
    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        
        // Build all possible prefix + suffix combinations
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int len = word.length();

            for (int p = 0; p <= len; p++) {
                String prefix = word.substring(0, p);
                for (int s = 0; s <= len; s++) {
                    String suffix = word.substring(len - s);
                    // Store combination "prefix#suffix" with word's index
                    map.put(prefix + "#" + suffix, index);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}

/*
🧠 Approach:
- Brute force prefix-suffix search for each query would be too slow.
- Precompute all possible (prefix, suffix) pairs for each word.
- Store them in a HashMap with key = "prefix#suffix" and value = index.
- During query, directly return index from map if exists.

🛠️ Time Complexity:
- Preprocessing: O(N * L^2), 
  where N = number of words, L = max word length (generate all prefix-suffix pairs).
- Query: O(1)

🛠️ Space Complexity: O(N * L^2) for storing all combinations.

✅ Status: Accepted on LeetCode
*/
