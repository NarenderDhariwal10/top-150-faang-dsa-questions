// 🔍 Problem: Delete Node in a Linked List
// 📝 Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
There is a singly-linked list, and you are given the `node` to be deleted (not the head of the list). 
You have to delete the given node from the linked list.

🧾 Example:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Copy the value from the next node into the current node
        node.val = node.next.val;
        // Bypass the next node
        node.next = node.next.next;
    }
}

/*
🧠 Approach:
- Since we are given only the node to delete (and not the previous node),
  we copy the value of the next node into the current node and remove the next node instead.

⚠️ Note: This problem guarantees that the node is not the tail, so this approach is safe.

🛠️ Time Complexity: O(1)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
