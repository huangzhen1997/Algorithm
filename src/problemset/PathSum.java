//LeetCode #112 Path Sum
public class PathSum {

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


        TreeNode five = new TreeNode(4,new TreeNode(11,new TreeNode(7), new TreeNode(2)),null);
        TreeNode nthree = new TreeNode(8,new TreeNode(13),new TreeNode(4, new TreeNode(5), new TreeNode(1)));
        TreeNode root = new TreeNode(5,five,nthree);

        boolean output =  hasPathSum(root,22);
        System.out.println(output);
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        return dowork(root,target) ;
    }

    public static boolean dowork(TreeNode root, int target){

        if(root == null){
            return false;
        }
        else if(root.left==null && root.right==null && root.val == target){
            return true;
        }
        else{
            return dowork(root.left,target-root.val) || dowork(root.right,target-root.val);
        }
    }
}
