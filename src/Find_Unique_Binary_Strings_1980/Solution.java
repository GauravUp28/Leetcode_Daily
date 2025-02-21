/*
🔍 Intuition
The problem requires finding a binary string of length n that is not present in the given array nums, where each string has length n.
Instead of generating all 2ⁿ possible binary strings and checking which one is missing (O(2ⁿ) complexity), we use a simple and efficient approach based on Cantor's Diagonalization.

⭐ Cantor's Diagonalization Approach
We construct a new binary string by flipping the diagonal elements of nums.
Specifically, for each i, take nums[i][i] and flip it (0 → 1, 1 → 0).
This guarantees that the constructed string differs from every nums[i] in at least one position, making it unique.

💡 Approach
Step 1. Initialize an empty StringBuilder ans.

Step 2. Iterate through each index i from 0 to n-1:
    - If nums[i].charAt(i) == '0', append '1' to ans.
    - Otherwise, append '0' to ans.

Step 3. Convert ans to a string and return it.

This ensures that the generated binary string isn't present in nums.

⏱️ Complexity
Time Complexity:
    - O(N) : We iterated throught the array just once.
Space Complexity:
    - O(1) : No extra space used.

 */

package Find_Unique_Binary_Strings_1980;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();

        // Flip the diagonal elements of the input strings
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0'); // Flip bit
        }

        return ans.toString(); // Convert result to a string
    }
}
