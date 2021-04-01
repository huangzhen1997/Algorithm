import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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

        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(3)),null);
        List<Integer> output = inorderTraversal(root);

        for (int i : output){
            System.out.println(i);
        }
    }


    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> returning = new ArrayList<>();
        helper(root,returning);
        return returning;
    }

    public static void helper(TreeNode root,List<Integer> list){

        if(root==null){
            return;
        }

        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
}
