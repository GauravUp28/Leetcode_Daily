/*
🔍 Intuition
The problem requires us to remove all occurrences of a given substring (part) from a string (s).
Instead of using built-in string replacement methods, we simulate the process efficiently using a character array (stack approach).

We process characters one by one and store them in a "result array" (acting as a stack).
Whenever we reach the last character of part, we check if the last part.length() characters in result match part.
If they do, we remove them by adjusting the array size.

💡 Approach
Step 1. Convert s and part into character arrays:
    - This allows efficient indexing instead of repeated substring operations.

Step 2. Use a result array as a dynamic stack:
    - Store characters as we iterate through s.
    - Keep track of size, which represents the valid portion of result.

Step 3. Check for substring match:
    - If the last character of part matches result[size - 1] and size >= part.length(), check if the last part.length() characters match part.
    - If they match, "remove" part by reducing size.

Step 4. Convert result array to a final string.

⏱️ Complexity
Time complexity:
    - O(n) - Processing s

Space complexity:
    - O(n) - storing modified string

 */

package Remove_All_Occurrences_of_a_Substring_1910;

class Solution {
    public String removeOccurrences(String s, String part) {
        char[] input = s.toCharArray();   // Convert s to char array
        char[] target = part.toCharArray(); // Convert part to char array
        char[] result = new char[input.length]; // Acts as a stack for modified string
        int size = 0, tLen = target.length;
        char tEndChar = target[tLen - 1]; // Last character of part

        // Process each character in input
        for (char curr : input) {
            result[size++] = curr; // Add current character to result

            // If last char matches, and we have enough chars to check for "part"
            if (curr == tEndChar && size >= tLen) {
                int i = size - 1, j = tLen - 1;

                // Check if last tLen characters match the target (part)
                while (j >= 0 && result[i] == target[j]) {
                    i--;
                    j--;
                }

                // If the entire substring matched, remove it by adjusting size
                if (j < 0) {
                    size = i + 1;
                }
            }
        }

        return new String(result, 0, size); // Return only the valid part of result
    }
}

