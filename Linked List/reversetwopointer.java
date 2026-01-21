//Leetcode problem 92

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right || head==null)
            return head;
      
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
      
        for(int i=1; i<left; i++) //moving prev to just before left pointer
            prev=prev.next;    
      
        ListNode curr = prev.next;
      
        for(int i=0;i<right-left;i++)
        {
            ListNode nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;

        }    
      
        return dummy.next;
        
    }
}
