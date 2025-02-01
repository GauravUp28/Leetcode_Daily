package Binary_Tree_Level_Order_Traversal_102;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // Print the result
        // Expected Result: [[3], [9, 20], [15, 7]]
        System.out.println(result);
    }
}
