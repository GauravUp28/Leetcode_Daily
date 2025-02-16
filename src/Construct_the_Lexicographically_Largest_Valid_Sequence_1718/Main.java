package Construct_the_Lexicographically_Largest_Valid_Sequence_1718;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;

        System.out.println("Largest Valid Sequence = " + Arrays.toString(solution.constructDistancedSequence(n)));
    }
}
