//LeetCode #415

public class AddStrings {
    public static void main(String[] args){

        System.out.println(addStrings("0","0"));
    }

    public static String addStrings(String num1, String num2) {

        StringBuilder output = new StringBuilder();
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int counter = 1;
        int carry = 0;


        while(index1 >= 0 || index2 >= 0){
            int value1 = (index1 >= 0 ) ? num1.charAt(index1)  - '0': 0;
            int value2 = (index2 >= 0 ) ? num2.charAt(index2)  - '0': 0;

            int result = (value1+value2+carry) % 10;
            carry = (value1+value2+carry) / 10;
            output.insert(0,String.valueOf(result));

            index1--;
            index2--;
        }

        if(carry != 0){
            output.insert(0,String.valueOf(carry));
        }

        return output.toString();
    }
}
