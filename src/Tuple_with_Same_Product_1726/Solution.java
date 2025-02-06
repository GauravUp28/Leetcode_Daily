/*
🔍 Intuition
This problem asks us to count tuples (a, b, c, d) where: a×b=c×d
Instead of brute-force checking all possible 4-tuples (O(N⁴)), we use a HashMap to store and retrieve previous product pairs efficiently.

💡 Approach
Step 1. Use a HashMap (map) to store the product of every pair (nums[i], nums[j]).
    - Key: Product (nums[i] * nums[j])
    - Value: Count of pairs that formed this product

Step 2. Count valid tuples:
    - If a product appears multiple times in the map, it means multiple pairs share the same product.
    - When we find a product already in the map, for each occurrence we can form 8 valid tuples (since order matters).

Step 3. Update the map:
    - Increment the count of the current product in the map.

🤔 Why Multiply by 8?
Each new pair (nums[i], nums[j]) can form 8 different (a, b, c, d) tuples with every existing pair that has the same product:
(a, b, c, d), (a, b, d, c), (b, a, c, d), (b, a, d, c), ....

Since order matters, we count 8 unique permutations per new pair.

⏱️ Complexity
Time Complexity:
    - O(N²) (Nested loops iterate over all pairs)

Space Complexity:
    - O(N²) (HashMap stores at most O(N²) products in the worst case)

*/

package Tuple_with_Same_Product_1726;

import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores product -> count of pairs
        int result = 0; // Stores the final count of valid tuples

        // Iterate through all pairs (i, j) in nums
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j]; // Compute the product of the pair

                // If this product was seen before, it means we found valid tuples
                // For each previous occurrence, we can form 8 new tuples
                result += 8 * map.getOrDefault(product, 0);

                // Increment the count of this product in the map
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        return result; // Return the total count of valid tuples
    }
}
