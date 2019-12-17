import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_Brute_Force {

    public static void main(String[] args){

        String input = "abcabcbb";
        int output = lengthOfLongestSubstring(input);
        System.out.println(output);


    }


    public static boolean noduplicate(String s, int start, int end){


        Set<Character> check = new HashSet<>();

        for(int i = start; i < end; i ++){

            if (check.contains(s.charAt(i))){

                return false;

            }

            else {

                check.add(s.charAt(i));
            }
        }

        return true;

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxlength=0;

        for(int i  = 0; i < s.length();i++){

            for (int j = i+1 ; j <= s.length() ; j++){

                if (noduplicate(s,i,j)){

                    maxlength = Math.max(maxlength,j-i);

                }

            }

        }

        return maxlength;
    }
}
