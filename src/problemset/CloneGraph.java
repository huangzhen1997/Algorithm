import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

        public Node cloneGraph(Node node) {

            Map<Node,Node> lookup =new HashMap<>();
            Node output = helper(node,lookup);
            return output;
        }

        public Node helper(Node node,Map<Node,Node> lookup){
            if(node==null){
                return null;
            }
            if(lookup.get(node)!=null){
                return lookup.get(node);
            }

            Node cur = new Node(node.val,null);
            lookup.put(node,cur);

            ArrayList<Node> neighbors=new ArrayList<Node>();
            for(Node i: node.neighbors){
                Node neighbor = helper(i,lookup);
                neighbors.add(neighbor);
            }

            cur.neighbors = neighbors;
            return cur;
        }
}
