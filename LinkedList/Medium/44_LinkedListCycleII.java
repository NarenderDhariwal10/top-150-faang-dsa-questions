// 🔍 Problem: Linked List Cycle II
// 📝 Link: https://leetcode.com/problems/linked-list-cycle-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. (0-indexed)

🧾 Example:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1

Input: head = [1,2], pos = 0
Output: tail connects to node index 0

Input: head = [1], pos = -1
Output: no cycle
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

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // Find the start node of the cycle
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // Move both pointers one step at a time; they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    private int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // Calculate the length of the cycle
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
}

/*
🧠 Approach:
- Use Floyd's Cycle Detection Algorithm to check for a cycle.
- If a cycle is detected, calculate the cycle's length.
- Use two pointers to find the starting node of the cycle.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
