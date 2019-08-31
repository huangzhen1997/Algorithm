public class addTwoNumbers {


    public static class ListNode {

       int val;
       ListNode next;

       ListNode(int x)
       {
           val = x;
       }
    }


   public static ListNode getTwoSum(ListNode node1,ListNode node2){

       int val1 = node1 != null ? node1.val : 0;
       int val2 = node2 != null ? node2.val : 0;
       int sum = (val1+val2);
       int carr= sum /10; // 1 or 0
       int remainder = sum % 10;

       ListNode curr= new ListNode(remainder);

       if (node2.next == null && node1.next == null && carr == 0){

           return curr;

       }
       else if (node2.next == null && node1.next == null && carr == 1){

           ListNode last = new ListNode(1);
           curr.next = last;

           return curr;
       }


       else

           {

           node1 = node1.next !=null ? node1.next : new ListNode(0);
           node2 = node2.next !=null ? node2.next : new ListNode(0);

           node1.val = node1.val+carr; // add carry to the next
           curr.next = getTwoSum(node1,node2);

           return curr;
       }
   }


   public static void main(String[] args){


        ListNode l1 = new ListNode(2);
        l1.next =new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode out = getTwoSum(l1,l2);

        System.out.println(out.val);

   }

   /*
   * (2 -> 4 -> 3) + (5 -> 6 -> 4)
   *
   * 7 -> 0 -> 8
   *
   *
   * */

}
