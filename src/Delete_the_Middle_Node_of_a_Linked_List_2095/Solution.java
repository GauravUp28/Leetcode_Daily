/*
🔍 Intuition
To delete the middle node of a singly linked list efficiently, we can use the two-pointer technique:
    - A slow pointer that moves one step at a time.
    - A fast pointer that moves two steps at a time.

By the time the fast pointer reaches the end, the slow pointer will be at the middle of the list.
 We can then delete the middle node by adjusting the next pointer of slow.

💡 Approach
Step 1. Handle edge case: If the list contains only one node, return null.

Step 2. Use two pointers:
    - slow moves one step at a time.
    - fast moves two steps at a time.

Step 3. Stop when fast reaches the end:
    - The slow pointer will be at the node before the middle node.

Step 4. Delete the middle node:
    - Set slow.next = slow.next.next to remove the middle node.

Step 5. Return the modified list.

⏱️ Complexity
Time complexity:
    - O(n)

Space complexity:
    - O(1)

*/

package Delete_the_Middle_Node_of_a_Linked_List_2095;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list has only one node, return null
        if (head.next == null) return null;

        ListNode slow = head, fast = head.next.next;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;

        return head;
    }
}