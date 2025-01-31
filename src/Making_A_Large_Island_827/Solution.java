/*
This algorithm finds the largest possible island in a grid where:
- 1 represents land.
- 0 represents water.
- An island is a group of adjacent land cells (1).

The approach involves two main steps:

Step 1: Identify and Color Islands
- We traverse the grid using DFS (Depth-First Search).
- Each island (connected land cells) is assigned a unique color (starting from 2).
- A HashMap stores the size of each island, mapped to its color.

Step 2: Evaluate Potential Expansion
- We iterate over each water cell (0) and consider changing it to land (1).
- By checking its neighboring islands (using 4-directional movement), we calculate the maximum possible island size.
- The final result is the maximum island size found.


Time Complexity (TC) Analysis
Let n be the number of rows and m be the number of columns in the grid.
TC = O(n×m)+O(n×m)= O(n×m)
Since both passes are linear, the overall time complexity is O(n × m).

Space Complexity (SC) Analysis
SC = O(n×m)
This accounts for DFS recursion depth and HashMap storage

 */

package Making_A_Large_Island_827;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // DFS function to explore an island and assign a unique color
    public int dfs(int i, int j, int[][] grid, int row, int col, int color) {
        // Base case: Check for out-of-bounds or water (0) or already visited (color)
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0 || grid[i][j] == color) {
            return 0;
        }

        // Mark the cell with a unique color
        grid[i][j] = color;
        int count = 1; // Count the current cell

        // Explore all 4 directions (up, down, left, right)
        count += dfs(i + 1, j, grid, row, col, color);
        count += dfs(i - 1, j, grid, row, col, color);
        count += dfs(i, j + 1, grid, row, col, color);
        count += dfs(i, j - 1, grid, row, col, color);

        return count; // Return the total size of the island
    }

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        HashMap<Integer, Integer> map = new HashMap<>(); // Stores size of each island by its color
        int color = 2; // Start coloring from 2 (1 is used for land, 0 for water)

        // Step 1: Identify and color each island uniquely using DFS
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { // If land is found, start DFS
                    int count = dfs(i, j, grid, row, col, color);
                    map.put(color, count); // Store island size with its color
                    color++; // Move to the next unique color
                }
            }
        }

        int result = 0;

        // Step 2: Try converting each water cell (0) into land (1) and calculate the new island size
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) { // Consider converting this water cell into land
                    HashSet<Integer> set = new HashSet<>(); // Store unique neighboring island colors

                    // Check all 4 directions and collect unique neighboring island colors
                    if (i - 1 >= 0 && grid[i - 1][j] != 0) set.add(grid[i - 1][j]);
                    if (j - 1 >= 0 && grid[i][j - 1] != 0) set.add(grid[i][j - 1]);
                    if (i + 1 < row && grid[i + 1][j] != 0) set.add(grid[i + 1][j]);
                    if (j + 1 < col && grid[i][j + 1] != 0) set.add(grid[i][j + 1]);

                    int sum = 1; // Start with 1 (the converted cell itself)

                    // Sum up the sizes of the unique neighboring islands
                    for (int colorValue : set) {
                        sum += map.get(colorValue);
                    }

                    // Update the maximum possible island size
                    result = Math.max(result, sum);
                }
            }
        }

        // If no water cells were found, return the full grid size (all land)
        return result == 0 ? (row * col) : result;
    }
}