// 🔍 Problem: Replace Words
// 📝 Link: https://leetcode.com/problems/replace-words/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft, Apple

/*
👨‍💻 Problem Statement:
In English, we have a concept called *root*, which can be followed by some other word to form 
another longer word - let's call this word a successor. For example, the root "cat" can form 
"catapult" and "catalog".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, 
replace all the successors in the sentence with the root forming it. If a successor can be replaced 
by more than one root, replace it with the root with the shortest length.

Return the sentence after replacement.

🧾 Example 1:
Input: dictionary = ["cat","bat","rat"], 
       sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

🧾 Example 2:
Input: dictionary = ["a","b","c"], 
       sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
*/

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Solution {

    private TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        // Insert dictionary roots into Trie
        for (String word : dictionary) {
            insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for (String word : words) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(getRoot(word));
        }

        return sb.toString();
    }

    // Insert a root word into Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    // Find the shortest root for a given word
    private String getRoot(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null || node.isEndOfWord) {
                break;
            }
            prefix.append(ch);
            node = node.children[idx];
        }

        return node.isEndOfWord ? prefix.toString() : word;
    }
}

/*
🧠 Approach:
- Build a Trie with all root words from dictionary.
- For each word in the sentence:
   - Traverse Trie character by character.
   - If we encounter an `isEndOfWord`, replace the word with this root.
   - If no root is found, keep the original word.
- Join the processed words to form the result.

🛠️ Time Complexity:
- Insert: O(N * L), where N = number of roots, L = max length of root
- Replace each word: O(M * K), where M = number of words, K = max word length
- Overall: O(N*L + M*K)

🛠️ Space Complexity: O(N * L) for the Trie

✅ Status: Accepted on LeetCode
*/
