package Remove_All_Occurrences_of_a_Substring_1910;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "daabcbaabcbc";
        String part = "abc";

        System.out.println("String after removing occurences: " + solution.removeOccurrences(s, part));
    }
}
