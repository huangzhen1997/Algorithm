public class PrimeString {

    //https://www.1point3acres.com/bbs/thread-661768-1-1.html

    public static void main(String[] args){
        String input = "11373";
        System.out.println(isPrime(29));
//        System.out.println(primeSets(input));
    }

    public static int primeSets(String num){
        return 0;
    }

    public static boolean isPrime(int num){
        boolean flag = true;
        for(int i = 2;i<=num/2;i++){
            if(num%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
