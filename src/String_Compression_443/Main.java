package String_Compression_443;

public class Main {
    public static void main(String[] args) {
        char[] chars1 = new char[] {'a','a','b','b','c','c','c'};
        char[] chars2 = new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        Solution solution = new Solution();

        System.out.println("Compressed String's length: " + solution.compress(chars1));
        System.out.println("Compressed String's length: " + solution.compress(chars2));
    }
}
