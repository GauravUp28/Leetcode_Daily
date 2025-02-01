/*
🔍 Intuition
The problem requires us to determine whether an array is "special," meaning no two consecutive elements have the same parity (odd or even).
 The first thought is to iterate through the array and check if any two adjacent numbers share the same parity.

💡 Approach
Iterate through the array from index 0 to n - 2.
Check if the current element and the next element have the same parity using the modulus operator (%).
If we find two consecutive elements with the same parity, return false.
If we complete the loop without finding such a pair, return true.

⏱️ Complexity
Time Complexity:
O(n) since we traverse the array once.

Space Complexity:
O(1) since we only use a few integer variables.

 */

package Special_Array_I_3151;

public class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Check if two consecutive numbers have the same parity
        for(int i =0; i<nums.length - 1; i++) {
            if(nums[i] % 2 == nums[i+1] % 2) {
                return false; // Found two adjacent numbers with the same parity
            }
        }
        return true; // The array satisfies the condition
    }
}
