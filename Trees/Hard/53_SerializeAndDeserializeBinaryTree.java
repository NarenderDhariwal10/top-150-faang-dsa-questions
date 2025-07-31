// 🔍 Problem: Serialize and Deserialize Binary Tree
// 📝 Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Google, Amazon, Facebook

/*
👨‍💻 Problem Statement:
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored or transmitted and reconstructed later.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

🧾 Example:
Input: root = [1,2,3,null,null,4,5]

         1
       /   \
      2     3
           / \
          4   5

Output after serialize: "1,2,null,null,3,4,null,null,5,null,null"



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}

/*
🧠 Approach:
- Use pre-order traversal for both serialization and deserialization.
- Append `null` markers for empty nodes during serialization.
- Reconstruct using queue from left to right during deserialization.

🛠️ Time Complexity:
- Serialize: O(n)
- Deserialize: O(n)

🛠️ Space Complexity: O(n) – For recursion stack and the queue

✅ Status: Accepted on LeetCode
*/
