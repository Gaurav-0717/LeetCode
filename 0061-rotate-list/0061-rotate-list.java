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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int size=1;

        while(temp.next!=null){
            size++;
            temp=temp.next;
        }

        temp.next = head;

        ListNode temp1 = head;

        for(int i=1;i<size - k % size;i++){
            temp1=temp1.next;
        }

        head = temp1.next;

        temp1.next = null;

        return head;
    }
}