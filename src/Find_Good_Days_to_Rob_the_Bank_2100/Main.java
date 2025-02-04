package Find_Good_Days_to_Rob_the_Bank_2100;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] security = new int[] {5, 3, 3, 3, 5, 6, 2};
        int time = 2;

        System.out.println("Good days to rob bank: " + solution.goodDaysToRobBank(security, time));
    }
}
