/*
🔍 Intuition
The problem requires us to find the number of pairs where a row in the grid is identical to a column.
To solve this efficiently, we can:
    * Store the frequency of each row in a hash map for quick lookup.
    * Iterate through each column, convert it into a string, and check if it matches any row in the hash map.
    * Count the matches to determine the total number of equal row-column pairs.

💡 Approach
Step 1: Store Row Frequencies
    - Convert each row of the grid into a string representation (e.g., Arrays.toString(row)).
    - Use a hash map (rowCount) to store the frequency of each row string.

Step 2: Iterate Through Columns
    - For each column, extract the values and store them in an array.
    - Convert the column array into a string representation.

Step 3: Count Matching Pairs
    - Check if the column string exists in the rowCount hash map.
    - If it exists, add the frequency of that row string to the count.

Step 4: Return the Result
    - The final count represents the total number of equal row-column pairs.

⏱️ Complexity
Time Complexity:
    - O(n²): We iterate through each row and each column once. Converting rows and columns to strings takes O(n) time, but since we do this for all n rows and n columns, the total time complexity is O(n²).

Space Complexity:
    - O(n²): The rowCount hash map stores up to n rows, and each row string can take up to O(n) space. Therefore, the total space complexity is O(n²).

 */

package Equal_Row_and_Column_Pairs_2352;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0; // Initialize the count of equal row-column pairs
        int n = grid.length; // Get the size of the grid (n x n)

        // Create a HashMap to store the frequency of each row as a string
        Map<String, Integer> rowCount = new HashMap<>();

        // Iterate over each row in the grid
        for(int[] row : grid) {
            // Convert the row array to a string representation
            String rowString = Arrays.toString(row);

            // Update the frequency of this row string in the HashMap
            rowCount.put(rowString, rowCount.getOrDefault(rowString, 0) + 1);
        }

        // Iterate over each column in the grid
        for(int c = 0; c < n; c++) {
            // Create an array to store the current column
            int[] colArr = new int[n];

            // Populate the column array by iterating over each row
            for(int r = 0; r < n; r++) {
                colArr[r] = grid[r][c];
            }

            // Convert the column array to a string representation
            String colString = Arrays.toString(colArr);

            // If this column string exists in the rowCount HashMap, add its frequency to the count
            count += rowCount.getOrDefault(colString, 0);
        }

        // Return the total count of equal row-column pairs
        return count;
    }
}