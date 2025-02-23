package Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_889;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] preorder = new int[] {1,2,4,5,3,6,7};
        int[] postorder = new int[] {4,5,2,6,7,3,1};

        TreeNode root = solution.constructFromPrePost(preorder, postorder);

        System.out.println("Constructed Binary Tree is: " + levelOrderTraversal(root));
    }

    // Function to perform level-order traversal
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return result;
    }
}
