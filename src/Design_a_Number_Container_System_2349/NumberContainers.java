/*
🔍 Intuition
We need a data structure that allows:
    - Efficient updates: Assigning a number to an index.
    - Fast retrieval: Finding the smallest index that holds a given number.
A HashMap works well for direct lookups, but to efficiently find the smallest index,
we use a min-heap (priority queue) that automatically maintains indices in sorted order.

💡 Approach
    - Data Structures Used
        * Map<Integer, Integer> map_index_num - Stores index → number (Tracks the latest number assigned to each index).
        * Map<Integer, PriorityQueue<Integer>> map_num_minIndex - Maps each number → min-heap of indices (Keeps track of all indices where a number appears).

    - change(int index, int number)
        * If index is already assigned number, do nothing.
        * Otherwise, update map_index_num with index → number.
        * Add index to the min-heap for this number in map_num_minIndex.

    - find(int number)
        * If number is not in map_num_minIndex, return -1.
        * Get the smallest index from the min-heap of number.
        * Remove outdated indices (i.e., indices where map_index_num[index] was changed).
        * Return the smallest valid index.

⏱️ Complexity
Time Complexity:
    - O(N log N) Efficient for handling large datasets

Space Complexity:
    - O(N)

 */

package Design_a_Number_Container_System_2349;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class NumberContainers {
    // Stores mapping of index to its assigned number
    Map<Integer, Integer> map_index_num;

    // Stores mapping of numbers to a min-heap of indices where they appear
    Map<Integer, PriorityQueue<Integer>> map_num_minIndex;

    public NumberContainers() {
        map_index_num = new HashMap<>(); // Tracks assigned numbers at each index
        map_num_minIndex = new HashMap<>(); // Tracks indices of each number using a priority queue (min-heap)
    }

    /**
     * Assigns a number to the given index.
     * If the index already has the same number, no update is performed.
     */
    public void change(int index, int number) {
        // If the index is already assigned the same number, do nothing
        if (map_index_num.containsKey(index) && map_index_num.get(index) == number) return;

        // Update the mapping of index to the new number
        map_index_num.put(index, number);

        // Add this index to the priority queue for this number
        map_num_minIndex.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }

    /**
     * Finds the smallest index with the given number.
     * If the number doesn't exist, return -1.
     */
    public int find(int number) {
        // If there are no indices for this number, return -1
        if (!map_num_minIndex.containsKey(number)) return -1;

        PriorityQueue<Integer> pQueue = map_num_minIndex.get(number);

        // Remove any outdated indices (those that no longer map to the expected number)
        while (!pQueue.isEmpty() && map_index_num.get(pQueue.peek()) != number) {
            pQueue.poll();
        }

        // Return the smallest valid index or -1 if no valid index exists
        return pQueue.isEmpty() ? -1 : pQueue.peek();
    }
}

