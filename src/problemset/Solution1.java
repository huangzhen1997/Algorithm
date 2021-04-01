import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        int numCustomers = 4;
        int[] arrTime = new int[]{0,1,2,3};
        int[] direction = new int[]{1,0,1,0};
        int[] output1 = turnstile(numCustomers,arrTime,direction);
        for(int i : output1){
            System.out.println(i);
        }
    }

    public static int[] turnstile(int numCustomers, int[] arrTIme, int[] direction){

        Queue<List<Integer>> enterQueue = new LinkedList<>();
        Queue<List<Integer>> exitQueue = new LinkedList<>();

        for(int i =0;i < numCustomers; i++){
            if(direction[i]==0){
                enterQueue.offer(Arrays.asList(i,arrTIme[i]));
            }
            else{
                exitQueue.offer(Arrays.asList(i,arrTIme[i]));
            }
        }

        int[] output = new int[numCustomers];
        int clock = 0;
        boolean lastExit = true;
        while(!enterQueue.isEmpty() && !exitQueue.isEmpty()){

            int topExitT = exitQueue.peek().get(1);
            int topEnterT = enterQueue.peek().get(1);

            if(topEnterT < clock){
                topEnterT = clock;
            }

            else{
                if(topEnterT>clock && topExitT>clock){
                    clock = Math.min(topEnterT,topExitT);
                }
            }

            if(topExitT < clock){
                topExitT = clock;
            }
            else {
                if(topEnterT>clock && topExitT>clock){
                    clock = Math.min(topEnterT,topExitT);
                }
            }

            //conflict
            if(topEnterT==topExitT){
                if(lastExit){
                    output[exitQueue.remove().get(0)]= clock;
                }
                else {
                    output[enterQueue.remove().get(0)] = clock;
                }
            }

            //not conflict
            else{
                //exit first
                if(topEnterT > topExitT){
                    lastExit=true;
                    output[exitQueue.remove().get(0)]= clock;
                }

                //enter first
                else{
                    lastExit=false;
                    output[enterQueue.remove().get(0)] = clock;
                }
            }
            clock++;
        }

        while(!enterQueue.isEmpty()){
            List<Integer> person = enterQueue.remove();
            if(clock<person.get(1)) clock = person.get(1);
            output[person.get(0)] = clock;
            clock++;
        }

        while(!exitQueue.isEmpty()){
            List<Integer> person = exitQueue.remove();
            if(clock<person.get(1)) clock = person.get(1);
            output[person.get(0)]= clock;
            clock++;
        }

        return output;
    }




}
