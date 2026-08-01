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
    public void reorderList(ListNode head) {
        ListNode middle = findMiddleElement(head);
        System.out.println("middle" + middle.val);
        reverse(middle); 
        ListNode second = middle.next;
        middle.next = null;
        mergeSecondAndFirstHalf(head, second);
        while(head!=null)
        {
            System.out.println(head.val);
            head = head.next;
        // mergeSecondAndFirstHalf(head, second);
      }
    }

    public void mergeSecondAndFirstHalf(ListNode first, ListNode second){
        while(second!=null){
        ListNode temp = first.next;
        first.next = second;
        ListNode temp2 = second.next;
        second.next = temp;
        first = temp;
        second = temp2;
        }
        if (first != null && first.next == first) {
            first.next = null;
        }
    }
    

    public ListNode findMiddleElement(ListNode node){
      ListNode slow = node;
      ListNode fast = node.next;
      while(fast!=null && fast.next!=null){
        slow =slow.next;
        fast = fast.next.next;
      }
      return slow;
    }

    public void reverse(ListNode node){
        if(node==null || node.next == null){
            return;
        }
        ListNode lastFound = node;
        ListNode prev = null;
        ListNode cur = node.next;
        while(cur!=null){
            ListNode  temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        lastFound.next = prev;
    }
}
