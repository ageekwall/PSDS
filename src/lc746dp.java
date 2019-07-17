public class lc746dp {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int dp[] = new int[size+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        if(size<3) return dp[size-1];
        for(int i = 2; i < size-1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i], dp[i-2]+cost[i]);
        }
        dp[size-1] = Math.min(dp[size-2], dp[size-3]+cost[size-1]);
        return dp[size-1];
    }
}
