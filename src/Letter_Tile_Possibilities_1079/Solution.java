/*
🔍 Intuition
We need to determine the number of unique sequences that can be formed using the given tile letters.
Since any permutation of any subset of tiles counts as a valid sequence, we use backtracking with a frequency array to generate all possible sequences.

Instead of generating permutations directly (which would involve sorting and duplicate handling), we:
    - Use a frequency array (charCount[]) to keep track of available letters.
    - Recursively try placing each letter, reducing its frequency, and counting new sequences.
    - Backtrack by restoring the frequency, ensuring all possibilities are explored.

💡 Approach
Step 1. Count letter frequencies in charCount[].

Step 2. Recursive function (findSequences()):
    - Try using each available letter.
    - Reduce its count and recursively generate further sequences.
    - Restore the letter count (backtracking).
    - Accumulate the total count of unique sequences.

⏱️ Complexity
Time Complexity:
    - O(n!) - Factorial growth due to recursive calls

Space Complexity:
    - O(n) - Recursive depth in worst case.

 */

package Letter_Tile_Possibilities_1079;

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] charCount = new int[26]; // Array to store frequency of each letter

        // Populate the frequency array
        for (char c : tiles.toCharArray()) {
            charCount[c - 'A']++;
        }

        return findSequences(charCount);
    }

    int findSequences(int[] charCount) {
        int totalCount = 0;

        // Try using each available letter
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) continue; // Skip letters that are unavailable

            // Use this letter and reduce its count
            charCount[i]--;
            totalCount++;

            // Recursively explore sequences with the reduced set
            totalCount += findSequences(charCount);

            // Backtrack: Restore the letter count
            charCount[i]++;
        }

        return totalCount;
    }
}

