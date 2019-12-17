public class Node {

    public String name;
    public Node next;


    public  Node(String n, Node node){
        name=n;
        next = node;
    }

    public boolean is(String n){
        return n.equals(this.name);
    }


    public static boolean Isa(Node node, String target){

        if (node==null){
            return false ;
        }

        else{
            return node.is(target) || node.next.is(target);
        }



    }

    public static void main(String[] args){



        Node bird = new Node("bird",null);
        Node penguin = new Node("penguin",bird);
        Node chilly = new Node("Chilly",penguin);
        Node canary = new Node("canary",bird);
        Node tweety = new Node("Tweety",canary);

        System.out.println(Isa(tweety,"penguin"));

    }

}
