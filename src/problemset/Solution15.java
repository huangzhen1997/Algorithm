import java.util.LinkedList;

public class Solution15 {

    static double max = 0;

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

    public static void main(String[] args){
        TreeNode root = new TreeNode(0,null,new TreeNode(1));
        System.out.println(maximumAverageSubtree(root));
    }

    public static double maximumAverageSubtree(TreeNode root) {

        double left = recursive(root.left).get(1);
        double right = recursive(root.right).get(1);
        return max;
    }


    public static LinkedList<Double> recursive(TreeNode root) {

        LinkedList<Double> entry = new LinkedList<>();  // 0 -> size, 1 -> average

        if (root == null) {
            entry.add(0.0);
            entry.add(0.0);
            return entry;
        }

        if (root.left == null && root.right == null) {
            entry.add(1.0);
            entry.add((double) root.val);
            max = Math.max(max, root.val);
            return entry;
        } else {
            double sum = 0;
            double size = 0;
            if (root.left != null) {
                LinkedList<Double> temp = recursive(root.left);
                sum += temp.get(1) * temp.get(0);
                size += temp.get(0);
            }

            if (root.right != null) {
                LinkedList<Double> temp = recursive(root.right);
                sum += temp.get(1) * temp.get(0);
                size += temp.get(0);
            }

            sum += root.val;
            size = size + 1.0;

            double topLevel = sum / size;
            max = Math.max(topLevel, max);

            entry.add(size);
            entry.add(topLevel);

            return entry;
        }
    }
}
