//LeetCode #67

public class  AddBinary{
    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
//        String a = "11";
//        String b ="1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {

        StringBuilder output = new StringBuilder();
        int lengthA = a.length();
        int lengthB = b.length();
        int indexA = lengthA-1;
        int indexB = lengthB-1;
        int carry = 0;
        while(indexA >=0 || indexB >= 0){
            int valueA = (indexA >= 0 ) ? Integer.parseInt(String.valueOf(a.charAt(indexA))) : 0;
            int valueB = (indexB >= 0 ) ? Integer.parseInt(String.valueOf(b.charAt(indexB))) : 0;
            int value = valueA+valueB;
            if(carry==1){
                if(value==2){
                    output.insert(0,"1");
                }
                else if(value==1){
                    output.insert(0,"0");
                }
                else{
                    output.insert(0,"1");
                    carry = 0;
                }
            }

            else{
                if(value==2){
                    output.insert(0,"0");
                    carry = 1;
                }
                else if(value==1){
                    output.insert(0,"1");
                }
                else{
                    output.insert(0,"0");
                }
            }


            indexA--;
            indexB --;
        }

        if(carry ==1){
            output.insert(0,"1");
        }


        return output.toString();
    }
}
