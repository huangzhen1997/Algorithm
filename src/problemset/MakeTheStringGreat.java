public class MakeTheStringGreat {

    public static void main(String[] args){
        String s = "leetcode";
        String output = makeGood(s);
        System.out.println(output);
    }

    public static String makeGood(String s){
        if(s.length()<=1){
            return s;
        }
        else{
            StringBuilder str = new StringBuilder();
            str.append(s.charAt(0));
            for(int i = 1; i < s.length(); i++){
                if(str.length()>0 && Math.abs(str.charAt(str.length()-1)-s.charAt(i)) == 32){
                    str.deleteCharAt(str.length()-1);
                }
                else{
                    str.append(s.charAt(i));
                }
            }
            return str.toString();
        }
    }
}
