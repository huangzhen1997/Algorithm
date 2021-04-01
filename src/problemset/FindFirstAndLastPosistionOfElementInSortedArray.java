//Leetcode #34

public class FindFirstAndLastPosistionOfElementInSortedArray {
    public static void main(String[] args){
        int[] nums = {2,2};
        int target = 2;
        int[] output = searchRange(nums,target);

        System.out.println(output[0]+" "+output[1]);
    }

    public static int[] searchRange(int[] nums,int target){

        if(nums.length==0){
            return new int[]{-1, -1};
        }

        else if(nums.length==1){
            if(nums[0]==target){
                return new int[]{0,0};
            }
            return new int[]{-1,-1};
        }


        else{
            int left = 0;
            int right = nums.length-1;
            int medium;

            while(left<=right){

                medium = (right+left) / 2;
                if(nums[medium] < target){
                    left = medium + 1;
                }
                else if (nums[medium] > target){
                    right = medium - 1;
                }

                else{
                    int first = medium - 1;
                    while(first >=0  && nums[first] == target) first--;
                    int second = medium + 1;
                    while(second < nums.length && nums[second] == target) second++;
                    return new int[]{first+1,second-1};
                }
            }
            return new int[]{-1,-1};
        }
    }
}
