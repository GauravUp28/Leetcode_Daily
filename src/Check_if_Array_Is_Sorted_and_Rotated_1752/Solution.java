/*
🔍 Intuition
A sorted & rotated array should have at most one "drop" (where nums[i] > nums[i+1]).
 If there’s more than one drop, the array is not sorted & rotated.

💡 Approach
Iterate through the array and count the number of drops (nums[i] > nums[(i+1) % len]).
If drop count > 1, return false; otherwise, return true.

⏱️ Complexity
Time Complexity:
O(N) (Single pass through the array)

Space Complexity:
O(1) (Uses only a few variables)
*/

package Check_if_Array_Is_Sorted_and_Rotated_1752;

public class Solution {
    public boolean check(int[] nums) {
        int dropCount = 0; // Keeps track of the number of times an element is greater than the next one
        int len = nums.length; // Store the length of the array for convenience

        // Iterate through the array to count the number of drops
        for (int i = 0; i < len; i++) {
            // Compare the current element with the next element (circular check using modulo)
            if (nums[i] > nums[(i + 1) % len]) {
                dropCount++; // Increase the drop count if a drop is detected
            }
        }

        // If there is more than one drop, the array is not sorted & rotated
        return dropCount <= 1;
    }
}
