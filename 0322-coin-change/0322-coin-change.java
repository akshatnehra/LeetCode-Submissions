class Solution {
    int minCoins = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        coinChangeHelper(coins,  amount, 0, dp);

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public void coinChangeHelper(int coins[], int amount, int count, int dp[]) {
        if(amount == 0) {
            minCoins = Math.min(minCoins, count);
        }
        if(amount < 0) {
            return;
        }

        if(dp[amount] <= count) {
            return;
        }

        dp[amount] = count;

        for(int i=0; i<coins.length; i++) {
            coinChangeHelper(coins, amount - coins[i], count+1, dp);
        }
    }
}