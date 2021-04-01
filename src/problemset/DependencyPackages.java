import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DependencyPackages {
    public static void main(String[] args){
        HashMap<Integer, List<Integer>> input = new HashMap<>();
        input.put(0, null);
        input.put(1,Arrays.asList(2));
        input.put(2,Arrays.asList(0));
        input.put(3,Arrays.asList(1,2));
        System.out.println(ordering(input));
    }

    public static List<Integer> ordering(HashMap<Integer,List<Integer>> constraints){

        List<Integer> output = new LinkedList<>();
        for(int i : constraints.keySet()){
            List<Integer> visited = new LinkedList<>();
            if(helper(i,output,constraints,visited)==-1) return null;
        }
        return output;
    }

    public static int helper(int i, List<Integer> output,HashMap<Integer,List<Integer>> constraints, List<Integer> visited){
        if(output.contains(i) ){
            return 1;
        }

        if(visited.contains(i)){
            return -1;
        }

        visited.add(i);
        List<Integer> constraint = constraints.get(i); // dependent packages
        if(constraint==null){
            output.add(i);
            return 1;
        }

        for(int j : constraint){
            if(!output.contains(j)){
                if(helper(j,output,constraints,visited)==-1) return -1;
                if(!output.contains(j)){
                    output.add(j);
                }
            }
        }
        if(!output.contains(i)){
            output.add(i);
        }

        return 1;
    }
}
