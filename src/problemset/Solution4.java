public class Solution4 {
    public static void main(String[] args){
        String input = "3712";
        System.out.println(splitPrime(input));
    }

    public static int splitPrime(String input){

        int limit = (int)Math.pow(10,6);
        boolean[] lookup = new boolean[limit];
        lookup[0] = lookup[1] = false;
        for(int i = 2; i*i< limit ; i++){
            if(lookup[i]==false) continue;
            for(int j = i; j*i < limit; j++ ){
                lookup[i*j] = false;
            }
        }

        return 1;


    }
}
