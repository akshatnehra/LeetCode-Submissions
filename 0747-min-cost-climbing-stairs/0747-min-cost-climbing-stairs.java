class Solution {
    // Tabulation + space optimized
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = cost[0];
        int prev2 = cost[1];

        for(int i=2; i<cost.length; i++) {
            int temp = prev2;
            prev2 = cost[i] + Math.min(prev1, prev2);
            prev1 = temp;
        }

        return Math.min(prev1, prev2);
    }
}