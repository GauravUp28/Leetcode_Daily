package Equal_Row_and_Column_Pairs_2352;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        System.out.println("Equal pairs : " + solution.equalPairs(grid));
    }
}
