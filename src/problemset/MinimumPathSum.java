import java.util.Deque;
import java.util.LinkedList;

public class MinimumPathSum {

    //enhanced with the path, as saved in "output" list below
    public static void main(String[] args){
        int[][] input = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
            };

        System.out.println(minPathSum(input));
    }


    public static int minPathSum(int[][] grid) {
        int[][] sumMap = new int[grid.length][grid[0].length];

        for(int i = 0; i<grid.length;i++){
            for(int j =0; j<grid[0].length;j++){
                sumMap[i][j] = grid[i][j];
            }
        }

        for(int i = 1; i< grid[0].length;i++){
            sumMap[0][i] += sumMap[0][i-1];
        }

        for(int i = 1; i< grid.length;i++){
            sumMap[i][0] += sumMap[i-1][0];
        }

        for(int i =1; i < grid.length;i++){
            for(int j =1; j < grid[0].length;j++){
                sumMap[i][j] += Math.min(sumMap[i][j-1],sumMap[i-1][j]);
            }
        }

        int i=grid.length-1;
        int j=grid[0].length-1;
        Deque<Integer> output = new LinkedList<>();
        output.addFirst(grid[i][j]);
        while(i>0 || j>0){
            int left = j >0 ? sumMap[i][j-1] : Integer.MAX_VALUE;
            int top = i > 0 ? sumMap[i-1][j] : Integer.MAX_VALUE;
            if(left > top) {
                output.addFirst(grid[--i][j]);
            }
            else{
                output.addFirst(grid[i][--j]);
            }
        }

        return sumMap[grid.length-1][grid[0].length-1];
    }
}
