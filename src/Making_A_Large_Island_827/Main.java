package Making_A_Large_Island_827;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = new int[][] {{1,0}, {0, 1}};
        int[][] grid2 = new int[][] {{1,1}, {1, 0}};

        int size1 = solution.largestIsland(grid1);
        int size2 = solution.largestIsland(grid2);

        System.out.println("Size1: " + size1);
        System.out.println("Size2: " + size2);
    }

}
