/*
🔍 Intuition
The goal is to determine which asteroids survive after all possible collisions.
    - Positive asteroids (>0) move right, while negative asteroids (<0) move left.
    - Collisions occur when a right-moving asteroid meets a left-moving asteroid.

💡 Approach
Step 1. Use a Stack to keep track of asteroids that remain after collisions.

Step 2. Process each asteroid:
    - If the stack is not empty and a collision is possible (stack.peek() > 0 and asteroid < 0):
    - Compare sizes:
        * If the top of the stack is smaller, pop it (destroy it) and continue checking.
        * If both are equal, pop the stack and destroy the current asteroid.
        * If the current asteroid is smaller, it gets destroyed.
    - If no collision happens, push the asteroid to the stack.

Step 3. Return the remaining asteroids in the correct order.

⏱️ Complexity
Time Complexity:
    - O(N) (Each asteroid is pushed/popped once)

Space Complexity:
    - O(N) (In the worst case, all asteroids survive and are stored in the stack)

*/

package Asteroid_Collision_735;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // Stack to store surviving asteroids

        for (int asteroid : asteroids) {
            boolean alive = true; // Flag to check if the current asteroid survives

            // Collision check: Stack contains right-moving asteroids (positive)
            // and current asteroid is left-moving (negative)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    // Current asteroid is larger, destroy the top of the stack
                    stack.pop();
                    continue; // Continue checking for further collisions
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids are equal in size, destroy both
                    stack.pop();
                }
                alive = false; // Current asteroid is destroyed
                break; // Exit loop
            }

            // If the asteroid survived all collisions, push it onto the stack
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array (final result)
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            res[i] = stack.pop(); // Reverse order as stack is LIFO
        }

        return res;
    }
}

