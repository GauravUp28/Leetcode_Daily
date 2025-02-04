/*
🔍 Intuition
The problem requires us to find days when:
    - The security count is non-increasing for time days before the current day.
    - The security count is non-decreasing for time days after the current day.

For the input security = [5, 3, 3, 3, 5, 6, 2] and time = 2, we need to identify days when:
    - The security count is non-increasing for 2 days before the current day.
    - The security count is non-decreasing for 2 days after the current day.

💡 Approach
Step 1: Compute nonIncrease Array
    - This array tracks the number of consecutive days before the current day when the security count is non-increasing.
    - Iterate through the security array from left to right.

Step 2: Compute nonDecrease Array
    - This array tracks the number of consecutive days after the current day when the security count is non-decreasing.
    - Iterate through the security array from right to left.

Step 3: Find Good Days
    - For each day, check if:
        * nonIncrease[i] >= time (non-increasing for time days before).
        * nonDecrease[i] >= time (non-decreasing for time days after).
    - If both conditions are satisfied, add the day to the result list.

⏱️ Complexity
Time Complexity:
    - O(n): We iterate through the security array three times (once for nonIncrease, once for nonDecrease, and once to find good days).

Space Complexity:
    - O(n): We use two auxiliary arrays (nonIncrease and nonDecrease) of size n.
 */

package Find_Good_Days_to_Rob_the_Bank_2100;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] nonIncrease = new int[security.length]; // Stores count of non-increasing days before index i

        // Compute non-increasing streak for each index
        for (int i = 1; i < security.length - time; i++) {
            if (security[i] > security[i - 1]) {
                nonIncrease[i] = 0; // Reset streak if security increases
            } else {
                nonIncrease[i] = nonIncrease[i - 1] + 1; // Increment streak if security stays same or decreases
            }
        }

        int[] nonDecrease = new int[security.length]; // Stores count of non-decreasing days after index i

        // Compute non-decreasing streak for each index
        for (int i = security.length - 2; i >= time; i--) {
            if (security[i] > security[i + 1]) {
                nonDecrease[i] = 0; // Reset streak if security decreases
            } else {
                nonDecrease[i] = nonDecrease[i + 1] + 1; // Increment streak if security stays same or increases
            }
        }

        ArrayList<Integer> result = new ArrayList<>(); // Stores valid days to rob the bank

        // Check for valid "good days" based on computed nonIncrease and nonDecrease values
        for (int i = time; i < security.length - time; i++) {
            if (nonIncrease[i] >= time && nonDecrease[i] >= time) {
                result.add(i); // Add valid day to the result list
            }
        }

        return result; // Return list of good days
    }
}

