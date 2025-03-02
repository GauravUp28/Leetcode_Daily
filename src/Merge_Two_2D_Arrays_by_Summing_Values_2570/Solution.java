/*
🔍 Intuition
We need to merge two sorted 2D arrays (nums1 and nums2) based on their first element (ID).
If an ID appears in both arrays, we sum their values. If an ID is only present in one array, we add it as is.

Since both nums1 and nums2 are already sorted, we can efficiently merge them using the two-pointer approach.

💡 Approach
Step 1. Use two pointers (i, j) to traverse nums1 and nums2 simultaneously.

Step 2. Compare nums1[i][0] and nums2[j][0] (IDs):
    - If equal, sum their values and move both pointers forward.
    - If nums1[i][0] < nums2[j][0], add nums1[i] and move i++.
    - Otherwise, add nums2[j] and move j++.

Step 3. Handle remaining elements:
    - If nums1 has extra elements, add them to the result.
    - If nums2 has extra elements, add them as well.

Step 4. Convert List<int[]> to int[][] array and return.

⏱️ Complexity
Time Complexity:
    - O(N + M) - Each element is processed once.

Space Complexity:
    - O(N + M) - Result list stores all elements.
 */
package Merge_Two_2D_Arrays_by_Summing_Values_2570;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        // Merge both arrays using two pointers
        while (i < nums1.length && j < nums2.length) {
            int nums1_id = nums1[i][0], nums2_id = nums2[j][0];
            int nums1_val = nums1[i][1], nums2_val = nums2[j][1];

            if (nums1_id == nums2_id) {
                // If IDs match, sum values
                result.add(new int[]{nums1_id, nums1_val + nums2_val});
                i++;
                j++;
            } else if (nums1_id < nums2_id) {
                // Add smaller ID from nums1
                result.add(nums1[i]);
                i++;
            } else {
                // Add smaller ID from nums2
                result.add(nums2[j]);
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < nums1.length) {
            result.add(nums1[i++]);
        }

        // Add remaining elements from nums2
        while (j < nums2.length) {
            result.add(nums2[j++]);
        }

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}

