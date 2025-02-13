/*
🔍 Intuition
The goal is to make all numbers in the array greater than or equal to k by performing a merge operation:

    - Pick the two smallest numbers.
    - Create a new number:
        * 2×min(first,second)+max(first,second)
    - Repeat until the smallest number is at least k.

Since we always merge the two smallest numbers, a Min-Heap (PriorityQueue) is the optimal data structure for this task.

💡 Approach
Step 1: Use a Min-Heap (PriorityQueue):
    - Insert all elements from nums into the heap.

Step 2. Iterate until the smallest element is ≥ k:
    - Poll the two smallest numbers (first and second).
    - Compute the new number:
        * newNum=2×min(first,second)+max(first,second)
    - Push the new number back into the heap.
    - Increment count (cnt) for each merge operation.

Step 3. Return the number of operations needed to reach k.

⏱️ Complexity
Time Complexity:
    - O(N log N) : Due to heap operations (each insertion and deletion takes O(logn)).

Space Complexity:
    - O(N) : For storing elements in the priority queue.
 */

package Minimum_Operations_to_Exceed_Threshold_Value_II_3066;

import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); // Min-Heap to store numbers

        // Add all numbers to the heap
        for (int num : nums) {
            minHeap.add((long) num);
        }

        int operations = 0; // Count of merge operations

        // Process until the smallest number in the heap is at least k
        while (minHeap.peek() < k) {
            long first = minHeap.poll(); // Smallest element
            long second = minHeap.poll(); // Second smallest element

            // Compute new number and add it back
            minHeap.add(2 * Math.min(first, second) + Math.max(first, second));

            operations++; // Increment operation count
        }

        return operations; // Return the number of operations performed
    }
}

