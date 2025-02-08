/*
🔍 Intuition
The problem requires decoding an encoded string where:
    - Numbers indicate how many times the enclosed substring should be repeated.
    - Brackets [ ] define groups of characters that need repetition.

A stack is a natural choice because:
    - It allows us to process nested brackets efficiently.
    - It helps reconstruct the string in a Last-In-First-Out (LIFO) manner.

💡 Approach
Step 1. Use a Stack to process characters one by one.

Step 2. When encountering ], start decoding:
    - Extract the substring inside the brackets.
    - Extract the number before the substring.
    - Expand the substring based on the extracted number.
    - Push the expanded substring back into the stack.

Step 3. After processing all characters, construct the final decoded string from the stack.

⏱️ Complexity
Time Complexity:
    - O(N * M) Iterating through s -> O(N) and Expanding string -> O(K * M) (M is the number of times repeated)

Space Complexity:
    - O(N) (Stack storage)

 */

package Decode_String_394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        // Process each character
        for (char c : s.toCharArray()) {
            if (c != ']') {
                st.push(c); // Push all characters except ']'
            }
            else {
                // Step 1: Extract the encoded substring
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && Character.isLetter(st.peek())) {
                    sb.append(st.pop());
                }
                String sub = sb.reverse().toString(); // Reverse because we pop in reverse order

                st.pop(); // Remove the '[' from the stack

                // Step 2: Extract the number before '['
                sb = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    sb.append(st.pop());
                }
                int count = Integer.parseInt(sb.reverse().toString()); // Convert number string to integer

                // Step 3: Expand and push the repeated substring back into the stack
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        st.push(ch);
                    }
                    count--;
                }
            }
        }

        // Construct the final decoded string
        StringBuilder ret = new StringBuilder();
        while (!st.isEmpty()) {
            ret.append(st.pop());
        }

        return ret.reverse().toString(); // Reverse because we built the string in reverse order
    }
}

