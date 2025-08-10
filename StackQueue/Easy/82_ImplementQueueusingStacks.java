// 🔍 Problem: Implement Queue using Stacks
// 📝 Link: https://leetcode.com/problems/implement-queue-using-stacks/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
Implement a first in first out (FIFO) queue using only two stacks. 
The implemented queue should support all the functions of a normal queue (push, pop, peek, and empty).

Implement the MyQueue class:
- void push(int x) Pushes element x to the back of the queue.
- int pop() Removes the element from the front of the queue and returns it.
- int peek() Returns the element at the front of the queue.
- boolean empty() Returns true if the queue is empty, false otherwise.

🧾 Example:
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2]
myQueue.peek();  // return 1
myQueue.pop();   // return 1, queue is [2]
myQueue.empty(); // return false
*/

public class Solution {
    class MyQueue {
        private Stack<Integer> inputStack;
        private Stack<Integer> outputStack;

        public MyQueue() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            peek(); // Ensure outputStack has current elements
            return outputStack.pop();
        }

        public int peek() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }
}

/*
🧠 Approach:
- Use two stacks: inputStack for enqueue (push), outputStack for dequeue (pop/peek).
- When outputStack is empty, transfer all elements from inputStack to outputStack to reverse order.
- Pop and peek from outputStack for FIFO behavior.

🛠️ Time Complexity: Amortized O(1) per operation.
🛠️ Space Complexity: O(n) for the stacks.

✅ Status: Accepted on LeetCode
*/
