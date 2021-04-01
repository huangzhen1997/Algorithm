import java.util.*;

public class Solution5 {

    //distinct product
    // need to be optimized
    //https://www.1point3acres.com/bbs/thread-661621-1-1.html

    public static void main(String[] args){
        int num = 6;
        int[] ids = new int[]{1,1,1,2,3,3,2,2,3};
        int rem = 2;
        System.out.println(removeItems(num,ids,rem));
    }

    public static int removeItems(int num, int[] ids, int rem){

        Comparator<Map.Entry<Integer,Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };

        HashMap<Integer,Integer> lookup = new HashMap();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue(comp);
        for(int i : ids){
            int val = lookup.getOrDefault(i,0);
            lookup.put(i,val+1);
        }

        for(Map.Entry entry : lookup.entrySet()){
            pq.add(entry);
        }

        int counter = rem;
        while(counter>0){
            if(pq.peek().getValue()>counter){
                break;
            }
            else{
                Map.Entry set = pq.remove();
                int val = (int) set.getValue();
                counter-=val;
            }
        }

        return pq.size();
    }
}
