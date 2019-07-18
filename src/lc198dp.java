public class lc198dp {
    public int rob(int[] nums) {
        int s = nums.length;
        int dp[] = new int [s+1];
        if(s ==0) return 0;
        dp[0] = nums[0];
        if(s < 2) return dp[0];
        dp[1] = nums[1]>nums[0]?nums[1]:nums[0];
        for(int i = 2; i < s; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[s-1];
    }
}
