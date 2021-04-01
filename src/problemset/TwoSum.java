import java.util.HashMap;


public class TwoSum {

    public static int[] twoSumming(int[] nums, int target) {


        HashMap<Integer, Integer> cache = new HashMap();

        for (int i = 0; i < nums.length; i++) {

            int cur = nums[i];

            if (!cache.containsKey(cur)) {

                int toCheck = target - nums[i];
                cache.put(toCheck, i);


            } else {

                int pos = cache.get(cur);
                return new int[]{pos, i};

            }

        }

        return null;
    }


    public static void main(String[] args){


        int[] input = {2,7,5,3,1,5,7};

        int[] output = twoSumming(input, 9);

        String  printOut = outputformat(output);

        System.out.println(printOut);

    }


    public static String outputformat(int[] array){
        String output = "[";
        for(int i=0;i<array.length;i++){
            output = output+(Integer.valueOf(array[i]));
            if(i!=array.length-1){
                output = output+",";
            }
            else{
                output=output+"]";
            }
        }
        return output;
    }


}
