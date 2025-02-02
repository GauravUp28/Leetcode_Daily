package Check_if_Array_Is_Sorted_and_Rotated_1752;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[] {3, 4, 5, 1, 2};
        int[] nums2 = new int[] {2, 1, 3, 4};

        Solution solution = new Solution();

        System.out.println("Assert True: " + solution.check(nums1));
        System.out.println("Assert False: " + solution.check(nums2));
    }
}
