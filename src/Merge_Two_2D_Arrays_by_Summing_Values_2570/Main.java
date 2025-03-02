package Merge_Two_2D_Arrays_by_Summing_Values_2570;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 3}, {3, 4}, {4, 2}};

        int[][] result = solution.mergeArrays(nums1, nums2);

        // Print output
        System.out.println("Merged Array: ");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
