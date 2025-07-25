// 🔍 Problem: Middle of the Linked List
// 📝 Link: https://leetcode.com/problems/middle-of-the-linked-list/
// 🎯 Difficulty: Easy
// 🏢 Asked in: MIcrosoft, Google, Facebook, Amazon

/*
👨‍💻 Problem Statement:
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

🧾 Example:
Input: head = [1,2,3,4,5]
Output: 3

Input: head = [1,2,3,4,5,6]
Output: 4
*/

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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches the end, slow is at the middle
        return slow;
    }
}

/*
🧠 Approach:
- Use two pointers: slow and fast.
- Fast moves 2 steps at a time while slow moves 1 step.
- When fast reaches the end, slow will be at the middle.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
