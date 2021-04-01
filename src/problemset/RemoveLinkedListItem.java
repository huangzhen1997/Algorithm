//LeetCode 203 Remove LInked List Elements

public class RemoveLinkedListItem {

    static class ListNode{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){
        ListNode headNode = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(4);
        ListNode sixth = new ListNode(5);
        ListNode seventh = new ListNode(6);

        headNode.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        ListNode temp = new ListNode(1);
        temp = headNode;


        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }

        System.out.print("null\nAfter the elment 6 node get removed :\n");


        //remove node with 6;

        headNode = removeElements(headNode,6);

        temp = headNode;

        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }

        System.out.print("null");

    }

    public static ListNode removeElements(ListNode head, int val) {

        if(head==null){
            return head;
        }

        ListNode temp = new ListNode(1);
        temp.next = head;
        head = temp;

        while(temp.next != null){
            if(temp.next.val==val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }

        return head.next;
    }

}
