// 🔍 Problem: Palindrome Linked List
// 📝 Link: https://leetcode.com/problems/palindrome-linked-list/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Bloomberg, Microsoft

/*
👨‍💻 Problem Statement:
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

🧾 Example:
Input: head = [1,2,2,1]
Output: true

Input: head = [1,2]
Output: false
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalfHead = reverse(slow);
        ListNode firstHalfPointer = head;

        // Step 3: Compare both halves
        while (secondHalfHead != null) {
            if (firstHalfPointer.val != secondHalfHead.val) return false;
            firstHalfPointer = firstHalfPointer.next;
            secondHalfHead = secondHalfHead.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}

/*
🧠 Approach:
1. Use fast and slow pointers to find the midpoint of the list.
2. Reverse the second half of the list.
3. Compare first half and reversed second half node by node.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
