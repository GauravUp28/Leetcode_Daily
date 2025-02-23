/*
🔍 Intuition
We need to construct a binary tree from given preorder and postorder traversals. The key observations are:
    - Preorder Traversal (Root → Left → Right)
        * The first element is always the root.
    - Postorder Traversal (Left → Right → Root)
        * The last element is always the root.

Since these two traversals don’t uniquely define a binary tree, we assume that the given tree is full
(every node has either 0 or 2 children).

💡 Approach
Step 1. Initialize preIndex and postIndex to track positions in the arrays.

Step 2. Recursively build the tree:
    - Pick preorder[preIndex] as the root.
    - If root.val != postorder[postIndex], recursively construct the left subtree.
    - If root.val != postorder[postIndex], recursively construct the right subtree.
    - Increment postIndex once we fully process a subtree.

⏱️ Complexity
Time Complexity:
    - O(N) - Each node is processed exactly once

Space Complexity:
    - O(N) - Due to recursive function calls
 */

package Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_889;

class Solution {
    int preIndex = 0, postIndex = 0; // Track position in preorder and postorder arrays

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Create root from preorder index
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        // Construct left subtree if it does not match postorder root
        if (root.val != postorder[postIndex]) {
            root.left = constructFromPrePost(preorder, postorder);
        }

        // Construct right subtree if it does not match postorder root
        if (root.val != postorder[postIndex]) {
            root.right = constructFromPrePost(preorder, postorder);
        }

        // Move to next postorder element after finishing a subtree
        postIndex++;

        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;TreeNode() {}
    TreeNode(int val) {
        this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

