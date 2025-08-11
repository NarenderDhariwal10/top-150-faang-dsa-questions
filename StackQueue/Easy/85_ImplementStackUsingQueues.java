// 🔍 Problem: Implement Stack using Queues
// 📝 Link: https://leetcode.com/problems/implement-stack-using-queues/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
Implement a last-in-first-out (LIFO) stack using only two queues.
The implemented stack should support all the functions of a normal stack: push, pop, top, and empty.

Implement the MyStack class:
- void push(int x) Pushes element x onto the stack.
- int pop() Removes the element on the top of the stack and returns it.
- int top() Returns the element on the top of the stack.
- boolean empty() Returns true if the stack is empty, false otherwise.

You must use only standard operations of a queue — which means only `offer` (push to back), `poll` (pop from front),
`peek` (peek front), `size`, and `isEmpty` are valid.

🧾 Example:
Input:
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output:
[null, null, null, 2, 2, false]

*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // Constructor (acts as MyStack())
    public Solution() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        // 1. Add new element to q2
        q2.offer(x);
        // 2. Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // 3. Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns it.
    public int pop() {
        return q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}

/*
🧠 Approach:
Use two queues (q1, q2). Maintain invariant: q1 contains the stack elements with the top at the front.
- push(x): offer x into q2, then move all elements from q1 to q2, then swap q1 and q2. This keeps newest element at front.
- pop(): poll from q1 (front).
- top(): peek q1.
- empty(): check q1.isEmpty().

🛠️ Time Complexity:
- push(): O(n)
- pop(): O(1)
- top(): O(1)
- empty(): O(1)

🛠️ Space Complexity: O(n)
✅ Status: Ready to push — file name: 225_ImplementStackUsingQueues.java
*/
