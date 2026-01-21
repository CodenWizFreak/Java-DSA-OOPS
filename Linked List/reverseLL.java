// reversal using recursion
private void reverse(Node node) {
      if (node == tail) {
          head = tail;
          return;
      }
      reverse(node.next);
      tail.next = node;
      tail = node;
      tail.next = null;
}


// Leetcode Problem 206 (FAANG)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) { //iterative reversal (in-place reversal)
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev; //new head
        
    }        
    
}
