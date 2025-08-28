// 🔍 Problem: Word Ladder
// 📝 Link: https://leetcode.com/problems/word-ladder/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Microsoft, Facebook, Google, Bloomberg

/*
👨‍💻 Problem Statement:
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words:
- The first word is beginWord
- The last word is endWord
- Only one letter can be changed at a time
- Each transformed word must exist in the wordList

Return the length of the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

🧾 Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: "hit" -> "hot" -> "dot" -> "dog" -> "cog"

🧾 Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: endWord "cog" is not in wordList, so no transformation sequence.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return steps;

                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String newWord = new String(chars);

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // mark visited
                        }
                    }

                    chars[j] = original; // restore
                }
            }
            steps++;
        }

        return 0;
    }
}

/*
🧠 Approach:
- Use **BFS** to find the shortest path from `beginWord` to `endWord`.
- Each transformation changes one character at a time.
- At every step:
   - Try all possible one-letter transformations.
   - If a transformed word exists in the `wordList`, enqueue it and mark as visited.
- Stop when we reach the `endWord`.

🛠️ Time Complexity: O(N * M * 26)
   - N = number of words in the list
   - M = length of each word
🛠️ Space Complexity: O(N) for the queue and visited set
✅ Status: Accepted on LeetCode
*/
