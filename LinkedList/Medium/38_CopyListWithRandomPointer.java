// 🔍 Problem: Copy List with Random Pointer
// 📝 Link: https://leetcode.com/problems/copy-list-with-random-pointer/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Facebook, Adobe, Microsoft

/*
👨‍💻 Problem Statement:
A linked list of length n is given such that each node contains an additional random pointer, 
which could point to any node in the list or null. Construct a deep copy of the list. 
The deep copy should consist of exactly n brand new nodes, where each new node has its value 
set to the value of its corresponding original node. Both the next and random pointer of the 
new nodes should point to new nodes in the copied list such that the pointers in the original list 
and copied list represent the same list state. None of the pointers in the new list should point 
to nodes in the original list.

Return the head of the copied linked list.

🧾 Example:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a mapping from original node to copied node
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node copiedNode = map.get(curr);
            copiedNode.next = map.get(curr.next);
            copiedNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}

/*
🧠 Approach:
- Use a HashMap to store a mapping between original and copied nodes.
- First loop: Create new nodes and store them in the map.
- Second loop: Set the next and random pointers using the map.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n) for the HashMap

✅ Status: Accepted on LeetCode
*/
