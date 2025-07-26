// 🔍 Problem: Add Two Numbers
// 📝 Link: https://leetcode.com/problems/add-two-numbers/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Microsoft, Apple, Facebook

/*
👨‍💻 Problem Statement:
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

🧾 Example:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify code
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}

/*
🧠 Approach:
- Use a dummy node to handle edge cases.
- Traverse both linked lists and keep adding values + carry.
- Create new nodes with sum % 10 and update carry = sum / 10.
- If carry remains at the end, add an extra node.

🛠️ Time Complexity: O(max(n, m)), where n and m are lengths of the input lists
🛠️ Space Complexity: O(max(n, m)), for the new result list

✅ Status: Accepted on LeetCode
*/
