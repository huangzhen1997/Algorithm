import java.util.List;

public class lowestCommonAncestor {

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

//        List<TreeNode> path = new LinkedList<>();
//        helper(s,fourth.left, path);
//        for(TreeNode node : path){
//            System.out.println(node.val);
//        }

        System.out.println(lowestCommonAncestor(s,fourth.left,third).val);
    }

    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        List<TreeNode> leftPath = new LinkedList<>();
//        helper(root,p,leftPath);
//        List<TreeNode> rightPath = new LinkedList<>();
//        helper(root,q,rightPath);
//
//        if(leftPath.size()==0 || rightPath.size() ==0 ) return null;
//
//        int pIndex = 0;
//        int qIndex = 0;
//
//        TreeNode output = null;
//
//        while(pIndex<leftPath.size() && qIndex<rightPath.size()){
//            if(leftPath.get(pIndex) == rightPath.get(qIndex)) output = leftPath.get(pIndex);
//            pIndex++;
//            qIndex++;
//        }
//
//        return output;
//    }

    public static int helper(TreeNode root, TreeNode node,List<TreeNode> path){

        if(root==null) return -1;
        path.add(root);
        if(root==node) return 1;
        if(helper(root.left,node,path)==1) return 1;
        if(helper(root.right,node,path)==1) return 1;
        path.remove(path.size()-1);

        return -1;

    }
}
