//Leetcode #416 Partition Equal Subset Sum


public class PartitionEqualSubsetSum {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {

        int total = 0;

        for(int i : nums){
            total+=i;
        }

        if(total % 2 != 0){
            return false;
        }

        int half = total / 2;

        boolean[] memorization = new boolean[half+1];

        memorization[0]=true;

        for(int i = 1 ;  i<=memorization.length -1 ; i++){
            memorization[i] = false;
        }

        for(int i : nums){
            if(i > half) return false;
            if(memorization[half-i]) return true;
            for(int j = half; j>=i; j--){ // Why j>=i, not quite sure
                memorization[j] = memorization[j] || memorization[Math.abs(j-i)];
            }
        }

        return memorization[half];
    }
}
