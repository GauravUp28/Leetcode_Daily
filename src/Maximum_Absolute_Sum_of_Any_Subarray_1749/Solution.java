/*
🔍 Intuition
We need to find the maximum absolute sum of any subarray in nums.
This means we need to maximize:
    - The largest subarray sum (maxSum)
    - The smallest (most negative) subarray sum (minSum)

Instead of using Kadane’s Algorithm separately for max and min subarrays, we track both in a single pass.

💡 Approach
Step 1. Use a running sum (sum) while iterating through nums:
    - Track the maximum sum encountered (maxSum).
    - Track the minimum sum encountered (minSum).

Step 2. The maximum absolute sum is given by:
    - Math.abs(maxSum - minSum)
    - This accounts for both:
        * Positive subarrays (maxSum).
        * Negative subarrays (minSum) (which effectively flips the sign when subtracted).

⏱️ Complexity
Time Complexity:
    - O(N) → Single pass through the array.
Space Complexity:
    - O(1) : No extra space used.

 */
package Maximum_Absolute_Sum_of_Any_Subarray_1749;

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, minSum = 0, maxSum = 0;

        for (int num : nums) {
            sum += num;  // Running sum

            // Track max and min subarray sums
            if (sum > maxSum) maxSum = sum;
            if (sum < minSum) minSum = sum;
        }

        return Math.abs(maxSum - minSum); // Absolute difference
    }
}

