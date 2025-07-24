// 🔍 Problem: Reverse Linked List
// 📝 Link: https://leetcode.com/problems/reverse-linked-list/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
Given the head of a singly linked list, reverse the list, and return the reversed list.

🧾 Example:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]

Input: head = []
Output: []


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next; // save next
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }
        
        return prev; 
    }
}

/*
🧠 Approach:
- Initialize two pointers: `prev` as null and `curr` as the head.
- Iterate over the list:
   - Save the next node (curr.next).
   - Point curr.next to the previous node (reverse the link).
   - Move `prev` to current node and `curr` to the next saved node.
- Finally, return `prev` as the new head of the reversed list.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/