import java.util.ArrayList;
import java.util.List;

//LeetCode #113 Path Sum II
public class PathSumII {

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

        List<List<Integer>> output =  pathSum(root,22);
        System.out.println(output.get(0).get(0));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target){
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if(root==null){
            return output;
        }

        else{
            doingRecursive(path,output,root,target);
        }

        return output;
    }

    public static void doingRecursive(List<Integer> path, List<List<Integer>> output, TreeNode node, int target){

        if(node.left == null && node.right == null){
            //reach the leaves
            if(target==node.val){
                //the path we want
                path.add(node.val);
                output.add(path);
            }
        }

        else{
            if(node.left!=null){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node.val);
                doingRecursive(newPath,output,node.left,target-node.val);
            }
            if(node.right!=null){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node.val);
                doingRecursive(newPath,output,node.right,target-node.val);
            }
        }
    }
}
