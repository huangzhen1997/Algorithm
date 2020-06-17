//LeetCode #59
//really wierd index issue，still not understanding

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] output = generateMatrix(3);
        System.out.println(output[0][1]);
    }
    public static int[][] generateMatrix(int n){

        int[][] output = new int[n][n];
        int counter = 1;
        int i, iv = 0 , ih = 0, v = n, h = n;

        while(ih < h && iv < v ){
            for(i = iv ; i < v ; i++){
                output[ih][i]=counter++;
            }
            ih++;

            for(i = ih; i < h ; i ++){
                output[i][v-1] = counter++;
            }
            v--;

            if(ih<h){
                for(i = v-1; i>=iv; i--){
                    output[h-1][i] = counter ++;
                }
                h--;
            }

            if(iv<v){
                for(i=h-1;i>=ih;i--){
                    output[i][iv]=counter++;
                }
                iv++;
            }
        }

        return output;
    }
}
