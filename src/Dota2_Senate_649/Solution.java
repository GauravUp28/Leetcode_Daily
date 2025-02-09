/*
🔍 Intuition
The problem models a voting system where Radiant ('R') and Dire ('D') senators take turns banning each other. The key observation is:
    - Each senator can only ban one senator per round.
    - The order of banning matters—whichever senator appears earlier gets to ban a later senator first.
    - The voting cycle repeats—banned senators lose their turn but the remaining ones continue in a circular fashion.

By using two queues, one for Radiant ('R') and one for Dire ('D'), we can efficiently simulate the banning process.

💡 Approach
Step 1. Initialize two queues:
    - rQueue: Stores indexes of 'R' senators.
    - dQueue: Stores indexes of 'D' senators.

Step 2. Populate the queues:
    - Iterate through the senate string and push indexes into the respective queues.

Step3. Simulate the voting process:
    - At each step, remove the first element from both queues (rTurn for Radiant, dTurn for Dire).
    - The senator who appears earlier in the string (lower index) bans the other.
    - The winner gets another turn in the next cycle, so we reinsert their index + n (to ensure cyclic behavior).

Step4. Terminate when one queue is empty:
    - If rQueue is empty → "Dire" wins.
    - If dQueue is empty → "Radiant" wins.

⏱️ Complexity
Time complexity:
    - O(n) - Populating the queues takes O(N) time.

Space complexity:
    - O(n) - Storing the index of senators in the queues takes O(N) space

 */

package Dota2_Senate_649;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> rQueue = new LinkedList<>(); // Stores indices of 'R' senators
        Queue<Integer> dQueue = new LinkedList<>(); // Stores indices of 'D' senators

        // Populate the queues with the indices of each senator
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        // Process rounds until one party is eliminated
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rTurn = rQueue.poll(); // Get the next Radiant senator
            int dTurn = dQueue.poll(); // Get the next Dire senator

            // The senator appearing first in the string bans the other
            if (rTurn < dTurn) {
                rQueue.add(rTurn + n); // Radiant wins and gets another turn
            } else {
                dQueue.add(dTurn + n); // Dire wins and gets another turn
            }
        }

        // If Radiant queue is empty, Dire wins; otherwise, Radiant wins
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}

