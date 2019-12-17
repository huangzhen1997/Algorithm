import java.util.*;


public class CombinationSum {
    public static void main(String args[]){


        List<List<Integer>> output = solve(new int[]{2,3,6,7}, 7);
        System.out.println(output);
    }

    public static List<List<Integer>> solve(int[] list, int target){

        List<List<Integer>> output = new ArrayList<>();
        if (output == null || target == 0){
            return output;
        }

        helper(output,new ArrayList<>(),list, target,0);

        return output;

    }

    public static void helper(List<List<Integer>> output,List<Integer> cur_list ,int[] input, int target, int cur_pos){    //Backtract helper function

        if (target<0){
            return;
        }
        if (target == 0){
            output.add(new ArrayList<>(cur_list));
            return;
        }

        for (int i = cur_pos; i<= input.length-1; i++){

            cur_list.add(input[i]);
            helper(output, cur_list, input, target-input[i], i);
            cur_list.remove(cur_list.size()-1);   // if the backtrack to the next index means the previous one doesn't work, then remove it from the current candidate arraylist
        }
    }
}

