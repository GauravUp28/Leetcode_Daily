/*
🔍 Intuition
The Punishment Number of n is defined as the sum of squares of numbers from 1 to n where the square can be split into parts that sum up to the original number.

For example:
36 is valid because 36 = 6 (parts: 36)
81 is valid because 81 = 8 + 1 (parts: 8, 1)
2025 is valid because 2025 = 20 + 25 (parts: 20, 25)
Thus, the problem requires checking if a square can be partitioned into parts summing to i, and if so, adding it to the total punishment number.

💡 Approach
Step 1. Iterate over numbers from 1 to n:
    - Compute square = i * i.
    - Check if the square can be split into parts summing to i using recursion (canPartition()).

Step 2. Partitioning logic (canPartition()):
    - Base cases:
        * If num == target, return true.
        * If num < target or target < 0, return false.
    - Recursive approach:
        * Try different partitions by taking 1-digit, 2-digit, or 3-digit suffixes (num % 10, num % 100, num % 1000).
        * Reduce num accordingly (num / 10, num / 100, num / 1000).
        * If any partition results in a valid sum, return true.

⏱️ Complexity
Time Complexity:
    - O(N log N) - Iterating N times, each with a recursive check of O(log N)

Space Complexity:
    - O(log N) - Recursive depth due to partitioning.
 */

package Find_the_Punishment_Number_of_an_Integer_2698;

class Solution {
    public int punishmentNumber(int n) {
        int pNum = 0; // Stores the punishment number sum

        for (int i = 1; i <= n; i++) {
            int square = i * i; // Compute square of i

            // Check if square can be partitioned to sum to i
            if (canPartition(square, i)) {
                pNum += square; // Add to punishment number sum
            }
        }

        return pNum;
    }

    // Recursively checks if num can be partitioned into parts summing to target
    public boolean canPartition(int num, int target) {
        if (num < target || target < 0) {
            return false; // If num is too small or target is negative, return false
        }

        if (num == target) {
            return true; // If num exactly matches target, return true
        }

        // Try different partitions: last 1-digit, last 2-digits, last 3-digits
        return (
                canPartition(num / 10, target - (num % 10)) ||
                        canPartition(num / 100, target - (num % 100)) ||
                        canPartition(num / 1000, target - (num % 1000))
        );
    }
}
