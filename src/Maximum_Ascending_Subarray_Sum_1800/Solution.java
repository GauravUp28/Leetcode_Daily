/*
🔍 Intuition
The problem requires us to find the maximum sum of a strictly ascending subsequence in the array. To solve this:
    - We iterate through the array while keeping track of the current ascending subsequence sum.
    - If the current element breaks the ascending order, we compare the current sum with the maximum sum found so far and reset the current sum.
    - Finally, we return the maximum sum found.
This approach ensures that we efficiently compute the maximum sum of any ascending subsequence in a single pass through the array.

💡 Approach
Step 1: Initialize Variables
    - total: Keeps track of the maximum sum found so far.
    - sum: Keeps track of the sum of the current ascending subsequence.

Step 2: Iterate Through the Array
    - Start with sum = nums[0] (the first element).
    - For each element in the array (starting from the second element):
        * If the current element is greater than the previous element, it continues the ascending subsequence. Add it to sum.
        * If the current element is less than or equal to the previous element, the ascending subsequence breaks.
        * Update total with the maximum of total and sum, then reset sum to the current element.

Step 3: Handle the Last Subsequence
    - After the loop ends, compare total with the last sum to ensure the final ascending subsequence is considered.

Step 4: Return the Result
    - The final total is the maximum ascending sum.

⏱️ Complexity
Time Complexity:
    - O(n): We iterate through the array once, performing constant-time operations for each element.

Space Complexity:
    - O(1): We use only a few variables (total, sum, and loop index), so the space complexity is constant.

*/

package Maximum_Ascending_Subarray_Sum_1800;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int total = 0; // Stores the maximum ascending sum found so far
        int sum = nums[0]; // Stores the sum of the current ascending subsequence

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element breaks the ascending order
            if (nums[i] <= nums[i - 1]) {
                total = Math.max(total, sum); // Update total with the maximum sum
                sum = 0; // Reset sum for the new subsequence
            }
            sum += nums[i]; // Add the current element to the current subsequence sum
        }

        // Return the maximum of total and the last subsequence sum
        return Math.max(total, sum);
    }
}