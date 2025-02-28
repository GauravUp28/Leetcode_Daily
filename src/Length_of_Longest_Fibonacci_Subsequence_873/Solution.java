/*
🔍 Intuition
The problem requires finding the length of the longest Fibonacci-like subsequence in an array.
A subsequence follows the Fibonacci rule: A[i]+A[j]=A[k]

We use Dynamic Programming (DP) + Two Pointers to efficiently track Fibonacci-like subsequences.

💡 Approach
Step 1.Use a 2D DP table dp[end][curr]:
    - Represents length of Fibonacci-like sequence ending at end and curr.
    - If arr[start] + arr[end] == arr[curr], update dp[end][curr] = dp[start][end] + 1.

Step 2. Iterate curr from 2 to n-1:
    - Use two pointers (start at 0 and end at curr-1).
    - If arr[start] + arr[end] > arr[curr], decrement end.
    - If arr[start] + arr[end] < arr[curr], increment start.
    - Otherwise, update dp[end][curr], move both pointers, and track maxLen.

Step 3. Return maxLen + 2 (since the base sequence starts with 2 elements).

⏱️ Complexity
Time Complexity:
    - O(N^2), where N is the length of arr

Space Complexity:
    - O(N^2), used for DP storage.

 */
package Length_of_Longest_Fibonacci_Subsequence_873;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n]; // DP table to track lengths of Fibonacci-like subsequences
        int maxLen = 0;

        // Iterate through possible last elements of Fibonacci subsequence
        for (int curr = 2; curr < n; curr++) {
            int start = 0, end = curr - 1;

            // Use two pointers to find (start, end) such that arr[start] + arr[end] = arr[curr]
            while (start < end) {
                int pairSum = arr[start] + arr[end];

                if (pairSum > arr[curr]) {
                    end--; // Decrease sum
                } else if (pairSum < arr[curr]) {
                    start++; // Increase sum
                } else {
                    // Found a Fibonacci-like sequence
                    dp[end][curr] = dp[start][end] + 1;
                    maxLen = Math.max(dp[end][curr], maxLen);

                    // Move both pointers inward to check for other sequences
                    end--;
                    start++;
                }
            }
        }
        return maxLen == 0 ? 0 : maxLen + 2; // Add 2 to include the first two numbers in the sequence
    }
}

