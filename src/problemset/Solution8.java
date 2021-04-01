import java.util.Deque;
import java.util.LinkedList;

public class Solution8 {
    public static void main(String[] args){
        int numComputer = 3;
        int[] hardDiskSpace = new int[]{8,100,4,1};
        int segmentLength = 2;
        System.out.println(maxMinEnergy(numComputer,hardDiskSpace,segmentLength));
    }

    public static int maxMinEnergy(int numComputer,int[] hardDiskSpace, int segmentLength){
        Deque<Integer> dq = new LinkedList<>();
        int maxOuput = Integer.MIN_VALUE;
        for(int i = 0; i< numComputer; i++){
            while(!dq.isEmpty() && dq.getFirst() < i-segmentLength+1){ // i-segmentLength+1 is left window idnex
                dq.removeFirst();
            }
            while(!dq.isEmpty() && hardDiskSpace[dq.getLast()] > hardDiskSpace[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i-segmentLength+1 >=0) maxOuput = Math.max(maxOuput,hardDiskSpace[dq.getFirst()]);
        }
        return maxOuput == Integer.MIN_VALUE ? 0 : maxOuput;
    }
}
