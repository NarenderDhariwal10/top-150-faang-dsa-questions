// 🔍 Problem: Gas Station
// 📝 Link: https://leetcode.com/problems/gas-station/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Google, Microsoft, Uber

/*
📝 Problem Statement:
   There are n gas stations along a circular route, where the amount of gas at the i-th station is gas[i].
   You have a car with an unlimited gas tank and it costs cost[i] gas to travel from the i-th station to its next station (i+1).
   You begin the journey with an empty tank at one of the gas stations.

   Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction.
   If it is not possible, return -1.

   🧾 Example:
   Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
   Output: 3
   Explanation: Start at station 3 (index 3).
   - Fill up with 4 → travel to 4 (remaining gas = 4 - 1 = 3)
   - Fill up with 5 → travel to 0 (remaining gas = 3 + 5 - 2 = 6)
   - Fill up with 1 → travel to 1 (remaining gas = 6 + 1 - 3 = 4)
   - Fill up with 2 → travel to 2 (remaining gas = 4 + 2 - 4 = 2)
   - Fill up with 3 → travel to 3 (remaining gas = 2 + 3 - 5 = 0)
   ✅ We made a full circle starting at station 3.

   Input: gas = [2,3,4], cost = [3,4,3]
   Output: -1
   Explanation: You cannot complete the circuit.
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;   // net gain/loss
        int currentTank = 0; // fuel left in current path
        int startIndex = 0;  // candidate starting index

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currentTank += diff;

            // If at any point, fuel goes negative → reset start point
            if (currentTank < 0) {
                startIndex = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? startIndex : -1;
    }
}

/*
🧠 Approach :
   - Check if total gas is at least total cost → only then possible.
   - Traverse stations, track `currentTank`:
       - If `currentTank` drops < 0, reset starting index to i+1.
   - At the end, if `totalTank >= 0`, return `startIndex`.

🛠️ Time Complexity: O(n)  
🛠️ Space Complexity: O(1)  
✅ Status: Accepted on LeetCode
