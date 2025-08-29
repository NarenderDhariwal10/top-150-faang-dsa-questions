// 🔍 Problem: Implement Trie (Prefix Tree)
// 📝 Link: https://leetcode.com/problems/implement-trie-prefix-tree/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

/*
👨‍💻 Problem Statement:
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently 
store and retrieve keys in a dataset of strings. There are various applications of this data 
structure, such as autocomplete and spellchecker.

Implement the Trie class:

- Trie() Initializes the trie object.
- void insert(String word) Inserts the string word into the trie.
- boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
- boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

🧾 Example:
Input:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return true
trie.search("app");     // return false
trie.startsWith("app"); // return true
trie.insert("app");
trie.search("app");     // return true

Output:
true
false
true
true

🔒 Constraints:
- 1 <= word.length, prefix.length <= 2000
- word and prefix consist only of lowercase English letters.
- At most 3 * 10^4 calls will be made to insert, search, and startsWith.
*/

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // for lowercase English letters
        isEndOfWord = false;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
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

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
}

/*
🧠 Approach:
- Use a TrieNode class with:
   - Array of children[26] for each character 'a' to 'z'.
   - Boolean flag isEndOfWord to mark if a word ends here.
- insert(word): Traverse characters, create new nodes if absent, mark last node as word-end.
- search(word): Traverse characters, return true only if end flag is true.
- startsWith(prefix): Traverse characters, return true if traversal succeeds.

🛠️ Time Complexity:
- Insert: O(L) where L = length of word
- Search: O(L)
- StartsWith: O(P) where P = length of prefix

🛠️ Space Complexity: O(N * 26) in worst case (N = total characters inserted)

✅ Status: Accepted on LeetCode
*/
