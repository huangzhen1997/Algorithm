public class MoveZeros {
    public static void main(String[] args){
        int[] input = new int[]{0,1,0,3,12};
        MoveZeros(input);
        for(int i : input){
            System.out.print(i+" ");
        }
    }

//  Slow version

//    public static void MoveZeros(int[] nums){
//        int anchor = 0;
//        for(int explored = 0; explored <= nums.length-1; explored++){
//            if(nums[explored]!=0){
//                int temp = nums[anchor];
//                nums[anchor] = nums[explored];
//                nums[explored] = temp;
//
//                anchor++;
//            }
//        }
//    }

    public static void MoveZeros(int[] nums){
        int countingNonZero = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[countingNonZero++]=nums[i];
            }
        }
        for(int i = countingNonZero;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
