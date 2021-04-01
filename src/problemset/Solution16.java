public class Solution16 {

    //break palindrome with smallest alphabetical order
    // leetcode #1328
    public static void main(String[] args){
        System.out.println(breakPalindrome("abccba"));
    }

    public static String breakPalindrome(String input){
        int length = input.length();
        char[] s = input.toCharArray();

        for(int i = 0; i< s.length/2 ; i++){
            if(s[i]!='a'){
                s[i]='a';
                return String.valueOf(s);
            }
        }

        s[length-1]='b';
        return length<2 ? "" : String.valueOf(s);
    }
}


//testID 23280665791484