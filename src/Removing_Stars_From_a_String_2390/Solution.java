/*
🔍 Intuition
The problem requires us to process a string and handle stars ('*') by removing the closest non-star character to the left of each star.
A stack is a natural choice for this problem because:
    - It allows us to keep track of characters in the order they appear.
    - When a star is encountered, we can easily remove the most recently added character (which is the closest to the left).

💡 Approach
Step 1: Initialize a Stack
    - Use a stack to store characters as we process the string.

Step 2: Process the String
    - Iterate through each character in the string:
    - If the character is alphabetic, push it onto the stack.
    - If the character is a star, pop the top element from the stack (removing the closest non-star character to the left).

Step 3: Build the Result
    - After processing the string, the stack will contain the characters that are not removed by stars.
    - Use a StringBuilder to construct the final string by popping elements from the stack.
    - Reverse the StringBuilder to restore the original order of characters.

Step 4: Return the Result
    - Return the final string.

⏱️ Complexity
Time Complexity:
    - O(n): We process each character in the string once, and stack operations (push/pop) are O(1).

Space Complexity:
    - O(n): In the worst case, the stack can store all characters in the string (if there are no stars).
*/

package Removing_Stars_From_a_String_2390;

import java.util.Stack;
import static java.lang.Character.isAlphabetic;

class Solution {
    public String removeStars(String s) {
        // Initialize a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (isAlphabetic(c)) {
                // If the character is alphabetic, push it onto the stack
                stack.push(c);
            } else {
                // If the character is a star, pop the top element from the stack
                stack.pop();
            }
        }

        // Build the result using a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        // Reverse the StringBuilder to restore the original order and return the result
        return stringBuilder.reverse().toString();
    }
}
