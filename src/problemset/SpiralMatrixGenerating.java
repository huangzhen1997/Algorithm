//LeetCode #59
//really wierd index issue，still not understanding

public class SpiralMatrixGenerating {
    public static void main(String[] args){
        int[][] output = generateMatrix(3);
        System.out.println(output[0][1]);
    }
    public static int[][] generateMatrix(int n){

        int[][] matrix = new int[n][n];
        int counter = 1;
        int c1 = 0, c2 = matrix[0].length-1, r1 = 0, r2 = matrix.length-1;

        while(c1<=c2&&r1<=r2){
            for(int c = c1;c<=c2;c++) matrix[r1][c]=counter++;
            for(int r = r1+1;r<=r2;r++) matrix[r][c2]=counter++;
            if(r1<r2&&c1<c2){
                for(int c = c2-1;c>c1;c--) matrix[r2][c]=counter++;
                for(int r = r2;r>r1;r--) matrix[r][c1]=counter++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }


        return matrix;
    }

//    public static int[][] generateMatrix(int n){
//
//        int[][] output = new int[n][n];
//        int counter = 1;
//        int i, iv = 0 , ih = 0, v = n, h = n;
//
//        while(ih < h && iv < v ){
//            for(i = iv ; i < v ; i++){
//                output[ih][i]=counter++;
//            }
//            ih++;
//
//            for(i = ih; i < h ; i ++){
//                output[i][v-1] = counter++;
//            }
//            v--;
//
//            if(ih<h){
//                for(i = v-1; i>=iv; i--){
//                    output[h-1][i] = counter ++;
//                }
//                h--;
//            }
//
//            if(iv<v){
//                for(i=h-1;i>=ih;i--){
//                    output[i][iv]=counter++;
//                }
//                iv++;
//            }
//        }
//
//        return output;
//    }
}
