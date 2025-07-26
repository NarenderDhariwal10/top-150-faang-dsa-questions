// 🔍 Problem: Reorder List
// 📝 Link: https://leetcode.com/problems/reorder-list/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
You are given the head of a singly linked list. The list can be represented as:
L0 → L1 → … → Ln-1 → Ln

Reorder the list to be on the form:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

You must do this in-place without altering the nodes' values.

🧾 Example:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // split the list
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Merge two halves
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}

/*
🧠 Approach:
1. Use fast and slow pointers to find the middle.
2. Reverse the second half of the list.
3. Merge the first and second half alternately.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1) — in-place

✅ Status: Accepted on LeetCode
*/
