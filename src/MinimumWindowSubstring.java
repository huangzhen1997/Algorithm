//LeetCode #76 Minimum Window Substring
//Facebook Frequent

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args){

        String input = "A";
        String T = "A";
        System.out.println(minWindow(input,T));
    }

    public static String minWindow(String s, String t) {

        if(s.length()==0 || t.length() > s.length()){
            return "";
        }

        String output = "";

        HashMap<Character,Integer> mapping = new HashMap<>();
        int minLength = s.length();
        int leftWindow = 0;
        int rightWindow = 0 ;


        for(Character c : t.toCharArray()){
            int val = mapping.getOrDefault(c,0);
            mapping.put(c,val+1);
        }


        int temp = mapping.getOrDefault(s.charAt(leftWindow),-10000000);
        mapping.put(s.charAt(leftWindow),temp-1);


        while (rightWindow < s.length()){

            while(isValid(mapping) && (leftWindow) <= rightWindow){ // when the match happens

                if( output== "" || rightWindow-leftWindow+1 < minLength){
                    output =s.substring(leftWindow,rightWindow+1);
                    minLength=output.length();
                }


                char oldLeftChar = s.charAt(leftWindow);
                int val = mapping.getOrDefault(oldLeftChar,-1000000);// if not appeared, then don't need to worry, give a -1 so it won't affect the result
                mapping.put(oldLeftChar,val+1);

                leftWindow++;
            }

            rightWindow++;

            if(rightWindow<s.length()){
                int tempVal = mapping.getOrDefault(s.charAt(rightWindow),-10000000);
                mapping.put(s.charAt(rightWindow),tempVal-1);

            }
        }


        return output;
    }

    public static boolean isValid(HashMap<Character,Integer> mapping){
        for(Map.Entry mapElement : mapping.entrySet()){
            if( (int) mapElement.getValue() > 0 ){
                return false;
            }
        }
        return true;
    }
}
