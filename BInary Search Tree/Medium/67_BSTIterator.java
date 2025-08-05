// 🔍 Problem: BST Iterator
// 📝 Link: https://leetcode.com/problems/binary-search-tree-iterator/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Facebook, Bloomberg

/*
👨‍💻 Problem Statement:
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST). The iterator should be initialized with the root node of a BST.

The class should support the following operations:
- BSTIterator(TreeNode root): Initializes the object with the root of the BST.
- boolean hasNext(): Returns true if there exists a next smallest number in the BST.
- int next(): Returns the next smallest number in the BST.

You must implement it such that next() and hasNext() run in average O(1) time and use O(h) memory, where h is the height of the tree.

🧾 Example:
Input:
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7,3,15,null,null,9,20]],[],[],[],[],[],[],[],[],[]]

Output:
[null, 3, 7, true, 9, true, 15, true, 20, false]

Tree:
        7
       / \
      3   15
         /  \
        9    20
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

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftBranch(root);
    }

    // Helper to push all left children to stack
    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            pushLeftBranch(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/*
🧠 Approach:
- Use a stack to simulate the in-order traversal.
- Initially push all left children of root.
- For next(): pop top node and push left children of right child if any.
- hasNext(): return true if stack is not empty.

🛠️ Time Complexity:
- next() and hasNext(): Average O(1) per operation
- Amortized over n operations, total time is O(n)

🛠️ Space Complexity: O(h), where h is the height of the tree

✅ Status: Accepted on LeetCode
