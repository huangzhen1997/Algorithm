public class CoinsChange2 {


    public static int change(int amount, int[] coins) {
            int[] dp = new int[amount+1];
            dp[0] = 1;

            for(int coin : coins){
                for(int i = coin; i<= amount;i++){  //combination of coins + previous coins
                    dp[i] += dp[i-coin];
                }
            }
            return dp[amount];
    }


    public static void main(String[] args){
        int[] coins = new int[]{1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
    }
}
