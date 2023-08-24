class Solution {
    // Rec + memo
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length+1;
        int dp[] = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = -1;
        }

        minCostClimbingStairsHelper(cost, cost.length, dp);

        return dp[n-1];
    }

    public int minCostClimbingStairsHelper(int cost[], int index, int dp[]) {
        if(index == 0 || index == 1) {
            return cost[index];
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int prev1 = index-1  > 1 ? minCostClimbingStairsHelper(cost, index-1, dp)+cost[index-1] : minCostClimbingStairsHelper(cost, index-1, dp);
        int prev2 = index-2  > 1 ? minCostClimbingStairsHelper(cost, index-2, dp)+cost[index-2] : minCostClimbingStairsHelper(cost, index-2, dp);
        dp[index] = Math.min(prev1, prev2);
        return dp[index];
    }
}
