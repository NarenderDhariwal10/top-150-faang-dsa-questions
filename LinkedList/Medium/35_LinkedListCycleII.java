// 🔍 Problem: Linked List Cycle II
// 📝 Link: https://leetcode.com/problems/linked-list-cycle-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
Given the head of a linked list, return the node where the cycle begins. 
If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that 
can be reached again by continuously following the next pointer.

Do not modify the linked list.

🧾 Example:
Input: head = [3,2,0,-4], pos = 1
Output: Node with value 2 (cycle starts here)

Input: head = [1,2], pos = 0
Output: Node with value 1

Input: head = [1], pos = -1
Output: null
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        // Step 1: Detect if a cycle exists and calculate its length
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        // If no cycle
        if (length == 0) return null;

        // Step 2: Find the start node of the cycle
        ListNode first = head;
        ListNode second = head;

        // Move second ahead by cycle length
        while (length > 0) {
            second = second.next;
            length--;
        }

        // Move both at same pace, they'll meet at start of cycle
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    // Helper to calculate the length of the cycle
    private int lengthCycle(ListNode node) {
        ListNode current = node;
        int length = 0;

        do {
            current = current.next;
            length++;
        } while (current != node);

        return length;
    }
}

/*
🧠 Approach:
- Use Floyd’s Tortoise and Hare algorithm to detect a cycle and find its length.
- Then move one pointer ahead by the length of the cycle.
- Move both pointers one step at a time. They will meet at the start of the cycle.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
