/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapNodesInPairs {

     public class ListNode {
      int val;
      ListNode next;
    ListNode(int x) { val = x; }
  }
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next == null) return head;

        ListNode markStart = new ListNode(0); //dummy variable for the returning head               L1->1->2->3->4
      //                                                                                                   L2
        markStart.next = head;
        ListNode L1 = markStart;
        ListNode L2 = head;

        while(L2!=null && L2.next!=null){
            ListNode temp_next = L2.next.next;
            L2.next.next = L1.next;
            L1.next = L2.next;
            L2.next = temp_next;
            L1=L2;
            L2=L2.next;
        }

        return markStart.next;
    }


}