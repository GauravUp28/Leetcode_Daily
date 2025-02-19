/*
🔍 Intuition
The problem requires generating the k-th lexicographically smallest "happy string" of length n, where:
    - Each character is 'a', 'b', or 'c'.
    - No two adjacent characters are the same.
Instead of generating all possible happy strings and sorting them (which is inefficient), we use a recursive depth-first search (DFS) with pruning to construct only the required string.

💡 Approach
Step 1. Recursive DFS to construct the string:
    - Append characters 'a', 'b', 'c' one by one.
    - Ensure adjacent characters are different.
    - Stop when n characters are added.

Step 2. Pruning using combinatorics:
    - If count = 2^(length - preString.length() - 1) happy strings exist for a given choice:
        * If k <= count, recurse into that branch.
        * Otherwise, skip (reduce k by count and try the next character).
    - This avoids generating all strings and jumps directly to the k-th string.

⏱️ Complexity
Time Complexity:
    - O(N) (We only explore one path instead of brute-force O(3ⁿ))
Space Complexity:
    - O(N) (Due to recursion depth)

*/

package The_kth_Lexicographical_String_of_All_Happy_Strings_of_Length_n_1415;

class Solution {
    int length;

    public String getHappyString(int n, int k) {
        length = n;
        return dfs(new StringBuilder(), n, k);
    }

    String dfs(StringBuilder preString, int n, int k) {
        // Base case: If we formed a happy string of length n, return it
        if (n == 0) {
            return preString.toString();
        }

        // Try adding 'a', 'b', or 'c'
        for (char c = 'a'; c <= 'c'; c++) {
            // Ensure adjacent characters are different
            if (!preString.isEmpty() && c == preString.charAt(preString.length() - 1)) {
                continue;
            }

            // Calculate remaining possible happy strings if we choose 'c' at this step
            int count = (int) Math.pow(2, length - preString.length() - 1);

            if (count >= k) {
                return dfs(preString.append(c), n - 1, k);
            } else {
                k -= count; // Skip this branch and adjust k
            }
        }

        return ""; // If k is too large, return empty string
    }
}

