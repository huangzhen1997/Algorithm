//Leetcode #300

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0]=1;
        int maxAns = 1;

        for(int i = 0; i < nums.length;i++){
            int maxInterval = 0;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxInterval = Math.max(dp[j],maxInterval);
                }
            }
            dp[i]=maxInterval+1;
            maxAns=Math.max(dp[i],maxAns);
        }
        return maxAns;
    }
}
