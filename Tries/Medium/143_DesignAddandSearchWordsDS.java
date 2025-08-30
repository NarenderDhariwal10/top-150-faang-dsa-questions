// 🔍 Problem: Design Add and Search Words Data Structure
// 📝 Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

/*
👨‍💻 Problem Statement:
Design a data structure that supports adding new words and finding if a string matches 
any previously added string.

Implement the WordDictionary class:
- WordDictionary() Initializes the object.
- void addWord(String word) Adds word to the data structure.
- boolean search(String word) Returns true if there is any string in the data structure that matches word 
  or a word consisting of letters + '.' where '.' can represent any letter.

🧾 Example:
Input:
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return false
wordDictionary.search("bad"); // return true
wordDictionary.search(".ad"); // return true
wordDictionary.search("b.."); // return true

Output:
false
true
true
true

*/

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word into the data structure
    public void addWord(String word) {
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

    // Search for a word in the data structure
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isEndOfWord;

        char ch = word.charAt(index);
        if (ch == '.') {
            // try all possible children
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            return dfs(word, index + 1, node.children[idx]);
        }
    }
}

/*
🧠 Approach:
- Use a TrieNode class with:
   - Array of children[26] for each character 'a' to 'z'.
   - Boolean flag isEndOfWord to mark if a word ends here.
- addWord(word): Traverse characters, create nodes if absent, mark last as word-end.
- search(word): 
   - Traverse each char:
       - If normal letter → follow child.
       - If '.' → try all 26 children recursively (DFS).
- Return true if a complete word is matched.

🛠️ Time Complexity:
- addWord: O(L), where L = length of word
- search: O(26^L) worst case when all characters are '.'  
  (but usually much faster with pruning)

🛠️ Space Complexity: O(N * 26) where N = total characters inserted

✅ Status: Accepted on LeetCode
*/
