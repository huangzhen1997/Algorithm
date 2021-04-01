import java.util.LinkedList;

public class MaximumAverageSubtree {

    static double max = Double.MIN_VALUE;

    public static void main(String[] args){
        TreeNode root = new TreeNode(0,null,new TreeNode(1));
        System.out.println(maximumAverageSubtree(root));
    }

    public static double maximumAverageSubtree(TreeNode root) {
        recursive(root);
        return max;
    }

    public static LinkedList<Double> recursive(TreeNode root){

        LinkedList<Double> entry = new LinkedList<>();  // 0 -> size, 1 -> average

        if(root.left == null && root.right==null){
            entry.add(1.0);
            entry.add((double)root.val);
            max= Math.max(max,root.val);
            return entry;
        }

        else{
            double sum = 0.0;
            double size = 0.0;
            if(root.left!=null){
                LinkedList<Double> temp = recursive(root.left);
                sum += temp.get(1)*temp.get(0);
                size+=temp.get(0);
            }

            if(root.right!=null){
                LinkedList<Double> temp = recursive(root.right);
                sum += temp.get(1)*temp.get(0);
                size+=temp.get(0);
            }

            sum+= (double) root.val;
            size= size+1.0;

            double topLevel = sum/size;
            max = Math.max(topLevel,max);

            entry.add(size);
            entry.add(topLevel);

            return entry;
        }


    }

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
