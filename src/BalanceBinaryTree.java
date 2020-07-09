public class BalanceBinaryTree {

    static int gap = Integer.MIN_VALUE;

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){}
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args){

//        TreeNode left = new TreeNode(15);
//        TreeNode right = new TreeNode(7);
//        TreeNode rightRoot = new TreeNode(20, left, right);
//        TreeNode leftRoot = new TreeNode(9);
//        TreeNode root = new TreeNode(3,leftRoot,rightRoot);

        TreeNode root = new TreeNode(1);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root){

        if(root!=null){

            balanceFactor(root);

            return gap<=1 && isBalanced(root.left) && isBalanced(root.right);
        }

        return true;
    }

    public static int balanceFactor(TreeNode node){

        if(node!=null){
            int left = balanceFactor(node.left);
            int right = balanceFactor(node.right);
            gap = Math.abs(left-right);
            return 1 + Math.max(right,left);
        }

        return 0;
    }
}
