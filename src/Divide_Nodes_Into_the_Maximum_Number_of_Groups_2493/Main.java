package Divide_Nodes_Into_the_Maximum_Number_of_Groups_2493;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = new int[][] {{1,2}, {1,4}, {1,5}, {2,6}, {2,3}, {4,6}};
        int groups = sol.magnificentSets(6, edges);

        // Expected Output = 4
        System.out.println("Total groups = " + groups);
    }
}