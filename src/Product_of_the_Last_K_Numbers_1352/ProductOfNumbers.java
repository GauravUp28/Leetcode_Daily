/*
🔍 Intuition
The goal is to efficiently compute the product of the last k numbers that have been added.
Instead of recomputing the product each time (which would be O(k)), we can store prefix products so that we can retrieve the result in O(1).

    - Key Observations
    - Prefix Product Property:
        * If we maintain a running product of all numbers, we can quickly compute:
            - Product of last 𝑘 numbers = total product / product before last 𝑘 numbers
        * This avoids recomputing the product from scratch every time.

    - Handling Zeros:
        * If 0 is added, all previous products become invalid because multiplying by zero erases the effect of earlier numbers.
        * Solution: Reset the prefix product list whenever 0 appears.

💡 Approach
Step 1. Use a List (list) to Store Prefix Products:
    - list[i] stores the product of all numbers up to index i.
    - Initialize with 1 to make division operations easier.

Step 2. add(num) Method:
    - If num > 0, multiply the last stored product by num and add it to list.
    - If num == 0, reset the list (since any product involving 0 will be 0).

Step 3. getProduct(k) Method:
    - Compute the product of the last k numbers using division:
        * last product in list / product at  𝑛 − 1 − 𝑘
    - If k > list.size() - 1, return 0 (since a 0 was encountered earlier, making earlier products invalid).

⏱️ Complexity
Time complexity:
    - O(1) time for add, O(1) getProduct method.

Space complexity:
    - O(n) space - we can have products of all elements in a list
 */
package Product_of_the_Last_K_Numbers_1352;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
        List<Integer> list; // Stores prefix product
        int prev; // Stores the latest product

        public ProductOfNumbers() {
            list = new ArrayList<>();
            list.add(1); // Initialize with 1 to avoid division issues
            prev = 1;
        }

        public void add(int num) {
            if (num > 0) {
                prev *= num; // Multiply the last product by num
                list.add(prev);
            } else {
                // If num is 0, reset everything
                list = new ArrayList<>();
                list.add(1);
                prev = 1;
            }
        }

        public int getProduct(int k) {
            int n = list.size();

            // If there are fewer than k elements, return 0 (reset due to zero)
            return (k < n) ? prev / list.get(n - 1 - k) : 0;
        }
}
