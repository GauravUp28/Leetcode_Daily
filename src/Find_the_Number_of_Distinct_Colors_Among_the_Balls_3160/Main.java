package Find_the_Number_of_Distinct_Colors_Among_the_Balls_3160;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = new int[][] {{1, 4}, {2, 5}, {1, 3}, {3, 4}};

        Solution solution = new Solution();

        System.out.println("Distinct Colors: " + Arrays.toString(solution.queryResults(limit, queries)));

    }
}
