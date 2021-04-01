//#leetcode 84

public class BiggestRectangle {
    public static void main(String[] args){
        System.out.println(biggestArea(new int[]{2,7,9,4,1},5));
    }
    public static int biggestArea(int[] input,int length){
        int[] lookup = new int[length];
        for(int i = 0; i < length; i++){
            int left_index= i;
            for(int j = i-1; j>=0;j--){
                if(input[j]<input[i]){
                    break;
                }
                left_index=j;
            }
            int right_index=i;
            for(int k = i+1;k<length;k++){
                if(input[k]<input[i]){
                    break;
                }
                right_index=k;
            }
            lookup[i] = (right_index-left_index+1)*input[i];
        }

        int max = Integer.MIN_VALUE;
        for(int item : lookup){
            max = Math.max(max,item);
        }

        return max;
    }
}
