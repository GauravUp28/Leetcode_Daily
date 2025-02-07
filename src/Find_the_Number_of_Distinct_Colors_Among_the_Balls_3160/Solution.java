/*
🔍 Intuition
This function processes a list of queries, where each query assigns a color to a ball.
After each assignment, it returns the number of unique colors in use.

💡 Approach
Step 1. Use a HashMap ballMap to track which ball has which color.

Step 2. Use another HashMap colorMap to track how many times each color appears.

Step3. Processing each query (ball, color):
    - If the ball already has a color:
        * Decrease the count of the old color in colorMap.
        * If the old color count reaches 0, remove it.
    - Assign the new color to the ball.
    - Increase the count of the new color in colorMap.
    - Store the number of unique colors in result[i]..

⏱️ Complexity
Time Complexity:
    - O(N) (Each query is processed in constant time)

Space Complexity:
    - O(N) (For storing ball-to-color and color frequency mappings)

*/
package Find_the_Number_of_Distinct_Colors_Among_the_Balls_3160;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n  = queries.length; // Number of queries
        int[] result = new int[n]; // Stores the number of unique colors after each query

        Map<Integer, Integer> colorMap = new HashMap<>(); // Tracks color frequencies
        Map<Integer, Integer> ballMap = new HashMap<>();  // Tracks the color of each ball

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0], color = queries[i][1]; // Extract ball number and new color

            // If the ball was previously assigned a color, update the color count
            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball); // Get the previous color of the ball

                colorMap.put(prevColor, colorMap.get(prevColor) - 1); // Reduce count of previous color

                // If the count of previous color reaches 0, remove it from the map
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }

            // Assign the new color to the ball
            ballMap.put(ball, color);

            // Increment count of the new color
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            // Store the current number of unique colors
            result[i] = colorMap.size();
        }

        return result;
    }
}

