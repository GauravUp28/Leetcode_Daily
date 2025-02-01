/*
🔍 Intuition
The level order traversal of a binary tree is implemented using Breadth-First Search (BFS) with the help of a queue.
Each level of the tree is processed one by one, ensuring that child nodes are enqueued before moving to the next level.

💡 Approach
Step 1: If the tree is empty, return an empty list.
Step 2: Initialize a queue with the root node.
Step 3: Process each level by iterating through the current size of the queue.
Step 4: Dequeue nodes, record their values, and enqueue their left and right children if they exist.
Step 5: Repeat the process until all nodes are traversed.

⏱️ Complexity
Time Complexity (TC)
Each node is enqueued and dequeued exactly once, making it O(N), where N is the total number of nodes in the binary tree.

Space Complexity (SC)
Worst case (full binary tree): The queue can store N/2 nodes at the last level, leading to O(N) space complexity.
Best case (skewed tree): The queue stores at most one node at a time, leading to O(1) - O(N) space usage.

Thus, the overall time complexity is O(N) and space complexity is O(N). 🚀
 */

package Binary_Tree_Level_Order_Traversal_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // Queue to facilitate BFS traversal
        List<List<Integer>> result = new ArrayList<>(); // Stores the final level-order traversal result

        // Edge case: If the tree is empty, return an empty list
        if (root == null) return result;

        queue.offer(root); // Start BFS from the root node
        while (!queue.isEmpty()) {
            int level = queue.size(); // Number of nodes at the current level
            List<Integer> subList = new ArrayList<>(); // Stores nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < level; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue the front node
                subList.add(currentNode.val); // Add the node's value to the current level list

                // Enqueue left child if present
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                // Enqueue right child if present
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(subList); // Add the level list to the final result
        }

        return result; // Return the level order traversal
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
