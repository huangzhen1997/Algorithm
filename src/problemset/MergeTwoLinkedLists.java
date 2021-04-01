//LeetCode #21

public class MergeTwoLinkedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){this.val=val;this.next=next;}
    }
    public static void main(String[] args){
        ListNode l1Tail = new ListNode(4);
        ListNode l1Mid = new ListNode(2,l1Tail);
        ListNode l1Head = new ListNode(1,l1Mid);

        ListNode l2Tail = new ListNode(4);
        ListNode l2Mid = new ListNode(3,l2Tail);
        ListNode l2Head = new ListNode(1,l2Mid);

        ListNode output = mergeTwoLists(l1Head,l2Head);



//        System.out.println(l1Head.val);
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){

        if(l1==null && l2==null){
            return null;
        }
        else if (l1==null){
            return l2;
        }
        else if (l2==null){
            return l1;
        }
        else{

        }

        ListNode trackingMerged = new ListNode();
        ListNode mergedHead = new ListNode();

        ListNode trackingleft = l1;
        ListNode trackingright = l2;

        if(trackingleft.val>=trackingright.val){
            trackingMerged=trackingright;
            trackingright=trackingright.next;
        }
        else{
            trackingMerged=trackingleft;
            trackingleft=trackingleft.next;
        }

        mergedHead.next=trackingMerged;

        while(trackingleft!=null && trackingright!=null){
            if (trackingleft.val>=trackingright.val){
                trackingMerged.next= trackingright;
                trackingMerged=trackingMerged.next;
                trackingright = trackingright.next;
            }
            else if (trackingleft.val < trackingright.val){
                trackingMerged.next= trackingleft;
                trackingMerged=trackingMerged.next;
                trackingleft = trackingleft.next;
            }
        }

        if(trackingleft==null && trackingright!=null){
            trackingMerged.next = trackingright;
        }
        if(trackingleft!= null && trackingright==null){
            trackingMerged.next = trackingleft;
        }

        return mergedHead.next;
    }
}
