//LeetCode #560

import java.util.HashMap;

public class subarraySum {
    public static void main(String[] args){
        int[] input = new int[]{1,1,1};
        System.out.println(subarraySum(input,2));
    }


    //version 1  O(n^2)
//    public static int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int[] accSum = new int[nums.length+1];
//        accSum[0] = 0;// the sum of the first 0 items in the "nums" array is 0
//        for(int i = 0; i <= nums.length-1 ; i++){
//            accSum[i+1] = accSum[i]+nums[i];
//        }
//        for(int start = 0; start < nums.length; start++){
//            for(int end = start+1; end <= nums.length;end++){// accSum[nums.length] is the sum of the entire list
//                if(accSum[end]-accSum[start]==k){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }




//version 2 O(n)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> mapping = new HashMap<>();
        mapping.put(0,1);
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(mapping.containsKey(sum-k)){
                count+=mapping.get(sum-k);
            }
            mapping.put(sum,mapping.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
