// 🔍 Problem: Merge Two Sorted Lists
// 📝 Link: https://leetcode.com/problems/merge-two-sorted-lists/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Infosys, Microsoft, Google

/*
👨‍💻 Problem Statement:
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

🧾 Example:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []

Input: list1 = [], list2 = [0]
Output: [0]
*/

public class Solution {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify handling head
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists and add the smaller node each time
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Add the remaining nodes of list1 or list2
        current.next = (list1 != null) ? list1 : list2;

        // Return the next of dummy node which is the actual head
        return dummy.next;
    }
}

/*
🧠 Approach:
- Use a dummy node to avoid handling special cases for the head.
- Use a pointer `current` to build the new list.
- Compare values from both input lists and append the smaller node to the result.
- When one list ends, append the remaining nodes of the other list.

🛠️ Time Complexity: O(n + m), where n and m are lengths of the input lists
🛠️ Space Complexity: O(1), iterative approach with no extra space used

✅ Status: Accepted on LeetCode
*/
