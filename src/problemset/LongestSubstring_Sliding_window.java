import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_Sliding_window {


    public static int lengthOfLongestSubstring(String s){

        int i= 0, j = 0, maxLength = 0;
        int length = s.length();
        Set<Character> lookup = new HashSet<>();

        while(i<length && j<length){

            if( ! lookup.contains(s.charAt(j))){

                lookup.add(s.charAt(j++));
                maxLength= Math.max(j-i,maxLength);


            }

            else{
                lookup.remove(s.charAt(i++));
            }


        }

        return maxLength;

    }



    public static void main(String[] args){

        String input = "abccdba";
        int output = lengthOfLongestSubstring(input);
        System.out.println(output);

    }

}
