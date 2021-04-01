public class ReverseLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static void main(String[] args){

        ListNode first = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode output = reverseList(first);
  }

  public static ListNode reverseList(ListNode root){

        if(root==null || root.next==null){
            return root;
        }
        return recursiveCall(null,root);
  }

  public static ListNode recursiveCall(ListNode result, ListNode node){
        if(node==null){
            return result;
        }

        ListNode temp = node.next;
        node.next=result;
        return recursiveCall(node,temp);

  }
}
