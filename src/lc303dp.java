public class lc303dp {
    int []dp;
    public lc303dp(int[] nums) {
        int s= nums.length;
        System.out.println(s);
        dp = new int[s+1];
        if(s != 0)
            dp[0] = nums[0];
        else
            dp[0] = 0;
        for(int i = 1; i < s; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return dp[j];
        return dp[j]-dp[i-1];
    }
}
