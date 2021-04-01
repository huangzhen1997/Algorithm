import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args){
        System.out.println("hello");
    }


    //using counter for each level and inner loop connecting the nodes at the same level.

    public Node Connect(Node root){

        if(root==null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                Node output = queue.poll();
                if(size==1) output.next = null;
                if(size > 1){
                    output.next = queue.peek();
                }
                if(output.left!=null) queue.add(output.left);
                if(output.right!=null) queue.add(output.right);
                size--;
            }
        }

        return root;
    }
}
