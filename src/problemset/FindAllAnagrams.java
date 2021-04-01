//LeetCode #438
//        Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//        Example 1:
//
//        Input:
//        s: "cbaebabacd" p: "abc"
//
//        Output:
//        [0, 6]
//
//        Explanation:
//        The substring with start index = 0 is "cba", which is= an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//        Example 2:
//
//        Input:
//        s: "abab" p: "ab"
//
//        Output:
//        [0, 1, 2]
//
//        Explanation:
//        The substring with start index = 0 is "ab", which is an anagram of "ab".
//        The substring with start index = 1 is "ba", which is an anagram of "ab".
//        The substring with start index = 2 is "ab", which is an anagram of "ab".

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args){
        String s="cbaebabacd";
        String p="abc";

        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p){

        if (p.length()>s.length()) return new ArrayList<>();
        int windowSize = p.length();
        List<Integer> output=new ArrayList<>();
        int lookUpBuffer[] = new int[26];


        for(int i =0; i<windowSize; i++){
            lookUpBuffer[p.charAt(i)-'a']--;
            lookUpBuffer[s.charAt(i)-'a']++;
        }

        for(int i = windowSize; i<= s.length()-1; i++){

            if(AllZero(lookUpBuffer)){
                output.add(i-windowSize);
            }

            lookUpBuffer[s.charAt(i-windowSize)-'a']--;
            lookUpBuffer[s.charAt(i)-'a']++;
        }

        if(AllZero(lookUpBuffer)){
            output.add(s.length()-windowSize);
        }

        return output;
    }

    public static boolean AllZero(int[] buffer){
        for(int i = 0; i<buffer.length; i++){
            if (buffer[i]!=0) return false;
        }
        return true;
    }
}

