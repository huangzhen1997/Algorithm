//LeetCode #201:
//        Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//        Example 1:
//
//        Input: [5,7]
//        Output: 4
//        Example 2:
//
//        Input: [0,1]
//        Output: 0

import java.util.Scanner;

public class BitwiseAND {

    public static void main(String args[]){

        int a,b;
        Scanner  scan = new Scanner(System.in);
        System.out.println("please input m:");
        String ms = scan.nextLine();
        System.out.println("please input n:");
        String ns = scan.nextLine();

        int m = Integer.valueOf(ms);
        int n = Integer.valueOf(ns);

        int output = rangeBitwiseAnd(m , n);

        System.out.println("The m is "+ms+", the n is "+ns+"\nThe output of the AND bitwise is : "+output);
    }


    public static int rangeBitwiseAnd(int m, int n) {
        int shiftCount = 0;
        while(m!=n){
            m = m>>1;
            n = n>>1;
            shiftCount++;
        }
        m = m<<shiftCount;
        return m;
    }
}
