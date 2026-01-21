// Leetcode problem 143

class Solution {
    public void reorderList(ListNode head) {
        // Edge case: empty list or single node, nothing to reorder
        if (head == null || head.next == null) return;

        // -------------------------------
        // Step 1: Find the middle node
        // -------------------------------
        // We'll split the list into two halves:
        // First half: head → ... → middle
        // Second half: middle.next → ... → end
        ListNode slow = head; // moves 1 step at a time
        ListNode fast = head; // moves 2 steps at a time

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;         // move slow by 1
            fast = fast.next.next;    // move fast by 2
        }
        // After loop:
        // slow points to middle node of the list
        // fast points to last node (or second last if even)

        // -------------------------------
        // Step 2: Reverse the second half
        // -------------------------------
        ListNode second = reverse(slow.next); // reverse second half
        slow.next = null; // cut the link to first half

        // -------------------------------
        // Step 3: Merge the two halves
        // -------------------------------
        ListNode first = head; // pointer for first half

        while (second != null) {
            // Save next pointers
            ListNode temp1 = first.next;  // store next node of first half
            ListNode temp2 = second.next; // store next node of reversed second half

            // Reorder links
            first.next = second; // point first node to node from second half
            second.next = temp1; // link node from second half to next of first half

            // Move pointers forward
            first = temp1;  // move first pointer to next
            second = temp2; // move second pointer to next
        }
    }

    // Helper function: reverse a linked list in-place
    private ListNode reverse(ListNode head) {
        ListNode prev = null; // previous node
        ListNode curr = head; // current node

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }
        // prev is new head of reversed list
        return prev;
    }
}
