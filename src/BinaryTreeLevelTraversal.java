import java.util.*;


class BinaryTreeTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return res;
        }

        else{
            queue.add(root);

            while(queue.size()!=0){

                List<Integer> curRes = new ArrayList<>();
                int levelSize = queue.size();
                for (int i = 0; i<levelSize;i++){

                    TreeNode currentNode = queue.poll();
                    if(currentNode.left != null){
                        queue.add(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.add(currentNode.right);
                    }
                    curRes.add(currentNode.val);
                }

                res.add(curRes);
            }

            return res;
        }
    }
}