/*
🔍 Intuition
The problem requires compressing an array of characters using Run-Length Encoding (RLE).
Instead of storing consecutive duplicate characters separately, we replace them with a single occurrence of the character followed by its count (if more than one).
This reduces the space used for redundant characters while maintaining the original order.

💡 Approach
1. Use Two Pointers:
    a. i: Traverses the input array.
    b. res: Keeps track of where to write in the modified chars array.

2. Count Consecutive Duplicates:
    a. Start at index i, count the number of repeated occurrences (len).
    b. Move i forward by len.

3. Write the Compressed Output:
    a. Always store the character chars[i] at chars[res].
    b. If len > 1, convert the count (len) into characters and store each digit in chars[].

4. Return the final compressed length (res).

⏱️ Complexity
Time Complexity:
O(N) (Single pass through the array)

Space Complexity:
O(1) (In-place modification, no extra space used)

*/

package String_Compression_443;

public class Solution {
    public int compress(char[] chars) {
        int i = 0, res = 0; // 'i' is the pointer for traversal, 'res' is the index for writing compressed data

        while (i < chars.length) { // Iterate through the entire array
            int len = 1; // Initialize length counter for repeating characters

            // Count the number of consecutive repeating characters
            while (i + len < chars.length && chars[i + len] == chars[i]) {
                len++;
            }

            // Store the character at the current 'res' position and increment 'res'
            chars[res++] = chars[i];

            // If the character repeats more than once, store the count as well
            if (len > 1) {
                for (char c : Integer.toString(len).toCharArray()) { // Convert length to char array
                    chars[res++] = c; // Store each digit of the count
                }
            }

            // Move 'i' forward by the length of repeated characters
            i += len;
        }

        return res; // Return the length of the compressed array
    }
}

