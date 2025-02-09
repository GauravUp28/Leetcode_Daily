/*
🔍 Intuition
We need to count the number of bad pairs in an array where:
(i,j) is a bad pair if i − j != nums[i] − nums[j]

This can be rewritten as:
i − nums[i] != j − nums[j]

Thus, for a pair (i, j) to be good, the value of i - nums[i] must be equal to j - nums[j].
Instead of checking all pairs in O(N²), we use a HashMap to efficiently track counts.

💡 Approach
Step 1. Use a HashMap (map) to track occurrences of i - nums[i].

Step 2. Iterate through the array while counting bad pairs:
    - Compute diff = i - nums[i]
    - Count how many times this diff has appeared before (goodPairCount).
    - The total number of pairs up to i is i, and the bad pairs contribution is i - goodPairCount.
    - Update map to record this diff.

Step 3. Sum up bad pairs and return the result.

⏱️ Complexity
Time complexity:
    - O(n)

Space complexity:
    - O(n)

 */

package Count_Number_of_Bad_Pairs_2364;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        long badPairs = 0; // Stores the final count of bad pairs
        Map<Integer, Integer> map = new HashMap<>(); // Tracks occurrences of (i - nums[i])

        for (int i = 0; i < nums.length; i++) {
            int diff = i - nums[i]; // Compute key difference

            int goodPairCount = map.getOrDefault(diff, 0); // Get count of previous good pairs

            badPairs += i - goodPairCount; // Bad pairs = all pairs up to i - good pairs

            map.put(diff, goodPairCount + 1); // Update map with new count
        }

        return badPairs;
    }
}
