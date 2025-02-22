package Find_Elements_in_a_Contaminated_Binary_Tree_1261;

public class Main {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);

        FindElements findElements = new FindElements(root);

        // Test cases
        System.out.println("Find 0: " + findElements.find(0)); // true (root)
        System.out.println("Find 1: " + findElements.find(1)); // true (left child of root)
        System.out.println("Find 2: " + findElements.find(2)); // true (right child of root)
        System.out.println("Find 3: " + findElements.find(3)); // true (left child of node 1)
        System.out.println("Find 4: " + findElements.find(4)); // false (does not exist)
        System.out.println("Find 5: " + findElements.find(5)); // false (does not exist)
    }
}
