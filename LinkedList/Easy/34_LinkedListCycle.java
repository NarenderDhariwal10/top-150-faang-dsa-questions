// 🔍 Problem: Linked List Cycle
// 📝 Link: https://leetcode.com/problems/linked-list-cycle/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Adobe, Google

/*
👨‍💻 Problem Statement:
Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again 
by continuously following the `next` pointer.

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

🧾 Example:
Input: head = [3,2,0,-4], pos = 1 (cycle at node 2)
Output: true

Input: head = [1,2], pos = 0
Output: true

Input: head = [1], pos = -1
Output: false
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 step, fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, no cycle
        return false;
    }
}

/*
🧠 Approach:
- Use Floyd’s Tortoise and Hare algorithm (two pointers).
- One pointer moves one step at a time, the other moves two steps.
- If there is a cycle, they will meet at some point.
- If no cycle, the fast pointer will reach the end.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
