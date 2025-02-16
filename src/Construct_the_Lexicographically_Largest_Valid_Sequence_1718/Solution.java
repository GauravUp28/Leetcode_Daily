/*
🔍 Intuition
We need to construct a distanced sequence of size 2 * n - 1, where:
    - The number 1 appears exactly once.
    - Any number i (2 ≤ i ≤ n) appears exactly twice, with i spaces between its occurrences.
    - The sequence should be lexicographically largest.
To achieve this, we use backtracking with a greedy approach (placing larger numbers first). This ensures that the solution is lexicographically maximal.

💡 Approach
Step 1. Initialize structures:
    - resultSequence[] → Holds the final sequence (size = 2 * n - 1).
    - isUsed[] → Tracks which numbers have been placed.

Step 2. Backtracking function (backtrack()):
    - Find the first empty position (index) in resultSequence.
    - Try placing numbers from n → 1:
        * If i == 1, place it once.
        * If i > 1, ensure there is a gap of i before placing it.
    - Recursively attempt to place the next number.
    - If a placement fails, backtrack (reset values).

Step 3. Return the result once a valid sequence is found.

⏱️ Complexity
Time Complexity:
    - O(N!) (Worst case due to backtracking)
Space Complexity:
    - O(N) (Recursive depth + auxiliary arrays)

 */

package Construct_the_Lexicographically_Largest_Valid_Sequence_1718;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] resultSequence = new int[2 * n - 1]; // Result array
        boolean[] isUsed = new boolean[n + 1]; // Track used numbers

        backtrack(resultSequence, isUsed, n, 0);

        return resultSequence;
    }

    boolean backtrack(int[] resultSequence, boolean[] isUsed, int n, int index) {
        // Find the first empty position
        while (index < resultSequence.length && resultSequence[index] != 0) {
            index++;
        }

        // If the array is completely filled, return true
        if (index == resultSequence.length) {
            return true;
        }

        // Try placing numbers from n to 1 (greedy approach for lexicographically largest)
        for (int i = n; i >= 1; i--) {
            if (isUsed[i]) continue; // Skip if already placed

            if (i == 1) { // Place 1 at this index (since it appears once)
                resultSequence[index] = 1;
                isUsed[1] = true;

                // Recur for next position
                if (backtrack(resultSequence, isUsed, n, index + 1)) return true;

                // Undo placement (backtracking)
                resultSequence[index] = 0;
                isUsed[1] = false;
            } else {
                // Check if we can place 'i' at index and index + i
                if (index + i < resultSequence.length && resultSequence[index + i] == 0) {
                    resultSequence[index] = i;
                    resultSequence[index + i] = i;
                    isUsed[i] = true;

                    // Recur for next position
                    if (backtrack(resultSequence, isUsed, n, index + 1)) return true;

                    // Undo placement (backtracking)
                    resultSequence[index] = 0;
                    resultSequence[index + i] = 0;
                    isUsed[i] = false;
                }
            }
        }

        return false; // No valid placement found, backtrack
    }
}
