package Decode_String_394;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "3[a]2[bc]";
        String s2 = "2[abc]3[cd]ef";

        System.out.println("Decoded String 1: " + solution.decodeString(s1));
        System.out.println("Decoded String 2: " + solution.decodeString(s2));
    }
}
