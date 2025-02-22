/*
🔍 Intuition
The problem requires recovering a corrupted binary tree where:
    - The root is always set to 0.
    - For any node with value x:
        * Its left child is 2 * x + 1
        * Its right child is 2 * x + 2
After reconstructing the tree, we must support O(1) find operations for any target value.

💡 Approach
Step 1. Use a HashSet (seen):
    - Stores all valid values in the tree for fast O(1) lookup.

Step 2. DFS to Rebuild the Tree:
    - Start from the root (0).
    - Recursively calculate and store the values for the left and right children:
        * Left child → 2 * x + 1
        * Right child → 2 * x + 2

Step 3. Implement find(target):
    - Simply check if target exists in seen (O(1)).

⏱️ Complexity
Time Complexity:
    - O(N) Each node is visited once
Space Complexity:
    - O(N) (Stores up to N elements in seen)

 */
package Find_Elements_in_a_Contaminated_Binary_Tree_1261;

import java.util.HashSet;

class FindElements {

    HashSet<Integer> seen;

    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }

    void dfs(TreeNode currentNode, int currentValue) {
        if (currentNode == null) return;

        seen.add(currentValue);

        dfs(currentNode.left, currentValue * 2 + 1);
        dfs(currentNode.right, currentValue * 2 + 2);
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
