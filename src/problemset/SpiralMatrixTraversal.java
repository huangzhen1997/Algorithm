//LeetCode #54

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
    public static void main(String[] args){
        SpiralMatrixGenerating generating = new SpiralMatrixGenerating();
        int[][] output = generating.generateMatrix(3);
        List<Integer> res = spiralOrder(output);
        for(int i : res){
            System.out.println(i);
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix){
        ArrayList<Integer> output = new ArrayList<>();
        if(matrix.length==0){
            return output;
        }

        int c1 = 0, c2 = matrix[0].length-1, r1 = 0, r2 = matrix.length-1;

        while(c1<=c2&&r1<=r2){
            for(int c = c1;c<=c2;c++) output.add(matrix[r1][c]);
            for(int r = r1+1;r<=r2;r++) output.add(matrix[r][c2]);
            if(r1<r2&&c1<c2){
                for(int c = c2-1;c>c1;c--) output.add(matrix[r2][c]);
                for(int r = r2;r>r1;r--) output.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return output;
    }
}
