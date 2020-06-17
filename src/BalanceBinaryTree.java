public class BalanceBinaryTree {

    static int largestGap = Integer.MIN_VALUE;

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

        TreeNode left = new TreeNode(15);
        TreeNode right = new TreeNode(7);
        TreeNode rightRoot = new TreeNode(20, left, right);
        TreeNode leftRoot = new TreeNode(9);
        TreeNode root = new TreeNode(3,leftRoot,rightRoot);

        System.out.println(isBalanced(root));


    }

    public static boolean isBalanced(TreeNode root){

        if(root!=null){

            balanceFactor(root);

            return largestGap<=1 && isBalanced(root.left) && isBalanced(root.right);
        }

        return true;
    }

    public static int balanceFactor(TreeNode node){

        if(node!=null){
            int left = balanceFactor(node.left);
            int right = balanceFactor(node.right);
            largestGap = Math.max(largestGap,Math.abs(left-right));

            return 1 + Math.max(right,left);
        }

        return 0;
    }
}
