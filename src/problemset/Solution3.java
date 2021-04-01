import java.util.Arrays;
import java.util.List;

//Skill level, combination
// need more testing
// https://www.1point3acres.com/bbs/thread-661422-1-1.html

public class Solution3 {
    public static void main(String[] args){
        List<Integer> skills = Arrays.asList(12,4,6,13,5,10);
        int minLevel = 4;
        int maxLevel = 10;
        int minAssociates = 3;
        System.out.println(totalTeams(skills,minLevel,maxLevel,minAssociates));
    }

    public static int totalTeams(List<Integer> skills,int minLevel, int maxLevel, int minAssociates){
        int total = 0;
        for(int i : skills){
            if(i<=maxLevel && i>=minLevel){
                total++;
            }
        }

        int output = 0;
        for(int i = minAssociates; i<= total; i++){
            output += combination(total,i);
        }

        return  output;
    }

    public static int combination(int n, int r){
        int top = factorial(n);
        int bot = factorial(n-r) * factorial(r);
        return top/bot;
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
}

