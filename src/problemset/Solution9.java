import java.util.HashMap;

//count max profit, given suppliers inventory list
//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=661957


public class Solution9 {
    public static void main(String[] args){
        int numSuppliers = 3;
        int[] inventory = new int[]{5,5,5};
        int order = 20;
        System.out.println(profits(numSuppliers,inventory,order));
    }

    public static int profits(int numSuppliers,int[] inventory, int order){
        HashMap<Integer,Integer> mapping = new HashMap<>();

        int maxVal = Integer.MIN_VALUE;
        for(int i : inventory){
            if(maxVal<i) maxVal = i;
            int val = mapping.getOrDefault(i,0);
            mapping.put(i,val+1);
        }

        int profit = 0;

        while(order>0 && maxVal>0){
            int curCount = mapping.get(maxVal);
            if(order<curCount) curCount=order;
            profit += curCount*maxVal;
            maxVal--;
            order-=curCount;
            if(maxVal>0){
                int updateVal = mapping.getOrDefault(maxVal,0);
                mapping.put(maxVal,updateVal+curCount);
            }
        }

        return profit;
    }
}
