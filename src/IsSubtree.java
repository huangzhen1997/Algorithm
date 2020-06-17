public class IsSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(5);
        s.left=second;
        s.right=third;
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(2);
        second.left=fourth;
        second.right=fifth;
        third.left =null;
        third.right=null;
        fourth.left=new TreeNode(0);

        TreeNode t =new TreeNode(4);
        t.left = new TreeNode(1);
        t.right =new TreeNode(2);

        System.out.println(isSubtree(s,t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        if(s==null && t !=null){
           return false;
        }

        return isIdentical(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public static boolean isIdentical(TreeNode node1,TreeNode node2){

        if(node1 == null){
            return node2 == null  ? true : false;
        }

        if(node2 == null){
            return node1 == null  ? true : false;
        }

        boolean first = node1.val==node2.val;
        boolean second = isIdentical(node1.left,node2.left);
        boolean third = isIdentical(node1.right,node2.right);

        return first && second && third;
    }
}
