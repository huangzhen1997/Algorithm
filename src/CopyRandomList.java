import java.util.*;

class CopyRandomList {


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        Map<Node,Node> lookup = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            Node toput= new Node(cur.val);
            lookup.put(cur, toput);
            cur = cur.next;
        }

        cur = head;
        while(cur!=null){
            lookup.get(cur).next = lookup.get(cur.next);
            lookup.get(cur).random = lookup.get(cur.random);
            cur = cur.next;
        }

        return lookup.get(head);

//         if(head == null || lookup.containsKey(head)){
//             return lookup.get(head);
//         }

//         Node cur = new Node(head.val);
//         lookup.put(head,cur);
//         cur.next = copyRandomList(head.next);
//         cur.random = copyRandomList(head.random);

//         return cur;
    }
}