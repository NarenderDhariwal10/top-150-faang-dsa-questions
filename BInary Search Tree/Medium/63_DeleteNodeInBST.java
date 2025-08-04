// 🔍 Problem: Delete Node in a BST
// 📝 Link: https://leetcode.com/problems/delete-node-in-a-bst/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe

/*
👨‍💻 Problem Statement:
Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node of the BST after deletion.

The deletion should maintain the **BST property**.

🧾 Example:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Node with key 3 is deleted. It is replaced with its inorder successor (4).

Tree before deletion:
      5
     / \
    3   6
   / \    \
  2   4    7

Tree after deletion:
      5
     / \
    4   6
   /      \
  2        7

*/

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

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Traverse the BST to find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with the key found

            // Case 1: No children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Node has both children
            // Find inorder successor (smallest in right subtree)
            TreeNode inorderSuccessor = findMin(root.right);

            // Replace root's value with successor's value
            root.val = inorderSuccessor.val;

            // Delete the inorder successor node
            root.right = deleteNode(root.right, inorderSuccessor.val);
        }

        return root;
    }

    // Helper function to find the minimum node (inorder successor)
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

/*
🧠 Approach:
- Use BST property to locate the node.
- Handle 3 deletion cases: no child, one child, two children.
- For two children: Replace with inorder successor (minimum in right subtree).

🛠️ Time Complexity: O(h) = O(log n) for balanced BST, O(n) in worst-case
🛠️ Space Complexity: O(h) = recursive call stack

✅ Status: Accepted on LeetCode
*/
