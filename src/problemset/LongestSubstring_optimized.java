import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_optimized {


    public static void main(String[] args){

        String input = "abba";
        int output = lengthOfLongestSubstring(input);
        System.out.println(output);

    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for ( int i = 0; i < s.length();i++){

            char toCheck = s.charAt(i);

            if (map.containsKey(toCheck)){

                int val = map.get(toCheck);

                if(start < val){
                    start = val;
                }

            }

            max = Math.max(max, i - start +1 );

            map.put(toCheck,i+1);

        }
        return max;

    }
}



