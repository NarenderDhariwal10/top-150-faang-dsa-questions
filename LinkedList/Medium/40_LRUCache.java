// 🔍 Problem: LRU Cache
// 📝 Link: https://leetcode.com/problems/lru-cache/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Flipkart, Google, Apple

/*
👨‍💻 Problem Statement:
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if it exists. Otherwise, 
  add the key-value pair to the cache. If the number of keys exceeds the capacity 
  from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

🧾 Example:
Input:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1,1], [2,2], [1], [3,3], [2], [4,4], [1], [3], [4]]

Output:
[null, null, null, 1, null, -1, null, -1, 3, 4]
*/

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail to simplify operations
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insertToFront(new Node(key, value));
    }

    // Remove a node from the doubly linked list and map
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node just after dummy head
    private void insertToFront(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

/*
🧠 Approach:
- Use a combination of HashMap (for O(1) access) and Doubly Linked List (for tracking usage order).
- Recently used nodes are moved to the front (after dummy head).
- When cache exceeds capacity, remove the node before dummy tail (least recently used).

🛠️ Time Complexity: O(1) for both get() and put()
🛠️ Space Complexity: O(capacity)

✅ Status: Accepted on LeetCode
*/
