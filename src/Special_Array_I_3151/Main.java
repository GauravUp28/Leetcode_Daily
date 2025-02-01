package Special_Array_I_3151;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = new int[] {2, 1, 4};
        int[] nums2 = new int[] {4, 3, 1, 6};

        System.out.println("Assert true: " + sol.isArraySpecial(nums1));
        System.out.println("Assert false: " + sol.isArraySpecial(nums2));
    }
}
