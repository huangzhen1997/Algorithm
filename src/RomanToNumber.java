class RomanToNumber {
    public int romanToInt(String s) {
        int output = toNumber(s.charAt(0));
        for (int i = 1; i<s.length();i++){
            int pre = toNumber(s.charAt(i-1));
            int next = toNumber(s.charAt(i));
            if(next>pre){
                output = output+(next-2*pre);
            }
            else{
                output += next;
            }
        }

        return output;
    }

    public static int toNumber(char input){

        int out = 0;

        switch (input){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }

        return out;
    }
}