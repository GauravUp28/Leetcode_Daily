package Delete_the_Middle_Node_of_a_Linked_List_2095;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original List 1: ");
        printLinkedList(head1);
        head1 = solution.deleteMiddle(head1);
        System.out.print("After Deleting Middle: ");
        printLinkedList(head1);
    }

    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
    // Helper method to print a linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
