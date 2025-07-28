// 🔍 Problem: Flatten a Multilevel Doubly Linked List
// 📝 Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Bloomberg

/*
👨‍💻 Problem Statement:
You are given a doubly linked list, which in addition to the next and previous pointers, may have a child pointer,
which may point to a separate doubly linked list. These child lists may also have one or more child nodes of their own, and so on.

Return the list as a single-level doubly linked list.

🧾 Example:
Input: 1---2---3---4---5---6--NULL
               |
               7---8---9---10--NULL
                   |
                   11--12--NULL

Output: 1-2-3-7-8-11-12-9-10-4-5-6
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node prev = pseudoHead;

        flattenDFS(prev, head);

        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    // DFS helper function to flatten the list
    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;

        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child); // flatten child first
        curr.child = null;

        return flattenDFS(tail, tempNext); // then flatten the next
    }
}


/*
🧠 Approach:
1. Use Depth First Search to visit child before moving to the next node.
2. Link each child into the main list and continue flattening recursively.
3. Disconnect child pointers after flattening.

🛠️ Time Complexity: O(n), where n is the total number of nodes
🛠️ Space Complexity: O(n) recursive stack in worst case (for deepest nesting)

✅ Status: Accepted on LeetCode
*/


