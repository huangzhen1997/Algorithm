public class PathSumIII {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args){

//        TreeNode root = new TreeNode(-2,null,new TreeNode(-3));
        TreeNode ri = new TreeNode(1);
        TreeNode tw = new TreeNode(2);
        tw.right = ri;
        TreeNode st = new TreeNode(3,new TreeNode(3), new TreeNode( -2));
        TreeNode five = new TreeNode(5,st,tw);
        TreeNode nthree = new TreeNode(-3,null,new TreeNode(11));
        TreeNode root = new TreeNode(10,five,nthree);

        System.out.println(pathSum(root,8));
    }

    static int count=0;
    public static int pathSum(TreeNode root, int sum) {
        inorder(root, sum);
        return count;
    }
    public static void inorder(TreeNode root, int sum){
        if(root!=null){
            inorder(root.left, sum);
            count+=sum(root, sum);
            inorder(root.right, sum);
        }
    }
    public static int sum(TreeNode root, int sum){
        if(root!=null){
            return (sum==root.val ? 1 : 0)+sum(root.left, sum-root.val)+sum(root.right, sum-root.val);
        }
        return 0;
    }
}
